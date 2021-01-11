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
    <h1>Image List</h1>
    <a href="/image">Upload Image</a>
    <br><br>
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th> ID</th>
                <th>Name</th>
                <th>Image</th>
                <th>Type</th>
                <th>Size</th>
                
            </tr>
        </thead>
        <tbody>
        <c:forEach var="image" items="${imagelist}">
            <tr>
                <td>${image.id}</td>
                <td>${image.name}</td>
                <td><img src="${image.url}" alt="Italian Trulli" height="100" width="100"></td>
                <td>${image.type}</td>
                <td>${image.size}</td>
                <td>
                    <!--  <a href="/@{'/edit/' + ${product.id}}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/@{'/delete/' + ${product.id}}">Delete</a>-->
                     <a href="<c:url value="/edit/${image.id}"/>" >Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="<c:url value="/delete/file/${image.id}"/>" >Delete</a> 
                    
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>   
</body>
</html>
