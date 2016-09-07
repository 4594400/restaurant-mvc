<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<jsp:include page="../fragments/header.jsp"/>
<body>

<div style="margin-left: 20px">
    <table style="width: 80%">
        <tr style="vertical-align:top">
            <td>
                <div style="margin-top: 20px">
                    <h4 style="width: 780px">Ресторан «CENRAARCHY» расположенный в самом сердце Киева. Это необыкновенно
                        уютное место для Ваших встреч, где Вы сможете отлично отдохнуть, позабыть о серых буднях и
                        просто весело провести время в кругу своих родных, друзей и коллег.</h4>
                    <br>
                    <br>
                    <br>
                    <h2><span class="label label-default">Контакты:</span></h2>
                    <br>
                    <h4 style="color: #761c19">
                        <img src="<c:url value="/resources/images/phone24_2.jpg"/>"> (044) 255-25-25
                    </h4>
                    <h4>
                        <img src="<c:url value="/resources/images/address24.jpg"/>"> г. Киев, ул. Крещатик 2
                    </h4>
                    <h4>
                        <img src="<c:url value="/resources/images/email24.jpg"/>"> mail@mafia.com
                    </h4>

                </div>
            </td>

            <td style="margin-top: 20px">
                <h4>КАРТА ПРОЕЗДА</h4>
                <img src="<c:url value="/resources/images/map.png"/>">
            </td>
        </tr>
    </table>

</div>


</body>
</html>

