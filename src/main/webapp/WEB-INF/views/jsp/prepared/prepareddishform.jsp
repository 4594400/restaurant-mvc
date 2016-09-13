<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

    <c:choose>
        <c:when test="${preparedDishForm['new']}">
            <h1>Add prepared dish</h1>
        </c:when>
        <c:otherwise>
            <h1>Update prepared dish</h1>
        </c:otherwise>
    </c:choose>
    <br />


    <spring:url value="/prepared/list" var="preparedDishActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="preparedDishForm" action="${preparedDishActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="dish.name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Dish name</label>
                <div class="col-sm-10">
                    <form:select path="dish.name" class="form-control">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${dishNames}"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="cooker.name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Cooker's name</label>
                <div class="col-sm-10">

                    <form:select path="cooker.name" class="form-control">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${cookerNames}"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>


        <spring:bind path="preparingDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Preparing Date</label>
                <div class="col-sm-10">
                    <form:input path="preparingDate" type="date" class="form-control " id="preparingDate" placeholder="Date" />
                    <form:errors path="preparingDate" class="control-label" />
                </div>
            </div>
        </spring:bind>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${preparedDishForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add
                        </button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Update
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

