using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Tasbera.Startup))]
namespace Tasbera
{
    public partial class Startup {
        public void Configuration(IAppBuilder app) {
            ConfigureAuth(app);
        }
    }
}
