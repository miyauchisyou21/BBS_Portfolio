<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント作成完了</title>
</head>
<body>
<h1>アカウントが作成されました</h1>
<p>ようこそ<c:out value="${userId}"/>さん</p>
<a href="/sukkiriShop/WelcomeServlet">トップへ</a>
</body>
</html>