<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<jsp:include page="../fragments/header.jsp" />

<body>

<div style="width: 50%; margin-left: 20px">

    <h1 style="text-align: center; color: #23527c">List of ingredient in stock</h1>

    <spring:url value="/warehouses/add" var="addUrl" />
    <button class="btn btn-primary" onclick="location.href='${addUrl}'">Add ingredient to warehouse</button>
    <br>
    <br>


<spring:url value="/warehouses/search" var="warehouseActionUrl" />
<form:form class="form-horizontal" method="get" action="${warehouseActionUrl}">
    <div class="container">
        <div class="row">
            <h4>  Search by name</h4>
            <div class="search">
                <%--<form:input path="searchingName" type="text" class="form-control input-sm" id="searchingName" placeholder="Search" />--%>
                <input type="text" class="form-control input-sm"  name="name" placeholder="Search" />
                <button type="submit" class="btnn btn-primary btn-sm">Search</button>
            </div>
        </div>
    </div>
    </form:form>

    <hr>

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

        </c:forEach>

    </table>
</div>
<br/>

<jsp:include page="../fragments/footer.jsp" />
</body>
</html>
