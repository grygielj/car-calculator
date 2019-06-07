<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2"/>
    <title>Car form</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
</head>
    <body>
    <div class="container">
        <spring:url value="/adding" var="saveURL"/>
        <h2>Consumption</h2>
        <form:form modelAttribute="carForm" method="post" action="${saveURL }" cssClass="form">
            <form:hidden path="id"/>
            <form:hidden path="marque"/>
            <form:hidden path="model"/>
            <form:hidden path="petrol"/>
            <form:hidden path="horsepower"/>
            <form:hidden path="consumption"/>
            <form:hidden path="cost"/>
            <div class="form-group">
                <label>How many kilometers did You drive since last refuel?</label>
                <br/>
                <input name="range" type="text" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label>How many liters You fill up?</label>
                <br/>
                <input name="liters" type="liters" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label>How much did You pay for petrol?</label>
                <br/>
                <input name="bill" type="bill" cssClass="form-control"/>
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </form:form>
    </div>
    </body>
</html>

