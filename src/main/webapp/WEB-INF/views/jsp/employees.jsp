<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" style="align-items: center">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone Number</th>
        <th>Position</th>
        <th>Salary</th>
    </tr>
<c:forEach items="${employees}" var="employee">
    <tr>
        <td><a href="/employee?employeeName=${employee.name}"/>${employee.name}</td>
        <td>${employee.surname}</td>
        <td>${employee.phoneNumber}</td>
        <td>${employee.position}</td>
        <td>${employee.salary}</td>
    </tr>
</c:forEach>

</table>

</body>
</html>
