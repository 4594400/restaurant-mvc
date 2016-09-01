<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>Spring MVC Form Handling Example</title>

<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/login" var="login" />
<spring:url value="/logout" var="logout" />
<spring:url value="/users/add" var="urlAddUser" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${login}">Log in</a>
		</div>
		<div id="logbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${logout}">Log out</a></li>
			</ul>
		</div>
	</div>
</nav>

<%--<div id="navbar">
    <ul class="nav navbar-nav navbar-right">
        <li role="presentation" class="active"><a href="/">Home</a></li>
        <li role="presentation"><a href="/employees/">Employees</a></li>
        <li role="presentation"><a href="#">Menu</a></li>
    </ul>
</div>--%>



<img src="<c:url value="/resources/images/logo4.jpg"/>" class="img-responsive center-block"/>
<hr>

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <ul class="nav navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="/">
                <h4>Home</h4>
                <span class="sr-only">(current)</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/employees/list">
                <h4>Employees</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/menus/list">
                <h4>Menu</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/dishes/list">
                <h4>Dishes</h4>
            </a>
        </li>
    </ul>

</nav>