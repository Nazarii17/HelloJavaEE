<%@ page import="nazarii.tkachuk.com.entities.Customer" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.11.2019
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit existed Customer</title>
</head>
<body>
<h1>Edit existed Customer</h1>

<%Customer customer = (Customer)request.getAttribute("customer");%>

<form method="post">

    <table>
        <tr>

            <td>
                <label for="id">ID</label>
            </td>
            <td>
                <input type="text"
                       title="ID of the customer"
                       id="id"
                       disabled
                       value="<%=customer.getId()%>"/>
            </td>

            <td>
                <label for="name">Name</label>
            </td>
            <td>
                <input type="text"
                       title="Write the name of the customer"
                       value="<%=customer.getName()%>"
                       id="name"
                       name="name"/>
            </td>

            <td>
                <label for="lastname">Last Name</label>
            </td>
            <td>
                <input type="text"
                       title="Write the last name of the customer"
                       value="<%=customer.getLastName()%>"
                       id="lastname"
                       name="lastname"/>
            </td>

            <td>
                <label for="phonenumber">Phone number</label>
            </td>
            <td>
                <input type="tel"
                       title="Write the phone number of the customer"
                       value="<%=customer.getPhoneNumber()%>"
                       id="phonenumber"
                       name="phonenumber"
                       pattern="[0-9]{3}[0-9]{3}[0-9]{3}"
                       max="9"
                       required/>
            </td>

            <td>
                <label for="email">Email</label>
            </td>
            <td>
                <input type="email"
                       title="Write the email of the customer"
                       value="<%=customer.getEmail()%>"
                       id="email"
                       name="email"/>
            </td>

    </table>

    <hr>
    <input type="submit" value="Edit Customer">

</form>
<hr>

<button onclick="window.location.href='/customer/all'">All Customers</button>

</body>
</html>
