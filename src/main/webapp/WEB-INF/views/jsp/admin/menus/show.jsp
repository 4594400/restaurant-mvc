<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<jsp:include page="../fragments/adminheader.jsp" />

<body>

<h1 style="text-align: center; color: #761c19">Меню: ${menu.name}</h1>

<hr>

<div style="width: 50%; margin-left: 20px">

<h2 style="color: #23527c"> Список блюд: </h2>


    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:dimgrey">
        <tr>
            <th>Название</th>
            <th>Категория</th>
            <th>Цена, грн.</th>
            <th>Вес, гр.</th>
            <th></th>

        </tr>
        </thead>

        <c:forEach items="${menu.dishes}" var="dish">
            <tr>
                <td>${dish.name}</td>
                <td>${dish.dishCategory}</td>
                <td>${dish.price}</td>
                <td>${dish.weight}</td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/menus/${menu.id}/deleteDish/${dish.id}" var="deleteDishFromMenuUrl"/>
                    <a href="${deleteDishFromMenuUrl}">
                        <img src="<c:url value="/resources/images/garbage24.jpg"/>"/>
                    </a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
<hr>
<br>
<br>
<br>
<h2 style="margin-left: 30px; color: #23527c">Добавить блюдо в меню:</h2>
<hr/>


<spring:url value="/admin/menus/${menu.id}/addDish" var="menuActionUrl"/>

<form:form action="${menuActionUrl}" modelAttribute="dish" method="post">

    <spring:bind path="dish">
        <label class="col-sm-2 control-label"><h4>Выберите блюдо:</h4></label>
        <div class="col-sm-2">

            <form:select path="name" class="form-control" multiple="false">
                <form:option value="NONE" label="--SELECT--"/>
                <form:options items="${dishNameList.values()}"/>
            </form:select>
        </div>
    </spring:bind>

    <button type="submit" class="btn-lg btn-primary ">Добавить</button>
</form:form>


<%--<h3>Add Dish to Menu:</h3>
<form action="/menus/addDish" method="post">
    <input type="hidden" name="menuId" id="menuId" value=${menu.id}>
    <label for="dishId">Dish:</label>

<select id="dishId" name="dishId">
    <c:forEach var="list" items="${dishNameList}">
        <option value="${list.key}">${list.value}</option>
    </c:forEach>
</select>
<button class="btn btn-default" onclick="addDishToMenu(${menu.id}, document.getElementById('dishId'))">Add Dish</button>
</form>--%>


<%--<jsp:include page="../fragments/footer.jsp"/>--%>
</body>
</html>

