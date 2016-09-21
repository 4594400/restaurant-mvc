<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/adminheader.jsp" />

<div class="container">

    <c:choose>
        <c:when test="${dishForm['new']}">
            <h1>Добавить блюдо</h1>
        </c:when>
        <c:otherwise>
            <h1>Редактировать блюдо</h1>
        </c:otherwise>
    </c:choose>
    <br/>


    <spring:url value="/dishes/list" var="dishActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="dishForm" action="${dishActionUrl}">

        <form:errors path="*" cssClass="errorblock" element="div"/>

        <form:hidden path="id"/>

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Название</label>
                <div class="col-sm-10">
                    <form:input path="name" type="text" class="form-control " id="name" placeholder="Name" required="required"/>
                    <form:errors path="name" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="price">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Цена, грн.</label>
                <div class="col-sm-10">
                    <form:input path="price" class="form-control" id="price" placeholder="Price" required="required"/>
                    <form:errors path="price" class="control-label">
                        <div id="price.errors" class="error">Incorrect value!</div>
                    </form:errors>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="weight">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Вес, гр.</label>
                <div class="col-sm-10">
                    <form:input path="weight" class="form-control" id="weight" placeholder="Weight" required="required"/>
                    <form:errors path="weight" class="control-label">
                        <div id="weight.errors" class="error">Incorrect value!</div>
                    </form:errors>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="dishCategory">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Категория</label>
                <div class="col-sm-10">

                    <form:select path="dishCategory" class="form-control">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${listOfDishCategory}"/>
                    </form:select>
                    <form:errors path="dishCategory" class="control-label">
                        <div id="dishCategory.errors" class="error">Please select category!</div>
                    </form:errors>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="description">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Описание</label>
                <div class="col-sm-10">
                    <form:input path="description" class="form-control" id="description" placeholder="Description"/>
                    <form:errors path="description" class="control-label">
                        <div id="description.errors" class="error">Incorrect value!</div>
                    </form:errors>
                </div>
            </div>
        </spring:bind>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${dishForm['new']}">
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

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
