<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<jsp:include page="../fragments/header.jsp"/>
<body>

<div style="text-align: center">
    <img src="<c:url value="/resources/images/welcome.jpg"/>">
    <hr/>
</div>

<div style="margin-left: 20px">
    <table style="width: 80%">
        <tr style="vertical-align:top">
            <td>
                <div style="margin-top: 20px">
                    <h4 style="width: 780px">
                        <p style="text-align: justify">Ресторан «CENRAARCHY» расположенный в самом сердце Киева. Это
                            необыкновенно уютное место для Ваших встреч, где Вы сможете отлично отдохнуть, позабыть о
                            серых буднях и просто весело провести время в кругу своих родных, друзей и коллег.</p>
                        <p style="text-align: justify">Презентабельный и стильный дизайн, интеллигентная атмосфера,
                            изысканное меню и демократичные цены неприменно приятно удивят и порадуют гостей нашего
                            ресторана. Но это еще не все, ведь наш главный конек - кухня! У нас действительно очень
                            вкусно кормят!</p>
                        <p style="text-align: justify">В нашем уютном ресторане создано все для того, чтобы Вы провели
                            вечер в теплой компании, без лишнего пафоса и суеты. Здесь все лаконично, легко и
                            ненавязчиво! Мы предлагаем Вам завести новую страницу Ваших семейных традиций: ужинать в
                            ресторане при свечах, отмечать семейные праздники за своим любимым столиком, радоваться
                            успехам друг друга под звуки вечной музыки!</p>
                    </h4>
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

