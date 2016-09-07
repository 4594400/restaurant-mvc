<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../fragments/header.jsp" />

<body>

<div style="width: 50%; margin-left: 20px">

    <h1 style="text-align: center; color: #23527c">List of ingredient in stock</h1>

    <spring:url value="/warehouses/add" var="addUrl" />
    <button class="btn btn-primary" onclick="location.href='${addUrl}'">Add ingredient to warehouse</button>
    <br>
    <br>

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

        <c:forEach items="${warehouses}" var="warehouse">
            <tr>
                <%--<td><a href="/warehouses/show/${warehouse.ingredient.name}">${warehouse.ingredient.name}</a></td>--%>
                <td>${warehouse.ingredient.name}</td>
                <td>${warehouse.quantity}</td>
                <td>${warehouse.measure}</td>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/warehouses/${warehouse.ingredient.id}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">
                        <img src="<c:url value="/resources/images/garbage24.jpg"/>"/>
                    </a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/warehouses/${warehouse.ingredient.id}/update" var="updateUrl"/>
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