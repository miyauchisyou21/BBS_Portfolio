<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/welcome.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBS</title>
</head>
<body>
<div class="content">
  <h1>Bulletin Board System</h1>
</div>
<ul class="topnav">
	<li><a class="active" href="/sukkiriShop/WelcomeServlet">Home</a></li>
	<li><a href="/sukkiriShop/LoginServlet">Login</a></li>
	<li class="right"><a href="/sukkiriShop/CreateUser">Account Registration</a></li>
	<li class="right"><a href="/sukkiriShop/DeleteUser">Account Deletion</a></li>
</ul>
<div class="bg"></div>
<div class="bg bg2"></div>
<div class="bg bg3"></div>
</body>
</html>

