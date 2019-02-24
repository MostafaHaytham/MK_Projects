<%@ Page Title="Register" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="Tasbera.Register" %>



<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div runat="server">
        <div class='row' style="margin-top: 80px">
            <div class='col-md-6'>
                <p>
                    <asp:Button ID="addAccBtn" class='btn btn-default' runat="server" Text="Go to accounts" OnClick="ShowAccountForm"></asp:Button>
                </p>
            </div>
            <div class='col-md-6'>
                <p>
                    <asp:Button ID="addMenuBtn" class='btn btn-default' runat="server" Text="Go to menu" OnClick="ShowMenuForm"></asp:Button>
                </p>
            </div>
        </div>
        <div class='row' style="margin-top: 20px">

            <div class='col-md-6'>
                <div runat="server" id="accountsForm">
                    <asp:Label ID="Label1" runat="server" Text="Username"></asp:Label>
                    <asp:TextBox ID="userName" runat="server"></asp:TextBox><br />
                    <br />
                    <asp:Label ID="Label2" runat="server" Text="Password"></asp:Label>
                    <asp:TextBox ID="password1" runat="server" TextMode="Password"></asp:TextBox>
                    <br />
                    <br />
                    <asp:Label ID="Label4" runat="server" Text="Confirm Password"></asp:Label>
                    <asp:TextBox ID="conPassword" runat="server" TextMode="Password"></asp:TextBox>
                    <br />
                    <br />
                    <asp:Label ID="Label3" runat="server" Text="Company Name"></asp:Label>
                    <asp:TextBox ID="companyName" runat="server"></asp:TextBox><br />
                    <br />
                    <p runat="server" id="accountWarningMessage"></p>
                    <p>
                        <asp:Button ID="createAcc" class='btn btn-default' runat="server" Text="Create new account" OnClick="AddAccount"></asp:Button>
                    </p>
                </div>

            </div>
            <div class='col-md-6'>
                <div runat="server" id="menuForm">
                    <asp:Label ID="Label5" runat="server" Text="Name"></asp:Label>
                    <asp:TextBox ID="name" runat="server"></asp:TextBox><br />
                    <br />
                    <asp:Label ID="Label6" runat="server" Text="Description"></asp:Label>
                    <asp:TextBox ID="description" runat="server"></asp:TextBox><br />
                    <br />
                    <asp:Label ID="Label7" runat="server" Text="Price"></asp:Label>
                    <asp:TextBox ID="price" runat="server"></asp:TextBox><br />
                    <br />
                    <asp:Label ID="Label8" runat="server" Text="Category"></asp:Label>
                    <asp:DropDownList ID="category" runat="server">
                        <asp:ListItem Text="Sandwiches" Value="sandwiches" Selected="true" />
                        <asp:ListItem Text="Meals" Value="meals" />
                    </asp:DropDownList><br />
                    <br />
                    <p runat="server" id="menuWarningMessage"></p>
                    <p>
                        <asp:Button ID="Button2" class='btn btn-default' runat="server" Text="Add to menu" OnClick="AddMenu"></asp:Button>
                    </p>
                </div>

            </div>
        </div>
    </div>
</asp:Content>

