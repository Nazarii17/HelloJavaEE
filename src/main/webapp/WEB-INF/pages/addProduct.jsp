<%@ page import="nazarii.tkachuk.com.entities.Category" %>
<%@ page import="java.util.List" %><%--
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
    <title>Add new Product</title>
</head>
<body>

<h1>
    Add new Product
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
                <label for="name">Name</label>
            </td>
            <td>
                <input type="text"
                       title="Write name of the product"
                       placeholder="Name"
                       id="name"
                       name="name"/>
            </td>

            <td>
                <label for="price">Price</label>
            </td>
            <td>
                <input type="text"
                       title="Write price of the product"
                       placeholder="Price"
                       id="price"
                       name="price"/>
            </td>

            <td>
                <label for="category">Category </label>
            </td>
            <td>
                <select id="category" name="categoryID">
                    <%
                        for (Category category : (List<Category>) request.getAttribute("categoryList")) {
                    %>
                    <option title="Chose category of the product"
                            value="<%=category.getId()%>">
                        <%=category.getName()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </td>

            <td>
                <label for="quantity">Quantity</label>
            </td>
            <td>
                <input type="number"
                       title="Chose quantity of the product"
                       placeholder="Quantity"
                       id="quantity"
                       min="0"
                       name="quantity"/>
            </td>

            <td>
                <label for="discount">Discount </label>
            </td>
            <td>
                <input type="number"
                       title="Chose discount of the product"
                       placeholder="Discount "
                       id="discount"
                       min="0" max="100"
                       name="discount"/>
            </td>

        </tr>

    </table>

    <p>
        <label for="info" class="form-field__label">Information</label>
        <textarea id="info"
                  name="info"
        <%--                  class="form-field__textarea"--%>
                  title="Write information about the product"
                  placeholder="Information"
                  style=" min-width: 80%; max-width:100%;
                          min-height: 150px ; max-height: 100%"
        ></textarea>
    </p>

    <hr>
    <input type="submit" value="Add Product">
    <input type="reset" value="Clean">
</form>
<hr>

<button onclick="window.location.href='/product/all'">All Products</button>

<hr>

</body>
</html>
