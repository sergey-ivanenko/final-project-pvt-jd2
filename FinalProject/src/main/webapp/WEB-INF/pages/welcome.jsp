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

        <title>Welcome</title>

        <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/static/css/style.css" rel="stylesheet">

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
                        <a href="#"><span class="glyphicon glyphicon-envelope"></span>Feedback <span class="badge">42</span></a>
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
            <%--<form id="logoutForm" method="post" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>--%>
            <h2 class="welcome">
                Welcome ${pageContext.request.userPrincipal.name} | <a href="#"
                                                                       onclick="document.forms['logoutForm'].submit()">Logout</a>
            </h2>
           <%-- <div class="row welcome">
                <div class="col-md-6 col-md-offset-3" >
                    <!-- <h2>Custom search field</h2> -->
                    <form:form method="post" class="form-signin">
                        <div id="custom-search-input">
                            <div class="input-group col-md-12">
                                <input type="text" class="form-control input-lg" placeholder="Search" />
                                <span class="input-group-btn">
                                    <button class="btn btn-info btn-lg" type="submit">
                                        <i class="glyphicon glyphicon-search"></i>
                                    </button>
                                </span>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>--%>

            <%--<c:if test="${myRequests != null}">
            </c:if>--%>

            <div class="row">
                <table class="table table-condensed">
                    <thead>
                        <tr>
                            <th class="col-sm-1 lead">#</th>
                            <th class="col-sm-3 lead">Request name</th>
                            <th class="col-sm-5 lead">Suitable requests</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${table}" var="item" varStatus="loop">
                            <tr>
                                <td class="lead"><c:out value="${loop.index + 1}" /></td>
                                <td>
                                    <div class="lead"><c:out value="${item.key}" /></div>
                                </td>
                                <td>
                                    <div class="list-group">
                                        <c:forEach items="${item.value}" var="list" varStatus="loop">
                                            <div class="list-group list-group-item-action flex-column align-items-start">
                                                <h3><c:out value="${list.job}" /></h3>
                                                <%--<c:if test="${item.description != null}">--%>
                                                    <p class="lead"><c:out value="${list.description}" /></p>
                                                <%--</c:if>--%>
                                                <div class="d-flex w-100 justify-content-between">
                                                    <c:if test="${list.payment != null}">
                                                        <div>Salary: <c:out value="${list.payment}" />
                                                            <span class="glyphicon glyphicon-usd"></span>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${list.hoursInWeek != null}">
                                                        <small>Hours in week: <c:out value="${list.hoursInWeek}" /></small>
                                                    </c:if>
                                                    <div><c:out value="${list.requester.name}" /></div>
                                                    <%--modelAttribute="userForm"--%>
                                                    <%--<div class="row row-no-gutters">--%>
                                                    <%--<div class="form-group-sm">--%>
                                                    <form method="post" action="${contextPath}/apply" class="form-inline">
                                                        <div class="form-group">
                                                        <button class="btn btn-sm btn-success btn-block" type="submit">Apply</button>
                                                        </div>
                                                    </form>
                                                    <%--</div>--%>
                                                    <%--</div>--%>
                                                    <%--<a href="#" class="btn btn-sm btn-success btn-lg active"
                                                       role="button" aria-pressed="true">Apply</a>--%>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
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