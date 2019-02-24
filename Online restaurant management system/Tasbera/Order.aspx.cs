using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using MySql.Data.MySqlClient;
using System.Data;

namespace Tasbera
{
    public partial class Order : System.Web.UI.Page
    {
        static DataTable order = new DataTable();
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
            }
            else if (company.Equals("Tasbera"))
            {
                ClientScript.RegisterStartupScript(this.GetType(), "HideMenu", "document.getElementById('Login').style.display='none';", true);
            }
            else
            {
                ClientScript.RegisterStartupScript(this.GetType(), "HideMenu", "document.getElementById('Login').style.display='none';"
                                + "document.getElementById('Register').style.display='none';", true);
            }
        
            if (!IsPostBack)
            {
                order.Rows.Clear();
                order.Columns.Clear();
                order.Columns.Add("No");
                order.Columns.Add("Name");
                order.Columns.Add("Price");
                order.Columns.Add("Comment");
                order.Columns.Add("Quantity");
                checkOut.Visible = false;
                totalPrice.Visible = false;
                checkoutCode.Visible = false;
            }
            MySqlConnection con = new MySqlConnection("server=localhost;user id=root;persistsecurityinfo=True;database=tasbera");
            con.Open();
            MySqlCommand cmd = new MySqlCommand("SELECT * FROM menu WHERE category='sandwiches'", con);
            MySqlDataAdapter sda = new MySqlDataAdapter(cmd);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            con.Close();
            Button[] btn = new Button[dt.Rows.Count];
            TextBox[] textb = new TextBox[dt.Rows.Count];
            for (int i = 0; i < dt.Rows.Count; i++)
            {
                if (i % 2 == 0)
                {
                    sandwichDiv.Controls.Add(new LiteralControl("<div id='row1' class='row'>"));
                }
                string htmlCode = "<div class='col-md-6' style='color: white;'>";
                htmlCode += "<h3>" + dt.Rows[i][0] + "</h3><p>" + dt.Rows[i][1] + "</p>";
                htmlCode += "<h3 style='color: #f9ed0f'>" + dt.Rows[i][2] + "</h3>";
                htmlCode += "<p>Comment: ";
                textb[i] = new TextBox();
                textb[i].ID = "sandwiches" + i;
                btn[i] = new Button();
                btn[i].CssClass = "btn btn-default";
                btn[i].Text = "Add item";
                btn[i].Click += addItem;
                btn[i].Attributes["name"] = dt.Rows[i][0].ToString();
                btn[i].Attributes["price"] = dt.Rows[i][2].ToString();
                btn[i].Attributes["textBoxId"] = "sandwiches" + i;
                sandwichDiv.Controls.Add(new LiteralControl(htmlCode));
                sandwichDiv.Controls.Add(textb[i]);
                sandwichDiv.Controls.Add(new LiteralControl("</p>"));
                sandwichDiv.Controls.Add(btn[i]);
                sandwichDiv.Controls.Add(new LiteralControl("</div>"));
                if (i % 2 != 0)
                {
                    sandwichDiv.Controls.Add(new LiteralControl("</div><br/>"));
                }

            }
            con.Open();
            MySqlCommand cmd2 = new MySqlCommand("SELECT * FROM menu WHERE category='meals'", con);
            MySqlDataAdapter sda2 = new MySqlDataAdapter(cmd2);
            DataTable dt2 = new DataTable();
            sda2.Fill(dt2);
            con.Close();
            Button[] btn2 = new Button[dt2.Rows.Count];
            TextBox[] textb2 = new TextBox[dt2.Rows.Count];
            for (int j = 0; j < dt2.Rows.Count; j++)
            {
                if (j % 2 == 0)
                {
                    mealsDiv.Controls.Add(new LiteralControl("<div id='row1' class='row'>"));
                }
                string htmlCode = "<div class='col-md-6' style='color: white;'>";
                htmlCode += "<h3>" + dt2.Rows[j][0] + "</h3><p>" + dt2.Rows[j][1] + "</p>";
                htmlCode += "<h3 style='color: #f9ed0f'>" + dt2.Rows[j][2] + "</h3>";
                htmlCode += "<p>Comment:";
                textb2[j] = new TextBox();
                textb2[j].ID = "meals" + j;
                btn2[j] = new Button();
                btn2[j].CssClass = "btn btn-default";
                btn2[j].Text = "Add item";
                btn2[j].Click += addItem;
                btn2[j].Attributes["name"] = dt2.Rows[j][0].ToString();
                btn2[j].Attributes["price"] = dt2.Rows[j][2].ToString();
                btn2[j].Attributes["textBoxId"] = "meals" + j;
                mealsDiv.Controls.Add(new LiteralControl(htmlCode));
                mealsDiv.Controls.Add(textb2[j]);
                mealsDiv.Controls.Add(new LiteralControl("</p>"));
                mealsDiv.Controls.Add(btn2[j]);
                mealsDiv.Controls.Add(new LiteralControl("</div>"));
                if (j % 2 != 0)
                {
                    mealsDiv.Controls.Add(new LiteralControl("</div><br/>"));
                }

            }



        }
        public void removeItem(object sender, EventArgs e)
        {
            string selectedRequestID = (sender as LinkButton).CommandArgument;
            //ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "AlertWrongLogin", "alert('" + selectedRequestID + "')", true);

            int idRow = int.Parse(selectedRequestID);
            for (int r = 0; r < order.Rows.Count; r++)
            {
                if (r == (idRow - 1))
                {
                    int quantity = int.Parse(order.Rows[r][4].ToString());
                    if (quantity > 1)
                    {
                        double price = double.Parse(order.Rows[r][2].ToString());
                        double priceFor1 = price / quantity;
                        order.Rows[r][4] = --quantity;
                        order.Rows[r][2] = price - priceFor1;

                    }
                    else
                    {
                        order.Rows.Remove(order.Rows[r]);
                    }

                }
            }
            for (int r = 0; r < order.Rows.Count; r++)
            {

                order.Rows[r][0] = r + 1;
            }
            GridView1.DataSource = order;
            GridView1.DataBind();
            if (order.Rows.Count > 0)
            {
                totalPrice.Visible = true;
                double total = 0;
                for (int t = 0; t < order.Rows.Count; t++)
                {
                    total += double.Parse(order.Rows[t]["Price"].ToString());
                }
                totalPrice.InnerText = total.ToString();
                checkOut.Visible = true;
                checkoutCode.Visible = true;
            }
            else
            {
                totalPrice.Visible = false;
                checkOut.Visible = false;
                checkoutCode.Visible = false;
            }
        }
        public void addItem(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            string name = btn.Attributes["name"];
            string price = btn.Attributes["price"];
            string textBoxId = btn.Attributes["textBoxId"];
            string comment = "";
            if (textBoxId.Contains("sandwiches"))
            {
                TextBox txtbox = (TextBox)sandwichDiv.FindControl(textBoxId);
                comment = txtbox.Text.ToString();
            }
            else if (textBoxId.Contains("meals"))
            {
                TextBox txtbox = (TextBox)mealsDiv.FindControl(textBoxId);
                comment = txtbox.Text.ToString();
            }
            bool sandwichAlreadyOrdered = false;
            for (int k = 0; k < order.Rows.Count; k++)
            {
                if (order.Rows[k][1].Equals(name))
                {
                    int quantity = int.Parse(order.Rows[k][4].ToString());
                    quantity += 1;
                    double pri = double.Parse(btn.Attributes["price"]);
                    order.Rows[k][2] = pri * (quantity);
                    order.Rows[k][4] = quantity;
                    sandwichAlreadyOrdered = true;
                }
            }
            if (!sandwichAlreadyOrdered)
            {
                DataRow orderRow = order.NewRow();
                orderRow["No"] = order.Rows.Count + 1;
                orderRow["Name"] = name;
                orderRow["Price"] = price;
                orderRow["Comment"] = comment;
                orderRow["Quantity"] = 1;
                order.Rows.Add(orderRow);
            }
            GridView1.DataSource = order;
            GridView1.DataBind();
            if (order.Rows.Count > 0)
            {
                double total = 0;
                for (int t = 0; t < order.Rows.Count; t++)
                {
                    total += double.Parse(order.Rows[t]["Price"].ToString());
                }
                totalPrice.Visible = true;
                totalPrice.InnerText = total.ToString();
                checkOut.Visible = true;
                checkoutCode.Visible = true;
            }
            else
            {
                totalPrice.Visible = false;
                checkOut.Visible = false;
                checkoutCode.Visible = false;
            }
            //ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "AlertWrongLogin", "alert('" + name+" "+price +" "+comment +"')", true);
        }

        protected void Checkout(object sender, EventArgs e)
        {
            MySqlConnection con = new MySqlConnection("server=localhost;user id=root;persistsecurityinfo=True;database=tasbera");
            con.Open();
            string todayDate = DateTime.Now.Year + "-" + DateTime.Now.Month + "-" + DateTime.Now.Day;
            MySqlCommand cmd2 = new MySqlCommand("SELECT * FROM codes WHERE code='"
                + codeInput.Text.ToUpper() + "' and used='no' and expiryDate>='"
                + todayDate + "'", con);
            MySqlDataAdapter sda2 = new MySqlDataAdapter(cmd2);
            DataTable dt2 = new DataTable();
            sda2.Fill(dt2);
            con.Close();
            if (dt2.Rows.Count==1)
            {
                for (int c = 0; c < order.Rows.Count; c++)
                {
                    con.Open();
                    String query = "INSERT INTO orders (code,companyName,name,quantity,comment,date,delivered)" +
                    "VALUES (@code,@company,@name,@quan,@comment,@date,@deliver)";
                    MySqlCommand cmd = new MySqlCommand(query, con);
                    cmd.Parameters.AddWithValue("@code", codeInput.Text.ToUpper());
                    cmd.Parameters.AddWithValue("@company", dt2.Rows[0][1]);
                    cmd.Parameters.AddWithValue("@name", order.Rows[c][1]);
                    cmd.Parameters.AddWithValue("@quan", order.Rows[c][4]);
                    cmd.Parameters.AddWithValue("@comment", order.Rows[c][3]);
                    cmd.Parameters.AddWithValue("@date", DateTime.Now);
                    cmd.Parameters.AddWithValue("@deliver", "no");
                    cmd.ExecuteReader();
                    con.Close();
                }
                con.Open();
                DateTime expiry = DateTime.Parse(dt2.Rows[0][2].ToString());
                string expiryFormated=expiry.Year+"-"+expiry.Month+"-"+expiry.Day;
                MySqlCommand cmd3 = new MySqlCommand("UPDATE codes SET used='yes' WHERE code='" 
                    + codeInput.Text.ToUpper() + "' and expiryDate='"+expiryFormated+"'", con);
                MySqlDataAdapter sda3 = new MySqlDataAdapter(cmd3);
                cmd3.ExecuteReader();
                con.Close();

                Response.Redirect("Order.aspx", true);
            }
            else
            {
                wrongCode.InnerText = "**Invalid Code!";
            }
        }
    }

}