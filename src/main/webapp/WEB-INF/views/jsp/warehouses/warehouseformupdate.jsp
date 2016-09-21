<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/adminheader.jsp" />

<div class="container">

    <c:choose>
        <c:when test="${warehouseForm['new']}">
            <h1>Добавить ингредиент на склад</h1>
        </c:when>
        <c:otherwise>
            <h1>Добавить</h1>
        </c:otherwise>
    </c:choose>
    <br />


    <spring:url value="/warehouses/list" var="warehouseActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="warehouseForm" action="${warehouseActionUrl}">

        <form:hidden path="id" />
        <form:hidden path="ingredient.name"/>

        <%--<spring:bind path="ingredient.name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Ingredient name</label>
                <div class="col-sm-10">
                    <form:input path="ingredient.name" type="text" class="form-control " id="name" placeholder="ingredient.name" />
                    <form:errors path="ingredient.name" class="control-label" />
                </div>
            </div>
        </spring:bind>--%>



        <spring:bind path="quantity">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Количество</label>
                <div class="col-sm-10">
                    <form:input path="quantity" type="text" class="form-control " id="name" placeholder="Quantity" required="required" />
                    <form:errors path="quantity" class="control-label">
                        <div id="quantity.errors" class="error">Incorrect value!</div>
                    </form:errors>
                </div>
            </div>
        </spring:bind>


        <spring:bind path="measure">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Единица измерения</label>
                <div class="col-sm-10">

                    <form:select path="measure" class="form-control">
                        <form:options items="${measures}"  />
                    </form:select>
                </div>
            </div>
        </spring:bind>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${warehouseForm['new']}">
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
