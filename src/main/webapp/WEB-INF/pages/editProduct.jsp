<%@ page import="nazarii.tkachuk.com.entities.Product" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.11.2019
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <hr>
    <title>Edit existed Product</title>
</head>
<body>

<h1>
    Edit existed Product
</h1>
<hr>

<%Product product = (Product) request.getAttribute("product");%>

<form action="" method="post">

    <table>
        <tr>
            <td>
                <label for="id">ID</label>
            </td>
            <td>
                <input type="text"
                       title="ID of the product"
                       id="id"
                       disabled
                       value="<%=product.getId()%>"/>
            </td>

            <td>
                <label for="name">Name</label>
            </td>
            <td>
                <input type="text"
                       title="Write name of the product"
                       id="name"
                       name="name"
                       value="<%=product.getName()%>"/>
            </td>

            <td>
                <label for="price">Price</label>
            </td>
            <td>
                <input type="text"
                       title="Write price of the product"
                       id="price"
                       name="price"
                       value="<%=product.getPrice()%>"/>
            </td>

            <td>
                <label for="discount">Discount </label>
            </td>
            <td>
                <input type="number"
                       title="Chose discount of the product"
                       id="discount"
                       min="0" max="100"
                       name="discount"
                       value="<%= product.getDiscount() %>"/>
            </td>

        </tr>

    </table>

    <p>
        <label for="info" class="form-field__label">Information</label>
        <textarea id="info"
                  name="info"
                  class="form-field__textarea"
                  title="Write information about the product"
                  style=" min-width: 80%; max-width:100%;
                          min-height: 150px ; max-height: 100%">

        </textarea>
    </p>

    <hr>
    <input type="submit" value="Edit Product">
    <input type="reset" value="Clean">
</form>
<hr>

<button onclick="window.location.href='/products/all'">All Products</button>

</body>
</html>
