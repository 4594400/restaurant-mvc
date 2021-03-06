<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../fragments/adminheader.jsp" />

<body>

<div style="width: 50%; margin-left: 20px">

    <h1 style="text-align: center; color: #23527c">Список заказов</h1>


    <spring:url value="/admin/orders/add" var="addUrl"/>
    <button class="btn btn-primary" onclick="location.href='${addUrl}'">Добавить заказ</button>
    <br>
    <br>

    <table class="example sort02 table-autosort:0 table-stripeclass:alternate">
        <thead>
       <%-- <tr>
            <th colspan="7">Table Filtering</th>
        </tr>--%>
        <tr>
            <th class="table-sortable:numeric">ID</th>
            <th class="table-sortable:numeric" >Официант</th>
            <th class="table-sortable:numeric">Номер столика</th>
            <th class="table-sortable:numeric">Дата</th>
            <th class="table-sortable:numeric">Статус заказа</th>
            <th> </th>
            <th> </th>
        </tr>
        <tr>
            <th>Filter:</th>
            <th class="table-filtered"><input name="filter" size="8" onkeyup="Table.filter(this,this)"></th>
            <th class="table-filtered"><input name="filter" size="8" onkeyup="Table.filter(this,this)"></th>
            <th class="table-filtered"><input name="filter" size="8" onkeyup="Table.filter(this,this)"></th>
            <th class="table-filtered"><select onchange="Table.filter(this,this)">
                <option value="">All</option>
                <option value="OPENED">OPENED</option>
                <option value="CLOSED">CLOSED</option>
            </select>
            <th> </th>
            <th> </th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${ordersAttr}" var="order">
            <tr>
                <td><a href="/admin/orders/show/${order.id}">${order.id}</a></td>
                <td>${order.waiter.name}</td>
                <td>${order.tableNumber}</td>
                <td>${order.orderDate}</td>
                <td>${order.orderStatus}</td>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/orders/${order.id}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">
                        <img src="<c:url value="/resources/images/garbage24.jpg"/>"/>
                    </a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/orders/${order.id}/update" var="updateUrl"/>
                    <a href="${updateUrl}">
                        <img src="<c:url value="/resources/images/edit24.png"/>"/>
                    </a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>


</div>
<br/>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
