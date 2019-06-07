
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
    <h2>Car Database</h2>
    <table class="table table-striped">
        <thead>
        <th scope="row">#ID</th>
        <th scope="row">Marque</th>
        <th scope="row">Model</th>
        <th scoep="row">Petrol</th>
        <th scope="row">Engine Power[PS]</th>
        <th scope="row">AVG Consumption[l/100km]</th>
        <th scope="row">AVG Cost[PLN/100km]</th>
        <th scope="row">View costs</th>
        <th scope="row">Delete</th>
        </thead>
        <tbody>
        <c:forEach items="${carList }" var="car">
            <tr>
                <td>${car.id }</td>
                <td>${car.marque }</td>
                <td>${car.model }</td>
                <td>${car.petrol}</td>
                <td>${car.horsepower }</td>
                <td>${car.consumption }</td>
                <td>${car.cost }</td>
                <td>
                    <spring:url value="/consumption_list/${car.id }" var="updateURL"/>
                    <a class ="btn btn-primary" href="${updateURL }" role="button">View costs</a>
                </td>
                <td>
                    <spring:url value="/deleteCar/${car.id }" var="deleteURL"/>
                    <a class ="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/addCar/" var="addURL"/>
    <a class ="btn btn-primary" href="${addURL }" role="button">Add New Car</a>
    <div></div>


</div>
</body>
</html>