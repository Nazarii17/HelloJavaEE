<%@ page import="nazarii.tkachuk.com.entities.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="nazarii.tkachuk.com.entities.Category" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.11.2019
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Products</title>
</head>
<body>
<h1>All Products</h1>
<hr>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Discount</th>
        <th>Quantity</th>
        <th>Category</th>
        <th colspan="3">Operations</th>
    </tr>


    <%
        for (Product product : (List<Product>) request.getAttribute("products")) {

    %>
    <tr>
        <td><%=product.getId()%>
        </td>
        <td><%=product.getName()%>
        </td>
        <td><%=product.getPrice()%>
        </td>
        <td><%=product.getDiscount()%>
        </td>
        <td><%=product.getQuantity()%>
        </td>
        <%
            for (Category category : (List<Category>) request.getAttribute("categoryList")) {
                if (category.getId().equals(product.getCategoryID())) {
        %>

        <td><%=category.getName()%>
        </td>

        <td>
            <a href="/syka?id=<%=product.getId()%>">Edit</a>
        </td>

        <td>
            <a href="/product/delete?id=<%=product.getId()%>">Delete</a>
        </td>

        <td>
            <a href="/bla?id=<%=product.getId()%>">Info</a>
        </td>

    </tr>

    <%
                }
            }
        }
    %>
</table>

<hr>

<button onclick="window.location.href='/product/add'">Add new Product</button>

</body>
</html>
