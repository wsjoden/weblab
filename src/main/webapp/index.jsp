<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bo.ItemHandler" %>
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
        .add{
            padding: 5px 5px;
        }
    </style>
</head>
<body>
<h2>Hello World!</h2>
<button class="toCart" onclick="window.location.href='cart.jsp'">Go to Cart</button>

<form action="add">

</form>

<%
    Collection<ItemInfo> items = ItemHandler.getItems();
    Iterator<ItemInfo> it = items.iterator();
    for(;it.hasNext();) {
        ItemInfo item = it.next();
%>
<p>
    <%= item.getName()%> :
    <%= item.getDescription()%>
    <button class="add" onclick="window.location.href='cart.jsp'">Add</button>
    <br>
    <%}%>

</p>
</body>
</html>
