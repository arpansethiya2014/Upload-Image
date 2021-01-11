<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Product</title>
</head>
<body>
    <div align="center">
        <h1>Create New Product</h1>
        <br />
        <form:form method="POST" action="save" modelAttribute="product">
 
            <table border="0" cellpadding="10">
                <tr>
                    <td>Product Name:</td>
                    <td><form:input path="name" type="text"/></td>
                </tr>
                <tr>
                    <td>Brand:</td>
                    <td><form:input path="brand" type="text" /></td>
                </tr>
                <tr>
                    <td>Made In:</td>
                    <td><form:input path="madein" type="text"/></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><form:input path="price" type="text"/></td>
                </tr>                            
                <tr>
                    <td><form:hidden path="id"/></td>
                    <td colspan="2"><input type="submit" value="Save"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>