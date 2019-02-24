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
    public partial class Login : System.Web.UI.Page
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
            Session["companyName"] = "";
            ClientScript.RegisterStartupScript(this.GetType(), "HideMenu", "document.getElementById('Logout').style.display='none';"
                + "document.getElementById('Codes').style.display='none';"
                + "document.getElementById('Register').style.display='none';", true);

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string user = TextBox1.Text;
            string pass = TextBox2.Text;
            MySqlConnection con = new MySqlConnection("server=localhost;user id=root;persistsecurityinfo=True;database=tasbera");
            con.Open();
            MySqlCommand cmd = new MySqlCommand("SELECT * FROM accounts WHERE UserName='" + user.ToLower() + "' and Password='" + pass+"'", con);
            MySqlDataAdapter sda = new MySqlDataAdapter(cmd);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            con.Close();
            if (dt.Rows.Count==1)
            {
                Session["companyName"] = dt.Rows[0][2].ToString();
                Response.Redirect("Default.aspx", true);
            }
            else
            {
                //ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "AlertWrongLogin", "alert('"+dt.Rows[0][0].ToString()+" "+dt.Rows[0][1].ToString()+" ')", true);
                ErrorMessage.InnerText="Wrong Username or Password";
            }

        
        }
    }
}