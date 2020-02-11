<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Create an account</title>

    <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/static/css/style.css" rel="stylesheet">


    <script src="${contextPath}/static/js/html5shiv.min.js"></script>
    <script src="${contextPath}/static/js/respond.min.js"></script>

</head>

<body>
<div class="navbar navbar-default">
    <div class="container">
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="${contextPath}/welcome"><span class="glyphicon glyphicon-star"></span>Main page</a>
            </li>
            <li>
                <a href="${contextPath}/request/requests"><span class="glyphicon glyphicon-list-alt"></span>List of requests</a>
            </li>
            <li>
                <a href="${contextPath}/request/addRequest"><span class="glyphicon glyphicon-plus"></span>Create new request</a>
            </li>
            <li>
                <a href="#"><span class="glyphicon glyphicon-envelope"></span>Feedback</a>
            </li>
            <li>
                <a href="#"><span class="glyphicon glyphicon-user"></span>My profile</a>
            </li>
            <li>
                <form id="logoutForm" method="post" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <a href="#" onclick="document.forms['logoutForm'].submit()">
                    <span class="glyphicon glyphicon-off"></span>Logout</a>
            </li>
        </ul>
    </div>
</div>

<div class="container">
    <form:form method="post" action="update" modelAttribute="editedRequest" class="form-signin">
        <h2 class="form-signin-heading">Create your request</h2>
        <spring:bind path="job">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="job" class="form-control" placeholder="Job"
                            autofocus="true"></form:input>
                <form:errors path="job"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="payment">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" min="0" path="payment" class="form-control" placeholder="Payment"></form:input>
                <form:errors path="payment"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="hoursInWeek">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" min="0" path="hoursInWeek" class="form-control" placeholder="Hours In Week"></form:input>
                <form:errors path="hoursInWeek"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="type">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select path="type" class="form-control" id="exampleFormControlSelect1">
                    <form:option value="NONE" label="Choose your type:" />
                    <form:options items="${types}" />
                </form:select>
                <form:errors path="type"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="description">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:textarea path="description" class="form-control" placeholder="Detailed information"
                               id="exampleFormControlTextarea1" rows="3"></form:textarea>
                <form:errors path="description"></form:errors>
            </div>
        </spring:bind>
        <form:hidden path="requestId" />
        <%--<form:hidden path="requester" />--%>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
        <a href="${contextPath}/request/requests" class="danger-link">Cancel</a>
        <a href="delete?id=${editedRequest.requestId}" class="danger-link">Delete</a>
    </form:form>
</div>

<script src="${contextPath}/static/js/jquery-3.4.1.min.js"></script>
<script src="${contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>