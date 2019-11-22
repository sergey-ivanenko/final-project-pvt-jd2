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
<%--        <meta name="description" content="">--%>
<%--        <meta name="author" content="">--%>

        <title>Create an account</title>

        <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/static/css/style.css" rel="stylesheet">


        <script src="${contextPath}/static/js/html5shiv.min.js"></script>
        <script src="${contextPath}/static/js/respond.min.js"></script>

    </head>

    <body>
        <div class="container">
            <form:form method="post" modelAttribute="userForm" class="form-signin">
                <h2 class="form-signin-heading">Create your account</h2>
                <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="name" class="form-control" placeholder="Username"
                                    autofocus="true"></form:input>
                        <form:errors path="name"></form:errors>
                    </div>
                </spring:bind>
                 <spring:bind path="login">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="login" class="form-control" placeholder="Login"
                                    autofocus="true"></form:input>
                        <form:errors path="login"></form:errors>
                    </div>
                </spring:bind>
                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                        <form:errors path="password"></form:errors>
                    </div>
                </spring:bind>
                <spring:bind path="confirmPassword">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="confirmPassword" class="form-control"
                                    placeholder="Confirm your password"></form:input>
                        <form:errors path="confirmPassword"></form:errors>
                    </div>
                </spring:bind>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
            </form:form>
        </div>

        <script src="${contextPath}/static/js/jquery-3.4.1.min.js"></script>
        <script src="${contextPath}/static/js/bootstrap.min.js"></script>
    </body>
</html>