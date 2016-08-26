<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <title>Title</title>

</head>
<body>

<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="/">Home</a></li>
    <li role="presentation"><a href="/employees/">Employees</a></li>
    <li role="presentation"><a href="#">Menu</a></li>
</ul>



<div style="width: 50%">
<table border="1" style="align-items: center" class="table table-striped">
    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Position</th>
        <th></th>
    </tr>
    </thead>

<c:forEach items="${employees}" var="employee">
    <tr>
        <td><a href="/employee/${employee.name}">${employee.name}</a></td>
        <td>${employee.surname}</td>
        <td>${employee.position}</td>
        <td style="align-items: center; width: 20px">
            <a href="/employee/${employee.id}/delete/">Delete</a>
           <%-- <spring:url value="/employees/${employee.id}/delete" var="deleteUrl" />
            <button class="btn btn-danger"
                    onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>--%>

           <%-- <a href="${deleteUrl}">
            <img src="<c:url value="/resources/images/garbage.png"/>" />
            </a>--%>
        </td>
    </tr>

</c:forEach>

</table>
</div>
<br/>



</body>
</html>
