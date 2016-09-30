<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<jsp:include page="../jsp/fragments/header.jsp"/>
<body>




<div style="margin-left: 20px">
    <table border=0.2 style="width: 100%">
        <tr style="vertical-align:top">

            <%--First column--%>
            <td width="65%">
                <div style="text-align: center">
                    <img src="<c:url value="/resources/images/menu2.jpg"/>">
                </div>
                <br>
                <br>

                <div style="text-align: left">
                    <spring:url value="/search" var="indexActionUrl"/>
                    <form:form class="form-horizontal" method="get" action="${indexActionUrl}">
                        <div class="container">
                            <div class="row">
                                    <%-- <h4>  Search by name</h4>--%>
                                <div class="search">
                                        <%--<form:input path="searchingName" type="text" class="form-control input-sm" id="searchingName" placeholder="Search" />--%>
                                    <input type="text" class="form-control input-sm" name="name" placeholder="Введите название"/>
                                    <button type="submit" class="btnn btn-primary btn-sm">Поиск</button>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>


                <table border="0.2" style="align-items: center" class="table table-striped">
                    <thead style = "color:white;background-color:#999999">
                    <tr>
                        <th width="200px">Название блюда</th>
                        <th width="100px">Цена, грн.</th>
                        <th width="100px">Вес, гр.</th>
                        <th>Описание</th>
                    </tr>
                    </thead>

                    <c:forEach items="${dishes}" var="dish">
                        <tr>
                            <td><a href="/showdish/${dish.name}">${dish.name}</a></td>
                            <td>${dish.price}</td>
                            <td>${dish.weight}</td>
                            <td>${dish.description}</td>
                        </tr>

                    </c:forEach>
                </table>
            </td>

            <%--Second column--%>

            <td style="margin-top: 30px">
                <div style="margin-top: 30px">
                    <div style="text-align: center">
                        <img src="<c:url value="/resources/images/biglogo2.jpg"/>">
                    </div>

                    <div style="margin-left: 30px">
                        <h4 style="width: 430px">
                            <p style="text-align: justify">Ресторан «CENRAARCHY» расположенный в самом сердце Киева. Это
                                необыкновенно уютное место для Ваших встреч, где Вы сможете отлично отдохнуть, позабыть
                                о
                                серых буднях и просто весело провести время в кругу своих родных, друзей и коллег.</p>
                            <p style="text-align: justify">Презентабельный и стильный дизайн, интеллигентная атмосфера,
                                изысканное меню и демократичные цены неприменно приятно удивят и порадуют гостей нашего
                                ресторана. Но это еще не все, ведь наш главный конек - кухня! У нас действительно очень
                                вкусно кормят!</p>
                            <p style="text-align: justify">В нашем уютном ресторане создано все для того, чтобы Вы
                                провели
                                вечер в теплой компании, без лишнего пафоса и суеты. Здесь все лаконично, легко и
                                ненавязчиво! Мы предлагаем Вам завести новую страницу Ваших семейных традиций: ужинать в
                                ресторане при свечах, отмечать семейные праздники за своим любимым столиком, радоваться
                                успехам друг друга под звуки вечной музыки!</p>
                        </h4>
                    </div>
                    <div style="margin-left: 30px">
                        <table>
                            <tr>
                                <td>
                                    <img src="<c:url value="/resources/images/booking.png"/>">
                                </td>
                                <td>
                                    <h4 style="color: #761c19">
                                        <img src="<c:url value="/resources/images/phone24_2.jpg"/>"> (044) 255-25-25
                                    </h4>
                                </td>
                            </tr>
                        </table>
                    </div>


                </div>
            </td>
        </tr>
    </table>

</div>


</body>
</html>
