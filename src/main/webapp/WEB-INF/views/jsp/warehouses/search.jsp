<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="../fragments/header.jsp"/>

<body>

<div style="width: 50%; margin-left: 20px">


    <h2 style="text-align: center; color: #23527c">Список ингридиентов на складе</h2>
    <hr>

    <spring:url value="/warehouses/search" var="warehouseActionUrl"/>
    <form:form class="form-horizontal" method="get" action="${warehouseActionUrl}">
        <div class="container">
            <div class="row">
                <div class="search">
                    <input type="text" class="form-control input-sm" name="name" placeholder="Введите название"/>
                    <button type="submit" class="btnn btn-primary btn-sm">Поиск</button>
                </div>
            </div>
        </div>
    </form:form>

    <table border="1" style="align-items: center" class="table table-striped">
        <thead>
        <tr>
            <th>Ingredient</th>
            <th>Quantity</th>
            <th>Measure</th>
            <th></th>
            <th></th>
        </tr>
        </thead>


        <tr>
            <td>${warehouse.ingredient.name}</td>
            <td>${warehouse.quantity}</td>
            <td>${warehouse.measure}</td>

            <td style="align-items: center; width: 20px">
                <spring:url value="/warehouses/${warehouse.id}/delete" var="deleteUrl"/>
                <a href="${deleteUrl}">
                    <img src="<c:url value="/resources/images/garbage24.jpg"/>"/>
                </a>
            </td>
            <td style="align-items: center; width: 20px">
                <spring:url value="/warehouses/${warehouse.id}/update" var="updateUrl"/>
                <a href="${updateUrl}">
                    <img src="<c:url value="/resources/images/edit24.png"/>"/>
                </a>
            </td>
        </tr>


    </table>
</div>
<br/>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>

