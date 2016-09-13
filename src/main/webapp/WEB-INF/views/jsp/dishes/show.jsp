<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/header.jsp" />

<body>

<div style="width: 50%; margin-left: 20px">

<table border="1" style="align-items: center" class="table table-striped">
    <tr>
        <th>Name</th>
        <th>Dish Category</th>
        <th>Price</th>
        <th>Weight</th>
    </tr>

    <tr>
        <td>${dish.name}</td>
        <td>${dish.dishCategory}</td>
        <td>${dish.price}</td>
        <td>${dish.weight}</td>
    </tr>


</table>
</div>

<jsp:include page="../fragments/footer.jsp" />
</body>
</html>

