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
            <div class="list-group">
                <c:forEach items="${listRequests}" var="item" varStatus="loop">
                    <div class="list-group-item list-group-item-action flex-column align-items-start">
                        <h3 class="mb-1"><c:out value="${item.job}" /></h3>
                        <c:if test="${item.description != null}">
                            <p class="mb-1 lead"><c:out value="${item.description}" /></p>
                        </c:if>
                        <div class="d-flex w-100 justify-content-between">
                            <c:if test="${item.payment != null}">
                                <div class="mb-1">Salary: <c:out value="${item.payment}" />
                                    <span class="glyphicon glyphicon-usd"></span>
                                </div>
                            </c:if>
                            <c:if test="${item.hoursInWeek != null}">
                                <small>Hours in week: <c:out value="${item.hoursInWeek}" /></small>
                            </c:if>
                        </div>

                        <div class="row">
                            <div class="col-md-2">
                                <a href="edit?id=${item.requestId}" title="Edit"><span class="glyphicon glyphicon-pencil">Edit</span></a>
                                <a href="delete?id=${item.requestId}" title="Remove"><span class="glyphicon glyphicon-remove">Delete</span></a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <script src="${contextPath}/static/js/jquery-3.4.1.min.js"></script>
        <script src="${contextPath}/static/js/bootstrap.min.js"></script>
    </body>
</html>