<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/adminheader.jsp" />

<body>

<h2 style="margin-left: 50px; color: #23527c"> Информация о сотруднике: </h2>
<br/>

<div style="width: 50%; margin-left: 20px">
    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:dimgrey">
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Дата рождения</th>
            <th>Телефон</th>
            <th>Должность</th>
            <th>Зарплата</th>
        </tr>
        </thead>

        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.birthday}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.position}</td>
            <td>${employee.salary}</td>
        </tr>

    </table>

</div>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
