<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/adminheader.jsp" />

<div class="container">

    <c:choose>
        <c:when test="${orderForm['new']}">
            <h1>Добавить заказ</h1>
        </c:when>
        <c:otherwise>
            <h1>Редактировать заказ</h1>
        </c:otherwise>
    </c:choose>
    <br/>


    <spring:url value="/admin/orders/list" var="orderActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="orderForm" action="${orderActionUrl}">

      <%--  <form:errors path="*" cssClass="errorblock" element="div"/>--%>

         <form:hidden path="id" />


        <spring:bind path="waiter.name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Имя официанта</label>
                <div class="col-sm-10">

                    <form:select path="waiter.name" class="form-control" required="required">
                        <form:options items="${waiterNames}"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="tableNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Номер столика</label>
                <div class="col-sm-10">
                    <form:input path="tableNumber" type="text" class="form-control " id="tableNumber"
                                placeholder="Number of table" required="required"/>
                    <form:errors path="tableNumber" class="control-label">
                        <div id="tableNumber.errors" class="error">Incorrect value!</div>
                    </form:errors>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="orderDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Дата</label>
                <div class="col-sm-10">
                    <form:input path="orderDate" type="date" class="form-control " id="orderDate" placeholder="Date" required="required"/>
                    <form:errors path="orderDate" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="orderStatus">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Статус заказа</label>
                <div class="col-sm-10">

                    <form:select path="orderStatus" class="form-control" required="required">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${listOfOrderStatus}"/>
                    </form:select>
                    <form:errors path="orderStatus" class="control-label">
                        <div id="orderStatus.errors" class="error">Please select status!</div>
                    </form:errors>

                </div>
            </div>
        </spring:bind>


        <%-- <spring:bind path="dishCategory">
             <div class="form-group ${status.error ? 'has-error' : ''}">
                 <label class="col-sm-2 control-label">Dish Category</label>
                 <div class="col-sm-10">

                     <form:select path="dishCategory" class="form-control">
                         <form:option value="NONE">--SELECT--</form:option>
                         <form:options items="${listOfDishCategory}"/>
                     </form:select>

                 </div>
             </div>
         </spring:bind>--%>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${orderForm['new']}">
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
