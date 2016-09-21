<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/adminheader.jsp" />

<body>

<h2 style="margin-left: 50px; color: #23527c">${dish.name}</h2>
<div style="width: 75%; margin-left: 20px">

    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:dimgrey">
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

<hr>
<h3 style="margin-left: 50px; color: #23527c">Составляющие блюда:</h3>

<div style="width: 20%; margin-left: 20px">
    <table border="0.2" style="align-items: center" class="table table-striped">
    <thead style = "color:white;background-color:dimgrey">
    <tr>
        <th>Название ингредиента</th>
    </tr>
    </thead>

        <c:forEach items="${ingredients}" var="ingredient">
        <tr>
            <td>${ingredient.name}</td>
        </tr>

        </c:forEach>

</div>


<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>

