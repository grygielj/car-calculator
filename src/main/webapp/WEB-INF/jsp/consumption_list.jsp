
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Car list</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Consumption</h2>
    <table class="table table-striped">
        <thead>
        <th scope="row">Date</th>
        <th scope="row">Range</th>
        <th scope="row">Liters</th>
        <th scope="row">Price[PLN]</th>
        <th scope="row">Costs[PLN/100km]</th>
        <th scope="row">Consumption[PLN/100km]</th>
        </thead>
        <tbody>
        <c:forEach items="${consumptionList }" var="consumption">
            <tr>
                <td><fmt:formatDate value="${consumption.date}" pattern="yyyy-MM-dd" /></td>
                <td>${consumption.rangeof }</td>
                <td>${consumption.liters }</td>
                <td>${consumption.price }</td>
                <td>${consumption.costs }</td>
                <td>${consumption.consumption }</td>

                <td>
                    <spring:url value="/deleteConsumption/${consumption.id }" var="deleteURL"/>
                    <a class ="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <spring:url  value="/addConsumption/${id}" var="addURL"/>
    <a class ="btn btn-primary" href="${addURL }" role="button">Add new information</a>
    <div></div>
    <br/>
    <br/>
        <spring:url  value="/list" var="addURL"/>
        <a class ="btn btn-primary" href="${addURL }" role="button">Return</a>

    <div></div>


</div>

</body>
</html>