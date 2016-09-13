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
        <c:when test="${employeeForm['new']}">
            <h1>Add User</h1>
        </c:when>
        <c:otherwise>
            <h1>Update User</h1>
        </c:otherwise>
    </c:choose>
    <br />


    <spring:url value="/employees/list" var="employeeActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="employeeForm" action="${employeeActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Name</label>
                <div class="col-sm-10">
                    <form:input path="name" type="text" class="form-control " id="name" placeholder="Name" />
                    <form:errors path="name" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="surname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Surname</label>
                <div class="col-sm-10">
                    <form:input path="surname" class="form-control" id="surname" placeholder="Surname" />
                    <form:errors path="surname" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="birthday">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Birthday</label>
                <div class="col-sm-10">
                    <form:input path="birthday" type="date" class="form-control " id="birthday" placeholder="Date" />
                    <form:errors path="birthday" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="phoneNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Phone Number</label>
                <div class="col-sm-10">
                    <form:input path="phoneNumber" class="form-control" id="phoneNumber" placeholder="phoneNumber" />
                    <form:errors path="phoneNumber" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="position">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Position</label>
                <div class="col-sm-10">
                    <form:select path="position" class="form-control">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${listOfPositions}"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="salary">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Salary</label>
                <div class="col-sm-10">
                    <form:input path="salary" rows="5" class="form-control" id="salary" placeholder="salary" />
                    <form:errors path="salary" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${employeeForm['new']}">
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
