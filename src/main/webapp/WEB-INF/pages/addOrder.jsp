<%@ page import="nazarii.tkachuk.com.entities.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="nazarii.tkachuk.com.entities.Product" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.11.2019
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Order</title>
</head>
<body>
<h1>
    Add new Order
</h1>
<hr>

<p>
    <button onclick="window.location.href='/menu'">Menu</button>
</p>
<hr>

<form action="" method="post">

    <table>
        <tr>
            <td>
                <label for="orderDate">Date</label>
            </td>
            <td>
                <input type="datetime-local"
                       title="Choose date of the order"
                       placeholder="Date"
                       name="orderDate"
                       id="orderDate"
                />
            </td>

            <td>
                <label for="quantity">Quantity</label>
            </td>
            <td>
                <input type="number"
                       title="Chose quantity of the ordered product"
                       placeholder="Quantity"
                       id="quantity"
                       min="0"
                       name="quantity"
                />
            </td>

            <td>
                <label for="customer">Customer </label>
            </td>
            <td>
                <select id="customer" name="customerID">
                    <%
                        for (Customer customer : (List<Customer>) request.getAttribute("customerList")) {
                    %>
                    <option title="Chose customer who made an order"
                            value="<%=customer.getId()%>">
                        <%=customer.getName() + " " + customer.getLastName()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </td>

            <td>
                <label for="product">Product </label>
            </td>
            <td>
                <select id="product" name="productID">
                    <%
                        for (Product product : (List<Product>) request.getAttribute("productList")) {
                    %>
                    <option title="Chose customer who made an order"
                            value="<%=product.getId()%>">
                        <%=product.getName()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </td>

            <td>
                <label for="product">Product </label>
            </td>

            <td>
                <label for="price">Price</label>
            </td>
            <td>
                <input type="number"
                       title="Write price of the order"
                       placeholder="Price"
                       id="price"
                       name="price"
                       min="0.00"
                       step="0.01"
                />
            </td>

        </tr>

    </table>

    <hr>
    <input type="submit" value="Add Order">
    <input type="reset" value="Clean">

</form>
<hr>

<button onclick="window.location.href='/order/all'">All Orders</button>
<hr>

</body>
</html>
