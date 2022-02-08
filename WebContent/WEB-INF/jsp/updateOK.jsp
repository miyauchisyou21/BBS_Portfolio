<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報更新完了</title>
</head>
<body>
<h1>ユーザー登録情報</h1><br>
[ユーザーID]<c:out value="${userId}"/><br>
[名前]<c:out value="${name}"/><br>
[メールアドレス]<c:out value="${mail}"/><br>
[年齢]<c:out value="${age}"/><br>


<a href="/sukkiriShop/WelcomeServlet">トップへ</a>
</body>
</html>