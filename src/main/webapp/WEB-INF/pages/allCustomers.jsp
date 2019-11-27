<%@ page import="nazarii.tkachuk.com.entities.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.11.2019
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Customers</title>
</head>
<body>
<h1>All Customers</h1>
<hr>

<p>
    <button onclick="window.location.href='/menu'">Menu</button>
</p>

<hr>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Last Name</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th colspan="3">Operations</th>
    </tr>

    <%
        for (Customer customer : (List<Customer>) request.getAttribute("customerList")) {
    %>

    <tr>
        <td><%=customer.getId()%>
        </td>
        <td><%=customer.getName()%>
        </td>
        <td><%=customer.getLastName()%>
        </td>
        <td><%=customer.getPhoneNumber()%>
        </td>
        <td><%=customer.getEmail()%>
        </td>

        <td>
                        <a href="/customer/edit?id=<%=customer.getId()%>">Edit</a>

        </td>

        <td>
            <a href="/customer/delete?id=<%=customer.getId()%>">Delete</a>
        </td>

        <td>
            <a href="/customer/info?id=<%=customer.getId()%>">Info</a>
        </td>

    </tr>

    <%
        }
    %>
</table>

<hr>

<button onclick="window.location.href='/customer/add'">Add new Customer</button>

<hr>

</body>
</html>
