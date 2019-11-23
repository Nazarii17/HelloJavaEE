<%@ page import="nazarii.tkachuk.com.entities.Customer" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.11.2019
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information about the Customer</title>
</head>
<body>
<h1>Information about the Customer</h1>
<hr>

<%
    Customer customer = (Customer) request.getAttribute("customer");
%>

<p>
    ID: <%=customer.getId()%>
</p>

<p>
    Name: <%=customer.getName()%>
</p>

<p>
    Last Name: <%=customer.getLastName()%>
</p>

<p>
    Phone Number: <%=customer.getPhoneNumber()%>
</p>

<p>
    Email: <%=customer.getEmail()%>
</p>

<hr>

<button onclick="window.location.href='/customer/all'">All Customers</button>

</body>
</html>
