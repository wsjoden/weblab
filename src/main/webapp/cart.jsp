<%@ page import="java.util.Collection" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %>
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
<% Collection<ItemInfo> cart = (Collection<ItemInfo>) ItemHandler.getCart();%>
<% if (!cart.isEmpty()) { %>
<p> Your cart: </p>
<ul>
    <%
        Iterator<ItemInfo> it = cart.iterator();
        for (; it.hasNext(); ) {
            ItemInfo item = it.next();
    %>
    <%=item.getName()%> :
    <%=item.getDescription()%>
    <br>
    <% } %>
</ul>
<% } else { %>
<p> Your cart is empty. Try adding stuff to it =) </p>
<% } %>
</body>
</html>