using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using MySql.Data.MySqlClient;

namespace Tasbera
{
    public partial class Codes : System.Web.UI.Page
    {
        protected override void OnInit(EventArgs e)
        {
            Response.Cache.SetCacheability(HttpCacheability.NoCache);
            Response.Cache.SetNoStore();
            Response.Cache.SetExpires(DateTime.MinValue);

            base.OnInit(e);
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            string company = (string)(Session["companyName"]);
            if (string.IsNullOrEmpty(company))
            {
                ClientScript.RegisterStartupScript(this.GetType(), "HideMenu", "document.getElementById('Logout').style.display='none';"
                + "document.getElementById('Codes').style.display='none';"
                + "document.getElementById('Register').style.display='none';", true);
                Response.Redirect("Default.aspx", true);
            }
            else if (company.Equals("Tasbera"))
            {
                ClientScript.RegisterStartupScript(this.GetType(), "HideMenu", "document.getElementById('Login').style.display='none';", true);
            }
            else
            {
                ClientScript.RegisterStartupScript(this.GetType(), "HideMenu", "document.getElementById('Login').style.display='none';"
                                + "document.getElementById('Register').style.display='none';", true);
                companyName.Visible = false;
                Label1.Visible = false;
                companyNameDisplay.Visible = false;
                Label5.Visible = false;
            }
            if (!IsPostBack)
            {
                generateForm.Visible = true;
                displayForm.Visible = false;
                generateCodesBtn.Visible = false;
                displayCodesBtn.Visible = true;
            }
        }

        protected void ShowGenerateForm(object sender, EventArgs e)
        {
            generateForm.Visible = true;
            displayForm.Visible = false;
            generateCodesBtn.Visible = false;
            displayCodesBtn.Visible = true;
        }

        protected void ShowDisplayForm(object sender, EventArgs e)
        {
            generateForm.Visible = false;
            displayForm.Visible = true;
            generateCodesBtn.Visible = true;
            displayCodesBtn.Visible = false;
        }

        protected void generateCodes(object sender, EventArgs e)
        {
            string company = (string)(Session["companyName"]);
            string companyNa = "";
            if(company.Equals("Tasbera"))
            {
                companyNa = companyName.Text;
            }
            else
            {
                companyNa = company;
            }
            generateWarningMessage.InnerText = " ";
            if (!(String.IsNullOrEmpty(companyNa) || String.IsNullOrEmpty(expDate.Text) || String.IsNullOrEmpty(amount.Text)))
            {

                DateTime expiry = DateTime.Parse(expDate.Text);
                if (expiry < DateTime.Today)
                {
                    generateWarningMessage.InnerText = "**Wrong Date";
                }
                else
                {
                    MySqlConnection con = new MySqlConnection("server=localhost;user id=root;persistsecurityinfo=True;database=tasbera");
                    con.Open();
                    MySqlCommand cmd2 = new MySqlCommand("SELECT * FROM accounts WHERE CompanyName='"
                        + companyNa.ToLower() + "'", con);
                    MySqlDataAdapter sda2 = new MySqlDataAdapter(cmd2);
                    DataTable dt2 = new DataTable();
                    sda2.Fill(dt2);
                    con.Close();
                    if (dt2.Rows.Count == 0)
                    {
                        generateWarningMessage.InnerText = "**Comapny does not exist";
                    }
                    else
                    {
                        con.Open();
                        string expiryFormated = expiry.Year + "-" + expiry.Month + "-" + expiry.Day;
                        MySqlCommand cmd = new MySqlCommand("SELECT * FROM codes WHERE expiryDate='" + expiryFormated + "'", con);
                        MySqlDataAdapter sda = new MySqlDataAdapter(cmd);
                        DataTable dt = new DataTable();
                        sda.Fill(dt);
                        con.Close();
                        int amountOfCodes = int.Parse(amount.Text);
                        string[] codes = new string[amountOfCodes];
                        Random random = new Random();
                        const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                        if (dt.Rows.Count > 0)
                        {
                            for (int i = 0; i < amountOfCodes; i++)
                            {
                                bool codeValid = true;
                                string code;
                                do
                                {
                                    code = new string((Enumerable.Repeat(chars, 5).Select(s => s[random.Next(s.Length)]).ToArray()));
                                    for (int j = 0; j < dt.Rows.Count; j++)
                                    {
                                        if (code.Equals(dt.Rows[j][0].ToString()))
                                        {
                                            codeValid = false;
                                            break;
                                        }
                                    }
                                } while (!codeValid);
                                codes[i] = code;
                            }
                        }
                        else
                        {
                            for (int i = 0; i < amountOfCodes; i++)
                            {
                                codes[i] = new string((Enumerable.Repeat(chars, 5).Select(s => s[random.Next(s.Length)]).ToArray()));
                            }
                        }
                        for (int c = 0; c < amountOfCodes; c++)
                        {
                            con.Open();
                            String query = "INSERT INTO codes (code,companyName,expiryDate,used)" +
                            "VALUES (@code,@companyName,@expiryDate,@used)";
                            cmd = new MySqlCommand(query, con);
                            cmd.Parameters.AddWithValue("@code", codes[c]);
                            cmd.Parameters.AddWithValue("@companyName", companyNa.ToLower());
                            cmd.Parameters.AddWithValue("@expiryDate", expiry);
                            cmd.Parameters.AddWithValue("@used", "no");
                            cmd.ExecuteReader();
                            con.Close();
                        }
                        Response.Redirect("Codes.aspx", true);
                    }
                }
            }
            else
            {
                generateWarningMessage.InnerText = "**You must complete the form";
            }
        }
        protected void displayCodes(object sender, EventArgs e)
        {
            string company = (string)(Session["companyName"]);
            string companyNa = "";
            if (company.Equals("Tasbera"))
            {
                companyNa = companyNameDisplay.Text;
            }
            else
            {
                companyNa = company;
            }
            displayWarningMessage.InnerText = " ";
            if (!(String.IsNullOrEmpty(companyNa) || String.IsNullOrEmpty(displayDay.Text)))
            {
                MySqlConnection con = new MySqlConnection("server=localhost;user id=root;persistsecurityinfo=True;database=tasbera");
                con.Open();
                DateTime date = DateTime.Parse(displayDay.Text);
                string dateFormated = date.Year + "-" + date.Month + "-" + date.Day;
                MySqlCommand cmd = new MySqlCommand("SELECT * FROM codes WHERE companyName='"
                    + companyNa.ToLower() + "'and expiryDate='" + dateFormated + "'", con);
                MySqlDataAdapter sda = new MySqlDataAdapter(cmd);
                DataTable dt = new DataTable();
                sda.Fill(dt);
                GridView1.DataSource = dt;
                GridView1.DataBind();
                cmd.Dispose();
                con.Close();
            }
            else
            {
                displayWarningMessage.InnerText = "**You must complete the form";
            }
        }
    }

}