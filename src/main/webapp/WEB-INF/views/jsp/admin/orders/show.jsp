<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="../fragments/adminheader.jsp" />

<body>

<div style="width: 50%; margin-left: 20px">

    <h2 style="text-align: center; color: #761c19">Заказ: ${order.id}</h2>

    <hr>

    <h2 style="color: #23527c"> Список блюд: </h2>

    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:dimgrey">
        <tr>
            <th>Название</th>
            <th>Категория</th>
            <th>Цена</th>
            <th>Вес</th>
            <th></th>

        </tr>
        </thead>

        <c:forEach items="${order.dishes}" var="dishes">
            <tr>
                <td>${dishes.name}</td>
                <td>${dishes.dishCategory}</td>
                <td>${dishes.price}</td>
                <td>${dishes.weight}</td>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/orders/${order.id}/deleteDish/${dishes.id}" var="deleteDishFromOrderUrl"/>
                    <a href="${deleteDishFromOrderUrl}">
                        <img src="<c:url value="/resources/images/garbage24.jpg"/>"/>
                    </a>
                </td>

            </tr>
        </c:forEach>




    </table>
</div>
<%--<hr>
    <h4>Sum of order: <spring:eval expression="5*3" />   </h4>--%>

<hr>

<h2 style="margin-left: 20px; color: #23527c"> Добавить блюдо в заказ: </h2>

<spring:url value="/admin/orders/${order.id}/addDish" var="menuActionUrl"/>

<form:form action="${menuActionUrl}" modelAttribute="dish" method="post">

    <spring:bind path="dish">
        <label class="col-sm-2 control-label"><h4>Выберите блюдо:</h4></label>
        <div class="col-sm-2">

            <form:select path="name" class="form-control" multiple="false">
                <form:option value="NONE" label="--SELECT--"/>
                <form:options items="${dishNames}"/>
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


<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>

