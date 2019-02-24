<%@ Page Title="Codes" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Codes.aspx.cs" Inherits="Tasbera.Codes" %>


<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div runat="server">
        <div class='row' style="margin-top: 80px">
            <div class='col-md-6'>
                <p>
                    <asp:Button ID="generateCodesBtn" class='btn btn-default' runat="server" Text="Generate Codes" OnClick="ShowGenerateForm"></asp:Button>
                </p>
            </div>
            <div class='col-md-6'>
                <p>
                    <asp:Button ID="displayCodesBtn" class='btn btn-default' runat="server" Text="Display Codes" OnClick="ShowDisplayForm"></asp:Button>
                </p>
            </div>
        </div>
        <div class='row' style="margin-top: 20px">

            <div class='col-md-6'>
                <div runat="server" id="generateForm">
                    <asp:Label ID="Label1" runat="server" Text="Company Name"></asp:Label>
                    <asp:TextBox ID="companyName" runat="server"></asp:TextBox><br />
                    <br />
                    <asp:Label ID="Label2" runat="server" Text="Expiry Date"></asp:Label>
                    <asp:TextBox ID="expDate" runat="server" TextMode="Date"></asp:TextBox>
                    <br />
                    <br />
                    <asp:Label ID="Label3" runat="server" Text="Amount of Codes"></asp:Label>
                    <asp:TextBox ID="amount" runat="server" TextMode="Number"></asp:TextBox>
                    <br />
                    <br />
                    <p runat="server" id="generateWarningMessage"></p>
                    <p>
                        <asp:Button ID="generateButton" class='btn btn-default' runat="server" Text="Generate" OnClick="generateCodes"></asp:Button>
                    </p>
                </div>

            </div>
            <div class='col-md-6'>
                <div runat="server" id="displayForm">
                    <asp:Label ID="Label5" runat="server" Text="Company Name"></asp:Label>
                    <asp:TextBox ID="companyNameDisplay" runat="server"></asp:TextBox><br />
                    <br />
                    <asp:Label ID="Label6" runat="server" Text="Day"></asp:Label>
                    <asp:TextBox ID="displayDay" runat="server" TextMode="Date"></asp:TextBox><br />
                    <br />
                    <p runat="server" id="displayWarningMessage"></p>
                    <p>
                        <asp:Button ID="displayButton" class='btn btn-default' runat="server" Text="Display" OnClick="displayCodes"></asp:Button>
                    </p>
                    <p>
                        <asp:GridView ID="GridView1" runat="server" Width="594px"  CssClass="mGrid">
                        </asp:GridView>
                    </p>
                </div>

            </div>
        </div>
    </div>
</asp:Content>
