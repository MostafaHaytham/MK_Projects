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
    public partial class Register : System.Web.UI.Page
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
                Response.Redirect("Default.aspx", true);
            }
        
            if (!IsPostBack)
            {
                accountsForm.Visible = true;
                menuForm.Visible = false;
                addAccBtn.Visible = false;
                addMenuBtn.Visible = true;
            }
        }

        protected void ShowAccountForm(object sender, EventArgs e)
        {
            accountsForm.Visible = true;
            menuForm.Visible = false;
            addAccBtn.Visible = false;
            addMenuBtn.Visible = true;
        }

        protected void ShowMenuForm(object sender, EventArgs e)
        {
            accountsForm.Visible = false;
            menuForm.Visible = true;
            addAccBtn.Visible = true;
            addMenuBtn.Visible = false;
        }

        protected void AddAccount(object sender, EventArgs e)
        {
            accountWarningMessage.InnerText = " ";
            if (!(String.IsNullOrEmpty(userName.Text) || String.IsNullOrEmpty(password1.Text) || String.IsNullOrEmpty(conPassword.Text) || String.IsNullOrEmpty(companyName.Text)))
            {
                MySqlConnection con = new MySqlConnection("server=localhost;user id=root;persistsecurityinfo=True;database=tasbera");
                con.Open();
                MySqlCommand cmd = new MySqlCommand("SELECT * FROM accounts WHERE UserName='" + userName.Text.ToLower() + "'", con);
                MySqlDataAdapter sda = new MySqlDataAdapter(cmd);
                DataTable dt = new DataTable();
                sda.Fill(dt);
                if (dt.Rows.Count > 0)
                {
                    con.Close();
                    accountWarningMessage.InnerText = "**This UserName already exist";
                }
                else if (!password1.Text.Equals(conPassword.Text))
                {
                    con.Close();
                    accountWarningMessage.InnerText = "**Password and confirmed password does not match";
                }
                else
                {
                    String query = "INSERT INTO accounts (UserName,Password,CompanyName)" +
                    "VALUES (@userName,@pass,@company)";
                    cmd = new MySqlCommand(query, con);
                    cmd.Parameters.AddWithValue("@userName", userName.Text.ToLower());
                    cmd.Parameters.AddWithValue("@pass", password1.Text);
                    cmd.Parameters.AddWithValue("@company", companyName.Text);
                    cmd.ExecuteReader();
                    con.Close();
                    Response.Redirect("Register.aspx", true);
                }
            }
            else
            {
                accountWarningMessage.InnerText = "**You must complete the form";
            }
        }
        protected void AddMenu(object sender, EventArgs e)
        {
            menuWarningMessage.InnerText = " ";
            double priceAsDouble = 0;
            if (!(String.IsNullOrEmpty(name.Text) || String.IsNullOrEmpty(description.Text) || String.IsNullOrEmpty(price.Text)))
            {
                MySqlConnection con = new MySqlConnection("server=localhost;user id=root;persistsecurityinfo=True;database=tasbera");
                con.Open();
                MySqlCommand cmd = new MySqlCommand("SELECT * FROM menu WHERE name='" + name.Text.ToUpper() + "'", con);
                MySqlDataAdapter sda = new MySqlDataAdapter(cmd);
                DataTable dt = new DataTable();
                sda.Fill(dt);
                bool priceTest = double.TryParse(price.Text, out priceAsDouble);
                if (dt.Rows.Count > 0)
                {
                    con.Close();
                    menuWarningMessage.InnerText = "**This Name already exist";
                }
                else if (!priceTest)
                {
                    menuWarningMessage.InnerText = "**Wrong format for price";
                    con.Close();
                }
                else if (priceAsDouble <= 1)
                {
                    con.Close();
                    menuWarningMessage.InnerText = "**Price cannot be smaller than 1";
                }
                else
                {
                    String query = "INSERT INTO menu (name,description,price,category)" +
                    "VALUES (@name,@desc,@price,@category)";
                    cmd = new MySqlCommand(query, con);
                    cmd.Parameters.AddWithValue("@name", name.Text.ToUpper());
                    cmd.Parameters.AddWithValue("@desc", description.Text);
                    cmd.Parameters.AddWithValue("@price", price.Text);
                    cmd.Parameters.AddWithValue("@category", category.Text);
                    cmd.ExecuteReader();
                    con.Close();
                    Response.Redirect("Register.aspx", true);
                }
            }
            else
            {
                menuWarningMessage.InnerText = "**You must complete the form";
            }
        }
    }
}