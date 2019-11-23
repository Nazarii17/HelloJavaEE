<%@ page import="nazarii.tkachuk.com.entities.Product" %><%--
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

<p>
    Category: <%=product.getCategoryID()%>
</p>

<p>
    Information: <%=product.getInfo()%>
</p>

</body>
</html>
