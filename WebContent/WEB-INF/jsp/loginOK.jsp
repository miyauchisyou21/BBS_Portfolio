<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/LoginOK.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント詳細画面</title>
</head>
<body>
<ul class="topnav">
	<li><a class="active" href="/sukkiriShop/WelcomeServlet">Home</a></li>
	<li><a href="/sukkiriShop/UpdateServlet">登録情報更新</a></li>
</ul>
<div class="window">
  <div class="box header">
    <h2>ID:&ensp;<c:out value="${userId}"/></h2>
    <h4 class="name">NAME:&ensp;<c:out value="${name}"/></h4>
    <h4 class="age">AGE:&ensp;<c:out value="${age}"/></h4>
  </div>
  <div class="box footer">
    <ul>
      <li><span class="ion-ios-camera-outline"></span><c:out value="${mail}"/></li>
    </ul>
    <a href="/sukkiriShop/BordServlet" class="btn">ENTER</a>
  </div>
</div>
</body>
</html>

