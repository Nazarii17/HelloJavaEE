<%@ page import="nazarii.tkachuk.com.entities.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="nazarii.tkachuk.com.entities.Product" %>
<%@ page import="nazarii.tkachuk.com.entities.Customer" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.11.2019
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Orders</title>
</head>
<body>
<h1>All Orders</h1>
<hr>

<p>
    <button onclick="window.location.href='/menu'">Menu</button>
</p>
<hr>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Quantity</th>
        <th>Customer</th>
        <th>Product</th>
        <th>Price</th>
        <th colspan="3">Operations</th>
    </tr>

    <%
        for (Order order : (List<Order>) request.getAttribute("orderList")) {
    %>

    <tr>
        <td>
            <%=order.getId()%>
        </td>
        <td>
            <%=order.getOrderDate()%>
        </td>
        <td>
            <%=order.getQuantity()%>
        </td>

        <%
            for (Customer customer : (List<Customer>) request.getAttribute("customerList")) {
                if (customer.getId().equals(order.getCustomerID())) {
        %>
        <td>
            <%=customer.getName() + " " + customer.getLastName()%>

            <%
                    }
                }
            %>
        </td>

        <%
            for (Product product : (List<Product>) request.getAttribute("productList")) {
                if (product.getId().equals(order.getProductID())) {
        %>
        <td>
            <%=product.getName()%>

            <%
                    }
                }
            %>
        </td>

        <td>
            <%=order.getPrice()%>
        </td>

        <td>
            <a href="/order/edit?id=<%=order.getId()%>">Edit</a>

        </td>

        <td>
            <a href="/order/delete?id=<%=order.getId()%>">Delete</a>

        </td>

        <td>
            <a href="/order/info?id=<%=order.getId()%>">Info</a>
        </td>

    </tr>

    <%
        }
    %>
</table>

<hr>

<button onclick="window.location.href='/order/add'">Add new Order</button>

<hr>

</body>
</html>
