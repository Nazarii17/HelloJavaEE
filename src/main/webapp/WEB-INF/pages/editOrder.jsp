<%@ page import="nazarii.tkachuk.com.entities.Order" %>
<%@ page import="nazarii.tkachuk.com.entities.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="nazarii.tkachuk.com.entities.Product" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.11.2019
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit existed Order</title>
</head>
<body>
<h1>
    Edit existed Order
</h1>
<hr>

<p>
    <button onclick="window.location.href='/menu'">Menu</button>
</p>
<hr>
<%Order order = (Order) request.getAttribute("order");%>

<form action="" method="post">

    <table>
        <tr>
            <td>
                <label for="id">ID</label>
            </td>
            <td>
                <input type="text"
                       title="ID of the order"
                       id="id"
                       disabled
                       value="<%=order.getId()%>"/>
            </td>

            <td>
                <label for="orderDate">Date</label>
            </td>
            <td>
                <input type="datetime-local"
                       title="Choose date of the order"
                       name="orderDate"
                       id="orderDate"
                       value="<%=order.getOrderDate()%>"
                />
            </td>

            <td>
                <label for="quantity">Quantity</label>
            </td>
            <td>
                <input type="number"
                       title="Chose quantity of the ordered product"
                       value="<%=order.getQuantity()%>"
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
                            if (customer.getId().equals(order.getCustomerID())) {
                    %>
                    <option title="Chose customer who made an order"
                            value="<%=customer.getId()%>" selected>
                        <%=customer.getName() + " " + customer.getLastName()%>
                    </option>
                    <%
                    } else {
                    %>
                    <option title="Chose customer who made an order"
                            value="<%=customer.getId()%>">
                        <%=customer.getName() + " " + customer.getLastName()%>
                    </option>
                    <%
                            }
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
                            if (product.getId().equals(order.getProductID())) {
                    %>
                    <option title="Chose ordered product"
                            value="<%=product.getId()%>" selected>
                        <%=product.getName()%>
                    </option>
                    <%
                    } else {
                    %>
                    <option title="Chose ordered product"
                            value="<%=product.getId()%>">
                        <%=product.getName()%>
                    </option>
                    <%
                            }
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
                       value="<%=order.getPrice()%>"
                />
            </td>

        </tr>

    </table>

    <hr>
    <input type="submit" value="Edit Order">

</form>
<hr>

<button onclick="window.location.href='/order/all'">All Orders</button>
<hr>

</body>
</html>
