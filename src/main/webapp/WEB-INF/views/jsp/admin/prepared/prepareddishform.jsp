<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/adminheader.jsp" />

<div class="container">

    <c:choose>
        <c:when test="${preparedDishForm['new']}">
            <h1>Добавить блюдо</h1>
        </c:when>
        <c:otherwise>
            <h1>Редактировать блюдо</h1>
        </c:otherwise>
    </c:choose>
    <br />


    <spring:url value="/admin/prepared/list" var="preparedDishActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="preparedDishForm" action="${preparedDishActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="dish.name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Название</label>
                <div class="col-sm-10">
                    <form:select path="dish.name" class="form-control" required="required">
                        <%--<form:option value="NONE">--SELECT--</form:option>--%>
                        <form:options items="${dishNames}"/>
                    </form:select>
                    <form:errors path="dish.name" class="control-label">
                        <div id="dish.name.errors" class="error">Please select name!</div>
                    </form:errors>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="cooker.name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Имя повара</label>
                <div class="col-sm-10">

                    <form:select path="cooker.name" class="form-control" required="required">
                       <%-- <form:option value="NONE">--SELECT--</form:option>--%>
                        <form:options items="${cookerNames}"/>
                    </form:select>
                    <form:errors path="cooker.name" class="control-label">
                        <div id="cooker.name.errors" class="error">Please select name!</div>
                    </form:errors>
                </div>
            </div>
        </spring:bind>


        <spring:bind path="preparingDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Дата приготовления</label>
                <div class="col-sm-10">
                    <form:input path="preparingDate" type="date" class="form-control " id="preparingDate" placeholder="Date" required="required" />
                    <form:errors path="preparingDate" class="control-label" />
                </div>
            </div>
        </spring:bind>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${preparedDishForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Добавить
                        </button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Сохранить
                        </button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>


    </form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>

