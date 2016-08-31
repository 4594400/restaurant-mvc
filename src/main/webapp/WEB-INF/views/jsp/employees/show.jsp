<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/header.jsp" />

<body>

<table border="1" style="align-items: center" class="table table-striped">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone Number</th>
        <th>Position</th>
        <th>Salary</th>
    </tr>

    <tr>
        <td>${employee.name}</td>
        <td>${employee.surname}</td>
        <td>${employee.phoneNumber}</td>
        <td>${employee.position}</td>
        <td>${employee.salary}</td>
    </tr>


</table>

<jsp:include page="../fragments/footer.jsp" />
</body>
</html>
