<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
<h1>Complete Reservation</h1>
Airline:${flight.operatingAirlines }<br>
Departure-City:${flight.departureCity}<br>
Arrival-City: ${flight.arrivalCity}<br>

<form action="/completeReservation" method="post">
<pre>
<h2>Passenger Details:</h2>
First-Name:<input type="text" name="passengerFirstName">
Last-Name:<input type="text" name="passengerLastName">
Email:<input type="text" name="passengerEmail">
Phone:<input type="text" name="passengerPhone">
</pre>
<pre>
<h2>Card Details:</h2>
Name on the Card:<input type="text" name="nameOnTheCard">
Card No:<input type="text" name="cardNumber">
Expiry Date:<input type="text" name="expirationDate">
Three Digit Security Code:<input type="text" name="securityCode">
<input type="hidden" name="flightId" value="${flight.id}">
<input type="submit" value="conform">
</pre>
</form>
</body> 
</html>