<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../fragments/adminheader.jsp" />

<body>

<div style="width: 50%; margin-left: 20px">

    <h1 style="text-align: center; color: #23527c">Приготовленные блюда:</h1>

    <spring:url value="/admin/prepared/add" var="addUrl" />
    <button class="btn btn-primary" onclick="location.href='${addUrl}'">Добавить блюдо</button>
    <br>
    <br>

    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:dimgrey">
        <tr>
            <th>Название</th>
            <th>Категория</th>
            <th>Цена</th>
            <th>Вес</th>
            <th>Дата приготовления</th>
            <th>Имя повара</th>

            <th></th>
            <th></th>
        </tr>
        </thead>

        <c:forEach items="${preparedDishes}" var="preparedDish">
            <tr>
                <td><a href="/admin/dishes/show/${preparedDish.dish.id}">${preparedDish.dish.name}</a></td>
                <td>${preparedDish.dish.dishCategory}</td>
                <td>${preparedDish.dish.price}</td>
                <td>${preparedDish.dish.weight}</td>
                <td>${preparedDish.preparingDate}</td>
                <td>${preparedDish.cooker.name}</td>


                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/prepared/${preparedDish.id}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">
                        <img src="<c:url value="/resources/images/garbage24.jpg"/>"/>
                    </a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/prepared/${preparedDish.id}/update" var="updateUrl"/>
                    <a href="${updateUrl}">
                        <img src="<c:url value="/resources/images/edit24.png"/>"/>
                    </a>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>
<br/>

<jsp:include page="../fragments/footer.jsp" />
</body>
</html>
