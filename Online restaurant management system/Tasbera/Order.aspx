<%@ Page Title="Order" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Order.aspx.cs" Inherits="Tasbera.Order" %>


<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server" >
    <div id="allItems" style="margin-top: 20px">

        <asp:GridView ID="GridView1" runat="server" Width="687px" CssClass="mGrid" AutoGenerateColumns="False">
            <Columns>
                <asp:BoundField DataField="No" HeaderText="No." />
                <asp:BoundField DataField="Name" HeaderText="Name" />
                <asp:BoundField DataField="Quantity" HeaderText="Quantity" />
                <asp:BoundField DataField="Price" HeaderText="Price" />
                <asp:BoundField DataField="Comment" HeaderText="Comment" />
                <asp:TemplateField>
                    <ItemTemplate>
                        <asp:LinkButton ID="removeItem" Text="Remove" style="color:red !important;" runat="server" CommandArgument='<%# Bind("No") %>' OnClick="removeItem" />
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
        <label id="totalPrice" runat="server" style="font-size: 20px"></label>
        <p id="checkoutCode" runat="server">Enter your checkout code: <asp:TextBox ID="codeInput" runat="server"></asp:TextBox></p>
        <asp:Button class='btn btn-default' ID="checkOut" runat="server" Text="Checkout" OnClick="Checkout" /><br />
        <label id="wrongCode" runat="server" style="font-size: 20px"></label>
        <br />

    </div>
    <div class="menuTags">
        <h2>SANDWICHES</h2>
    </div>
    <div runat="server" id="sandwichDiv">
        <%--<div class='row'>
            <div class='col-md-6' style='color: white;'>
                <h3>ZINGER</h3>
                <p>Fried chicken breast + lettuce + sauce + cheddar cheese</p>
                Comment:<input runat='server' type='text' name='text1'><br />
                <br />
                <h3 style='color: #f9ed0f'>28 EGP</h3>
                <p>
                    <asp:LinkButton  class='btn btn-default' runat="server" CustomParameter="1" OnClick="addItem" Text="Button" ></asp:LinkButton>
            </div>
        </div>--%>
    </div>
    <div class="menuTags">
        <h2>MEALS</h2>
    </div>
    <div runat="server" id="mealsDiv">
    </div>
</asp:Content>
