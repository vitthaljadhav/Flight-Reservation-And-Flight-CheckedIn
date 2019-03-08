<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Flights</title>
</head>
<body>
	<h1>Flights:</h1>
	<table border="1px">
		<tr>
			<td>AirLines</td>
			<td>Departure City</td>
			<td>ArrivalCity</td>
			<td>Departure Time</td>
		</tr>

		<c:forEach items="${flights}" var="flights">
			<tr>
				<td>${flights.operatingAirlines}</td>
				<td>${flights.departureCity}</td>
				<td>${flights.arrivalCity }</td>
				<td>${flights.estimatedDepartureTime}</td>
				<td><a href="/showCompleteReservation?flightId=${flights.id}">Select</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>