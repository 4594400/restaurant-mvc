<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../jsp/fragments/header.jsp" />

<body>

<spring:url value="/employee/add" var="addUrl" />


<button class="btn btn-primary" onclick="location.href='${addUrl}'">Add Employee</button>
<br>
<br>


<div style="width: 50%">
    <table border="1" style="align-items: center" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Position</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <c:forEach items="${employees}" var="employee">
            <tr>
                <td><a href="/employee/${employee.name}">${employee.name}</a></td>
                <td>${employee.surname}</td>
                <td>${employee.position}</td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/employee/${employee.id}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">
                        <img src="<c:url value="/resources/images/garbage24.jpg"/>"/>
                    </a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/employee/${employee.id}/edit" var="editUrl"/>
                    <a href="${editUrl}">
                        <img src="<c:url value="/resources/images/edit24.png"/>"/>
                    </a>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>
<br/>

<jsp:include page="../jsp/fragments/footer.jsp" />
</body>
</html>
