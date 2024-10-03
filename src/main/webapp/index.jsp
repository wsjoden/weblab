<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="bo.Item" %>
<html>
<head>
    <title>
        main page
    </title>
    <style>
        button {
            font-size: 16px;
        }
        .toCart {
            padding: 10px 20px;
        }
        .clearSession {
            padding: 5px 5px;
            position: absolute;
            top: 10px;
            right: 10px;
            color: white;
            background-color: indianred;
        }
        .loggin {
            position: absolute;
            top: 50px;
            right: 10px;
        }
    </style>
</head>
<body>
<h2>Item Page</h2>

<button class="toCart" onclick="window.location.href='cart.jsp'">Go to Cart</button>

<%
    Collection<ItemInfo> items = ItemHandler.getItems();
    Iterator<ItemInfo> it = items.iterator();
    while (it.hasNext()) {
        ItemInfo item = it.next();
%>
<p>
        <%= item.getName()%> :
        <%= item.getDescription()%>
    <form action="addToCart" method="post">
        <input type="hidden" name="itemId" value="<%= item.getId() %>"/>
        <input type="hidden" name="action" value="addToCart">
        <input type="submit" value="add"/>
    </form>
<%}%>
</p>

<form action="login" method="post" class="loggin">
    Username: <input type="text" name="username"><br>
    Password: <input type="text" name="password"><br>
</form>

<form action="clearSession" method="post" class="clearSession">
        <input type="hidden" name="action" value="clearSession" >
        <input type="submit" value="Clear Session"/>
</form>

</body>
</html>
