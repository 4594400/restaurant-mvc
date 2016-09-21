<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
    <title>Spring MVC Form Handling Example</title>

    <spring:url value="/resources/css/bootstrap.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/mystyle.css" var="myCss"/>
    <link href="${myCss}" rel="stylesheet"/>

    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>

<spring:url value="/" var="urlHome"/>
<spring:url value="/login" var="login"/>
<spring:url value="/logout" var="logout"/>
<spring:url value="/users/add" var="urlAddUser"/>
<spring:url value="/" var="index"/>
<spring:url value="/menus/list" var="admin"/>


<nav class="navbar navbar-inverse ">
    <div class="container">
        <%--<div class="navbar-header">
            <a class="navbar-brand" href="${login}">Log in</a>
        </div>--%>
        <div id="logbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${index}">Site</a></li>
                <li><a href="${admin}">Admin</a></li>
            </ul>
        </div>
    </div>
</nav>


<img src="<c:url value="/resources/images/logo4.jpg"/>" class="img-responsive center-block"/>
<hr>

<nav class="navbar navbar-light" style="background-color: darkorange">
    <ul class="nav navbar-nav">

        <li class="nav-item active">
            <a class="nav-link" href="/menus/list">
                <h4 style="color: #0f0f0f; font-weight: bold">Меню</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/dishes/list">
                <h4 style="color: #0f0f0f; font-weight: bold">Блюда</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/employees/list">
                <h4 style="color: #0f0f0f; font-weight: bold">Персонал</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/warehouses/list">
                <h4 style="color: #0f0f0f; font-weight: bold">Склад</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/orders/list">
                <h4 style="color: #0f0f0f; font-weight: bold">История заказов</h4>
            </a>
        </li>


        <li class="nav-item">
            <a class="nav-link" href="/prepared/list">
                <h4 style="color: #0f0f0f; font-weight: bold">Приготовленные блюда</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/ingredients/list">
                <h4 style="color: #0f0f0f; font-weight: bold">Ингридиенты</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/rest">
                <h4 style="color: #0f0f0f; font-weight: bold">REST</h4>
            </a>
        </li>

    </ul>

</nav>