<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../fragments/header.jsp"/>

<body>

<div style="width: 60%; margin-left: 100px">

    <h2 style="text-align: center; color: #23527c">Наш персонал</h2>

    <table border="0.5" style="align-items: center" class="table ">

        <c:forEach items="${employeeStringMap}" var="employee">
            <tr>
                <c:choose>
                    <c:when test="${not empty employee.value}">
                        <td style="vertical-align: middle" width="150px"> <img src="data:image/jpeg;base64,${employee.value}" width="145" height="169"/> </td>
                    </c:when>
                    <c:otherwise>
                        <td style="vertical-align: middle" width="150px">  <img src="<c:url value="/resources/images/nophoto.jpg"/>" width="145" height="169"/> </td>
                    </c:otherwise>
                </c:choose>

                <td width="300" height="186" style="text-align: center">
                    <h4 style="font-weight: bold"> ${employee.key.name} </h4>
                </td>

                <td height="186">
                    <p style="text-align: justify"> ${employee.key.info} </p>
                </td>
            </tr>
        </c:forEach>
    </table>


</div>
<br/>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
