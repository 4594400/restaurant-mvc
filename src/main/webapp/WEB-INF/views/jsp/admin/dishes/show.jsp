<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="../fragments/adminheader.jsp"/>

<body>

<h2 style="margin-left: 50px; color: #23527c">${dish.name}</h2>
<div style="width: 98%; margin-left: 20px">

    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style="color:white; background-color:#4387d0">
        <tr>
            <th width="200px">Название блюда</th>
            <th width="100px">Цена, грн.</th>
            <th width="100px">Вес, гр.</th>
            <th width="100px">Категория</th>
            <th>Описание</th>
        </tr>
        </thead>

        <tr>
            <td>${dish.name}</td>
            <td>${dish.price}</td>
            <td>${dish.weight}</td>
            <td>${dish.dishCategory}</td>
            <td>${dish.description}</td>
        </tr>
    </table>
</div>

<hr/>
<h3 style="margin-left: 50px; color: #23527c">Составляющие блюда:</h3>

<div style="width: 20%; margin-left: 20px">
    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style="color:white; background-color:#a947e4">
        <tr>
            <th>Название ингредиента</th>
            <th></th>
        </tr>
        </thead>

        <c:forEach items="${ingredients}" var="ingredient">
            <tr>
                <td>${ingredient.name}</td>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/dishes/${dish.id}/deleteIngredient/${ingredient.id}" var="deleteIngredientFromDishUrl"/>
                    <a href="${deleteIngredientFromDishUrl}">
                        <img src="<c:url value="/resources/images/garbage24.jpg"/>"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<hr/>
<br>


<div>
    <h2 style="margin-left: 30px; color: #23527c">Добавить ингредиент в блюдо:</h2>
    <hr/>


    <spring:url value="/admin/dish/${dish.id}/addIngredient" var="dishActionUrl"/>

    <form:form action="${dishActionUrl}" modelAttribute="ingredient" method="post">

        <spring:bind path="ingredient">
            <label class="col-sm-2 control-label"><h4>Выберите ингредиент:</h4></label>
            <div class="col-sm-2">

                <form:select path="name" class="form-control" multiple="false">
                    <form:option value="NONE" label="--SELECT--"/>
                    <form:options items="${ingredientNames}"/>
                </form:select>
            </div>
        </spring:bind>

        <button type="submit" class="btn-lg btn-primary ">Добавить</button>
    </form:form>

</div>

<br/>
<br/>
<br/>
<br/>


<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>

