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

        <title>Log in with your account</title>

        <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet" />
        <link href="${contextPath}/static/css/style.css" rel="stylesheet" />

        <script src="${contextPath}/static/js/html5shiv.min.js"></script>
        <script src="${contextPath}/static/js/respond.min.js"></script>

    </head>
    <body>
        <div class="container">
            <form method="POST" action="${contextPath}/login" class="form-signin">
                <h2 class="form-heading">Log in</h2>
                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span>${message}</span>
                    <input name="login" type="text" class="form-control" placeholder="Login"
                           autofocus="true"/>
                    <input name="password" type="password" class="form-control" placeholder="Password"/>
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                    <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
                </div>
            </form>
        </div>

        <script src="${contextPath}/static/js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <%--<script src="${contextPath}/static/js/bootstrap.min.js"></script>--%>
        <script src="${contextPath}/static/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>