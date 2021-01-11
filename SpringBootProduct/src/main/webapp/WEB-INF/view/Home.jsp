<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<meta charset="utf-8" />
<title>Product Manager</title>
</head>
<body>
<div align="center">
    <h1>Product List</h1>
    <a href="/new">Create New Product</a>
    <a href="/imagePage">Upload Image</a>
    <br/><br/>
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Brand</th>
                <th>Made In</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.brand}</td>
                <td>${product.madein}</td>
                <td>${product.price}</td>
                <td>
                    <!--  <a href="/@{'/edit/' + ${product.id}}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/@{'/delete/' + ${product.id}}">Delete</a>-->
                    <a href="<c:url value="/edit/${product.id}"/>" >Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="<c:url value="/delete/${product.id}"/>" >Delete</a>
                    
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>   
</body>
</html>
