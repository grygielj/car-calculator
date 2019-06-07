<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2"/>
    <title>Car form</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
</head>
<body>
    <div class="container">
        <spring:url value="/saveCar" var="saveURL"/>
        <h2>Car</h2>
        <form:form modelAttribute="carForm" method="post" action="${saveURL }" cssClass="form">
            <form:hidden path="id"/>
            <div class="form-group">
                <label>Marque</label>
                <form:input path="marque" cssClass="form-control" id="marque"/>
            </div>
            <div class="form-group">
                <label>Model</label>
                <form:input path="model" cssClass="form-control" id="model"/>
            </div>
            <div class="form-group">
                <label>Horsepower</label>
                <form:input path="horsepower" cssClass="form-control" id="horsepower"/>
            </div>
            <div class="form-group">
                <label>Petrol</label>
                <form:select value="petrol" path="petrol" cssClass="form-control" items="${petrols}" />
            </div>
            <form:hidden path="consumption" cssClass="form-control" id="consumption"/>

            <button type="submit" class="btn btn-primary">Save</button>
        </form:form>
    </div>
</body>
</html>