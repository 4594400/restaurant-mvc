<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/adminheader.jsp" />

<body>

<h2 style="margin-left: 50px; color: #23527c"> Информация о сотруднике: </h2>
<br/>

<div style="width: 98%; margin-left: 20px">
    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:dimgrey">
        <tr >
            <th width="150px">Фото</th>
            <th width="150px">Имя</th>
            <th width="150px">Фамилия</th>
            <th width="150px">Дата рождения</th>
            <th width="150px">Телефон</th>
            <th width="150px">Должность</th>
            <th width="150px">Зарплата</th>
            <th>Инфо</th>

        </tr>
        </thead>

        <tr>
            <c:choose>
                <c:when test="${not empty photo}">
                    <td style="vertical-align: middle" width="150px"> <img src="data:image/jpeg;base64,${photo}" width="145" height="169"/> </td>
                </c:when>
                <c:otherwise>
                    <td style="vertical-align: middle" width="150px">  <img src="<c:url value="/resources/images/nophoto.jpg"/>" width="145" height="169"/> </td>
                </c:otherwise>
            </c:choose>

            <td style="vertical-align: middle">${employee.name}</td>
            <td style="vertical-align: middle">${employee.surname}</td>
            <td style="vertical-align: middle">${employee.birthday}</td>
            <td style="vertical-align: middle">${employee.phoneNumber}</td>
            <td style="vertical-align: middle">${employee.position}</td>
            <td style="vertical-align: middle">${employee.salary}</td>
            <td style="vertical-align: middle">${employee.info}</td>

        </tr>

    </table>

</div>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
