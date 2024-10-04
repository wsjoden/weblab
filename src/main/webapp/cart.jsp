<%@ page import="java.util.Collection" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="bo.AddToCartServlet" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>cart</title>
    <style>
        button {
            padding: 10px 20px;
            font-size: 16px;
        }
    </style>
</head>
<body>
<h2>this is the cart</h2>
<button onclick="window.location.href='index.jsp'">main page</button>
<%  ArrayList<Integer> cartIds = (ArrayList<Integer>) session.getAttribute("cart");
    ArrayList<ItemInfo> cart = (ArrayList<ItemInfo>) ItemHandler.getItemsByIds(cartIds);
%>
<% if (cart != null) { %>
<p> Your cart: </p>
<ul>
    <%
        for (int i = 0; i < cart.size();i++) {
    %>
    <%=cart.get(i).toString()%>
    <br>
    <% } %>
</ul>
<% } else { %>
<p> Your cart is empty. Try adding stuff to it =) </p>
<% } %>
</body>
</html>