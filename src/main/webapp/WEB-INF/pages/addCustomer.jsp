<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.11.2019
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Customer</title>
</head>
<body>

<h1>Add new Customer</h1>
<hr>

<form method="post">

    <table>
        <tr>
            <td>
                <label for="name">Name</label>
            </td>
            <td>
                <input type="text"
                       title="Write the name of the customer"
                       placeholder="Name"
                       id="name"
                       name="name"/>
            </td>

            <td>
                <label for="lastname">Last Name</label>
            </td>
            <td>
                <input type="text"
                       title="Write the last name of the customer"
                       placeholder="Last name"
                       id="lastname"
                       name="lastname"/>
            </td>

            <td>
                <label for="phonenumber">Phone number</label>
            </td>
            <td>
                <input type="tel"
                       title="Write the phone number of the customer"
                       placeholder="Phone number"
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
                       placeholder="Email"
                       id="email"
                       name="email"/>
            </td>

    </table>

    <hr>
    <input type="submit" value="Add Customer">
    <input type="reset" value="Clean">
</form>
<hr>

<button onclick="window.location.href='/customer/all'">All Customers</button>

</body>
</html>
