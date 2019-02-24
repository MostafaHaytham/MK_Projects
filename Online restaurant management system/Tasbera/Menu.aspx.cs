using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Tasbera
{
    public partial class Menu : System.Web.UI.Page
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
        }
    }
}