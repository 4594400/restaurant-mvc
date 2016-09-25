<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login page</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />"  rel="stylesheet"/>
    <link type="text/css" href="/resources/css/login.css" rel="stylesheet" />
</head>
<body>
<div class="container">
    <section id="content">
        <c:url var="loginUrl" value="/login" />
        <form action="${loginUrl}" method="post" class="form-horizontal">

            <h1>Login Form</h1>
            <div>
                <input type="text" placeholder="Пользователь: admin" required="" id="username" name="ssoId" />
            </div>
            <div>
                <input type="password" placeholder="Пароль: admin" required="" id="password" name="password"/>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
            <div>
                <input type="submit" value="Log in" />
            </div>
            <br/>
            <div>
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger">
                        <p>Invalid username and password.</p>
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="alert alert-success">
                        <p>You have been logged out successfully.</p>
                    </div>
                </c:if>
            </div>
        </form><!-- form -->
    </section><!-- content -->
</div><!-- container -->
</body>
</html>
