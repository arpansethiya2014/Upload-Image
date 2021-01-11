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
        <h1>Upload Image</h1>
        <br />
        <form:form method="POST" action="upload" modelAttribute="image" enctype="multipart/form-data">
 
            <table border="0" cellpadding="10">
                <tr>
                    <td>Upload Image:</td>
                    <td><form:input path="data" type="file" /></td>
                </tr>
                                            
                <tr>
                    <td colspan="2"><input type="submit" value="Save"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>