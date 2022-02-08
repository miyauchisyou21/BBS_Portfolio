<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント詳細画面</title>
</head>
<body>
<p>ようこそ<c:out value="${userId}"/>さん</p>
<br>
ユーザー登録情報<br>
[ユーザーID]<c:out value="${userId}"/><br>
[名前]<c:out value="${name}"/><br>
[メールアドレス]<c:out value="${mail}"/><br>
[年齢]<c:out value="${age}"/><br>
<br>

<a href="/sukkiriShop/BordServlet">掲示板へ</a>
<br>
<br>
<a href="/sukkiriShop/UpdateServlet">登録情報更新</a>
<footer>
<a href="/sukkiriShop/WelcomeServlet">トップへ</a>
</footer>
</body>
</html>