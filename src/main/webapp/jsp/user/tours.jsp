<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/pageform.css">
<head>
    <title>Tours</title>
</head>
<style>
    .page-form form button {
        background-color: rgb(110, 176, 170) !important;
    }

    .page-form form button:hover {
        background-color: rgb(83, 134, 130) !important;
    }


</style>
<body>
<div class="page-form">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="myNavbar">

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/logout"><span
                            class="glyphicon glyphicon-log-in"></span> Log out</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <form class="page-form" action="${pageContext.request.contextPath}/userTours" method="get">
        <h2>Tours</h2>
        <div class=" table">
            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th>TourId</th>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>People quantity</th>
                    <th>Hotel type</th>
                    <th>Price</th>
                    <th>HLast minute</th>

                </tr>
                <c:set var="tours" value="${requestScope.get('tours')}"/>
                <c:forEach var="tour" items="${tours}">
                    <tr>
                        <td>${tour.getId()}</td>
                        <td>${tour.getCode()}</td>
                        <td>${tour.getName()}</td>
                        <td>${tour.getType()}</td>
                        <td>${tour.getPeopleQuantity()}</td>
                        <td>${tour.getHotelType()}</td>
                        <td>${tour.getPrice()}</td>
                        <td>${tour.getLastMinute()}</td>

                    </tr>
                </c:forEach>
            </table>
        </div>
        <c:set var="href" value="/tours?" scope="request"/>
        <jsp:include page="../pagination.jsp"/>
    </form>


</div>
</body>
</html>
