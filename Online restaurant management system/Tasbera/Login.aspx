<%@ Page Title="Login" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="Tasbera.Login" %>



<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div class="jumbotron" style="margin-left: 380px; margin-right: 300px;">

        <asp:Image ID="Image1" runat="server" ImageUrl="~/logo.jpg" Width="400px" Height="200px" />

    </div>
    <div class="row" style="margin-left: 480px;">

        <asp:Label ID="Label1" runat="server" Text="Username"></asp:Label>
        <asp:TextBox ID="TextBox1" runat="server" Width="242px"></asp:TextBox>
        <br />
        <br />
        <asp:Label ID="Label2" runat="server" Text="Password"></asp:Label>
        <asp:TextBox ID="TextBox2" runat="server" Width="242px" TextMode="Password"></asp:TextBox>
        <br />
        <br />

        <asp:Button ID="Button1" class="btn btn-default" runat="server" Text="Login" Height="41px"  Width="112px" Style="margin-left: 80px" OnClick="Button1_Click" />
        <br />
        <br />
        <p runat="server" id="ErrorMessage" style="color: white;">
        </p>


    </div>
    </asp:Content>