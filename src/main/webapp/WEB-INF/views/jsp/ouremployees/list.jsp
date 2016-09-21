<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../fragments/header.jsp"/>

<body>

<div style="width: 60%; margin-left: 100px">

    <h1 style="text-align: center; color: #23527c">Наш персонал</h1>

    <table border="0.2" style="align-items: center" class="table ">

        <tr>
            <td style="align-items: center" ; width="20%">
                <img src="<c:url value="/resources/images/alf.jpg"/>"/>
            </td>
            <td style="vertical-align: middle" ; width="100px">
                <h4 style="font-weight: bold">Альфред</h4>
            </td>
            <td style="vertical-align: middle" ; width="150px">Директор</td>
            <td style="vertical-align: middle" ;>
                <p style="text-align: justify">Карьеру успешного ресторатора прошел ступень за ступенью, начав с
                    официанта в отеле Метрополь в 1991 году, далее работал барменом, метрдотелем, менеджером бара,
                    заместителем директора, генеральным директором сети ресторанов холдинга Centraarchy</p>

            </td>
        </tr>
        <tr>
            <td style="align-items: center" ; width="20%">
                <img src="<c:url value="/resources/images/psaki.jpg"/>"/>
            </td>
            <td style="vertical-align: middle" ; width="100px">
                <h4 style="font-weight: bold">Джени</h4>
            </td>
            <td style="vertical-align: middle" ; width="150px">Администратор</td>
            <td style="vertical-align: middle" ;>
                <p style="text-align: justify">С сентября 2011 по январь 2014 года работала официантом в ресторане
                    FermA.
                    С января 2014 года по настоящее время является администратором ресторана Centraarchy.
                    В 2014 году с отличием окончила школу сомелье «Миллезим».
                    Свободно владеет итальянским и английским языками.</p>
            </td>
        </tr>
        <tr>
            <td style="align-items: center" ; width="20%">
                <img src="<c:url value="/resources/images/billy.jpg"/>"/>
            </td>
            <td style="vertical-align: middle" ; width="100px">
                <h4 style="font-weight: bold">Билли</h4>
            </td>
            <td style="vertical-align: middle" ; width="150px">Официант</td>
            <td style="vertical-align: middle" ;>
                <p style="text-align: justify">Билли является одним из рекордсменов по размеру средств, переданных на
                    благотворительностью. В период с 1996 по 2007 год, в 2009 и в 2015 годах — самый богатый человек
                    планеты по версии журнала Forbes. В свободное время подрабатывает в ресторане Centraarchy.</p>
            </td>
        </tr>
        <tr>
            <td style="align-items: center" ; width="20%">
                <img src="<c:url value="/resources/images/kissinger.jpg"/>"/>
            </td>
            <td style="vertical-align: middle" ; width="100px">
                <h4 style="font-weight: bold">Геннадий</h4>
            </td>
            <td style="vertical-align: middle" ; width="150px">Шеф-повар</td>
            <td style="vertical-align: middle" ;>
                <p style="text-align: justify">Геннадий стал шеф-поваром нового многообещающего ресторана в центре
                    Киева. Он известен широкой публике как автор и ведущий ярких и запоминающихся кулинарных программ,
                    таких
                    как – «Точка кипения», «Адская кухня», «Мастер-шеф». Наш повар любит свою работу и работает для
                    тебя.</p>
            </td>
        </tr>


    </table>
</div>
<br/>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
