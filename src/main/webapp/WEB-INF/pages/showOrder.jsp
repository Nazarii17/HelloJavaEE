<%@ page import="nazarii.tkachuk.com.entities.Product" %>
<%@ page import="nazarii.tkachuk.com.entities.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="nazarii.tkachuk.com.entities.Order" %>
<%@ page import="nazarii.tkachuk.com.entities.Customer" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.11.2019
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information about the Order</title>
</head>
<body>
<h1>Information about the Order</h1>
<hr>

<p>
    <button onclick="window.location.href='/menu'">Menu</button>
</p>

<hr>

<%
    Order order = (Order) request.getAttribute("order");
%>

<p>
    ID: <%=order.getId()%>
</p>

<p>
    Date: <%=order.getOrderDate()%>
</p>

<p>
    Quantity: <%=order.getQuantity()%>
</p>

<%
    for (Customer customer : (List<Customer>) request.getAttribute("customerList")) {
        if (customer.getId().equals(order.getCustomerID())) {
%>

<p>
    Ordered by: <%=customer.getName() + " " + customer.getLastName()%>
</p>

<%
        }
    }
%>

<%
    for (Product product : (List<Product>) request.getAttribute("productList")) {
        if (product.getId().equals(order.getProductID())) {
%>

<p>
    Product: <%=product.getName()%>
</p>

<%
        }
    }
%>

<p>
    Price: <%=order.getPrice()%>
</p>

<hr>

<button onclick="window.location.href='/order/all'">All Products</button>

</body>
</html>
