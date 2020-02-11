<%--
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Admin</title>

        <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="post" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
                <h2>
                    Admin Page ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
                </h2>
            </c:if>
        </div>

        <script src="${contextPath}/static/js/jquery-3.4.1.min.js"></script>
        <script src="${contextPath}/static/js/bootstrap.min.js"></script>
    </body>
</html>--%>

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

    <title>Admin</title>

    <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/static/css/style.css" rel="stylesheet">

</head>
<body>
<div class="navbar navbar-default">
    <div class="container">
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="${contextPath}/admin"><span class="glyphicon glyphicon-star"></span>Main page</a>
            </li>
            <%--<li>
                <a href="${contextPath}/request/all"><span class="glyphicon glyphicon-list-alt"></span>All requests</a>
            </li>--%>
            <li>
                <a href="${contextPath}/admin/addAdmin"><span class="glyphicon glyphicon-plus"></span>Add new admin</a>
            </li>
            <%--<li>
                <a href="#"><span class="glyphicon glyphicon-envelope"></span>Feedback</a>
            </li>--%>
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
    <h2 class="welcome">
        Welcome ${pageContext.request.userPrincipal.name} | <a href="#"
                                                               onclick="document.forms['logoutForm'].submit()">Logout</a>
    </h2>

    <div class="row">
        <table class="table table-condensed">
            <thead>
            <tr>
                <th class="col-sm-1 lead">#</th>
                <th class="col-sm-2 lead">User login</th>
                <th class="col-sm-3 lead">User name</th>
                <th class="col-sm-4 lead">Password</th>
                <th class="col-sm-1 lead">Role</th>
                <th class="col-sm-1"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user" varStatus="loop">
                <tr>
                    <td class="lead"><c:out value="${loop.index + 1}" /></td>
                    <td>
                        <div class="lead"><c:out value="${user.login}" /></div>
                    </td>
                    <td>
                        <div class="lead"><c:out value="${user.name}" /></div>
                    </td>
                    <td>
                        <div class="lead"><c:out value="${user.password}" /></div>
                    </td>
                    <td>
                        <c:forEach items="${user.roles}" var="role" varStatus="loop">
                            <div class="lead"><c:out value="${role.name}" /></div>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${user.roles}" var="role" varStatus="loop">
                            <c:if test="${role.name.equals(\"ROLE_USER\")}">
                                <%--<a href="delete?id=${user.userId}" class="danger-link">Delete</a>--%>
                                <div>
                                    <a href="delete?id=${user.userId}" class="btn btn-sm btn-danger btn-lg active"
                                       role="button" aria-pressed="true">Delete</a>
                                </div>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%--<c:if test="${pageContext.request.userPrincipal.name != null}"></c:if>--%>
</div>

<script src="${contextPath}/static/js/jquery-3.4.1.min.js"></script>
<script src="${contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>
