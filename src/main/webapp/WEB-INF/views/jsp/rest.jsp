<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="fragments/header.jsp"/>

<body>

<div style="width: 80%; margin-left: 20px">

    <h1 style="text-align: center; color: #23527c">REST API</h1>


    <table border="1" style="align-items: center" class="table table-striped">
        <thead>
        <tr>
            <th style="text-align: center">Task</th>
            <th style="text-align: center">Get JSON</th>
        </tr>
        </thead>

        <tr>
            <td>Получить список всех сотрудников (только имена и фамилии)</td>
            <td style="align-items: center; width: 20px">
                <a href="/get-json-employee">
                    <img src="<c:url value="/resources/images/json2.jpg"/>"/>
                </a>
            </td>
        </tr>

        <tr>
            <td>Получить сотрудника по ID</td>
            <td>
                <span style="font-weight: bold">enter URL: </span> http://localhost:8080/get-json-employeeById/{id}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8080/get-json-employeeById/2
            </td>
        </tr>

        <tr>
            <td>Найти сотрудника/сотрудников по имени</td>
            <td>
                <span style="font-weight: bold">enter URL: </span> http://localhost:8080/get-json-employeeByName/{name}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8080/get-json-employeeByName/Альфред
            </td>
        </tr>

        <tr>
            <td>Найти сотрудника/сотрудников по фамилии</td>
            <td>
                <span style="font-weight: bold">enter URL: </span>
                http://localhost:8080/get-json-employeeBySurname/{surname}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8080/get-json-employeeBySurname/Гейтов
            </td>
        </tr>

        <tr>
            <td>Найти сотрудника/сотрудников по имени и фамилии</td>
            <td><span style="font-weight: bold">enter URL: </span>
                http://localhost:8080/get-json-employeeByNameAndSurname/{name}/{surname}
                <br>
                <span style="font-weight: bold">example: </span>
                http://localhost:8080/get-json-employeeByNameAndSurname/Джени/Псакова
            </td>
        </tr>

        <tr>
            <td>Получить список всех заказов</td>
            <td style="align-items: center; width: 20px">
                <a href="/get-json-order">
                    <img src="<c:url value="/resources/images/json2.jpg"/>"/>
                </a>
            </td>

        <tr>
            <td>Получить заказ по ID</td>
            <td>
                <span style="font-weight: bold">enter URL: </span> http://localhost:8080/get-json-orderById/{id}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8080/get-json-orderById/3
            </td>
        </tr>

        <tr>
            <td>Получить список только открытых заказов</td>
            <td style="align-items: center; width: 20px">
                <a href="/get-json-openedOrder">
                    <img src="<c:url value="/resources/images/json2.jpg"/>"/>
                </a>
            </td>
        </tr>

        <tr>
            <td>Получить список только закрытых заказов</td>
            <td style="align-items: center; width: 20px">
                <a href="/get-json-closedOrder">
                    <img src="<c:url value="/resources/images/json2.jpg"/>"/>
                </a>
            </td>
        </tr>

        <tr>
            <td>Получить список всех меню (только названия меню без блюд в них)</td>
            <td style="align-items: center; width: 20px">
                <a href="/get-json-menu">
                    <img src="<c:url value="/resources/images/json2.jpg"/>"/>
                </a>
            </td>
        </tr>

        <tr>
            <td>Найти меню по имени</td>
            <td>
                <span style="font-weight: bold">enter URL: </span> http://localhost:8080/get-json-menuByName/{name}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8080/get-json-menuByName/Завтрак
            </td>
        </tr>

        <tr>
            <td>По ID получить меню со списком блюд в этом меню</td>
            <td>
                <span style="font-weight: bold">enter URL: </span> http://localhost:8080/get-json-menuById/{id}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8080/get-json-menuById/2
            </td>
        </tr>


    </table>
</div>
<br/>
<br/>
<br/>
<br/>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>


