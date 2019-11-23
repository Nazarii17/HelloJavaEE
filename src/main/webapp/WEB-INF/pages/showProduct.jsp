<%@ page import="nazarii.tkachuk.com.entities.Product" %>
<%@ page import="nazarii.tkachuk.com.entities.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.11.2019
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information about the Product</title>
</head>
<body>
<h1>Information about the Product</h1>
<hr>

<%
    Product product = (Product) request.getAttribute("product");
%>

<p>
    ID: <%=product.getId()%>
</p>

<p>
    Name: <%=product.getName()%>
</p>

<p>
    Price: <%=product.getPrice()%>
</p>

<p>
    Discount: <%=product.getDiscount()%>
</p>

<%
    for (Category category : (List<Category>) request.getAttribute("categoryList")) {
        if (category.getId().equals(product.getCategoryID())) {
%>

<p>
    Category: <%=category.getName()%>
</p>

<%
        }
    }
%>

<p>
    Information: <%=product.getInfo()%>
</p>

</body>
</html>
