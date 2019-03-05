<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
</head>
<body>
<%@include file="../partials/header.html" %>
	<form action="searchBy" method="post">
		SearchBy
		<select name="searchUserBy">
		  <option value="firstName">First Name</option>
		  <option value="lastName">Last Name</option>
		  <option value="contactNo">Phone Number</option>
		  <option value="email">Email</option>
		</select>
		<input  name="userInfo" placeholder="Enter selected user Info" type="text"/>
		<input type="submit" value="submit"/>
	</form>
</body>
</html>