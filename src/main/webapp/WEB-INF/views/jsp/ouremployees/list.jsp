<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../fragments/header.jsp"/>

<body>

<div style="width: 60%; margin-left: 100px">

    <h2 style="text-align: center; color: #23527c">Наш персонал</h2>

    <table border="0.5" style="align-items: center" class="table ">
        <tr>
            <td>
                <table border="0.2" style="align-items: center" class="table ">

                    <tr>
                        <td style="align-items: center" ; width="20%">
                            <img src="<c:url value="/resources/images/alf.jpg"/>"/>
                        </td>
                    <tr>
                        <td style="align-items: center" ; width="20%">
                            <img src="<c:url value="/resources/images/psaki.jpg"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="align-items: center" ; width="20%">
                            <img src="<c:url value="/resources/images/billy.jpg"/>"/>
                        </td>
                    <tr>
                        <td style="align-items: center" ; width="20%">
                            <img src="<c:url value="/resources/images/kissinger.jpg"/>"/>
                        </td>
                    </tr>
                </table>
            </td>

            <td>
                <table border="0.2" style="align-items: center" class="table ">
                    <c:forEach items="${employees}" var="employee">
                        <tr>
                            <td height="186">
                                <h4 style="font-weight: bold"> ${employee.name} </h4>
                            </td>

                            <td height="186">
                                <p style="text-align: justify"> ${employee.info} </p>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </td>
        </tr>
    </table>

    <%--<table border="1" style="align-items: center" class="table ">

        <tr>
            <td style="align-items: center" ; width="20%">
                <img src="<c:url value="/resources/images/alf.jpg"/>"/>
            </td>
        <tr>
            <td style="align-items: center" ; width="20%">
                <img src="<c:url value="/resources/images/psaki.jpg"/>"/>
            </td>
        </tr>
        <tr>
            <td style="align-items: center" ; width="20%">
                <img src="<c:url value="/resources/images/billy.jpg"/>"/>
            </td>
        <tr>
            <td style="align-items: center" ; width="20%">
                <img src="<c:url value="/resources/images/kissinger.jpg"/>"/>
            </td>
        </tr>


        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>
                    <h4 style="font-weight: bold"> ${employee.name} </h4>
                </td>

                <td>${employee.info}</td>
            </tr>
        </c:forEach>


    </table>--%>
</div>
<br/>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>









