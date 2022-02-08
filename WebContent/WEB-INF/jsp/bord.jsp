<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
</head>
<body>
<h1>掲示板</h1>
<form action="/sukkiriShop/BordServlet" method="post" >
<p>名前:<c:out value="${name}"/>
<br>
<p>コメント:<br>
<textarea name="comment" rows="5" cols="40"></textarea>
</p>
<p>
<input type="submit" value="送信">
</p>
</form>
<c:forEach var="list" items="${resultList}">
<p>ID:<c:out value="${list.userId}"/> 名前:<c:out value="${list.name}"/> 年齢:<c:out value="${list.age}"/>日付:<c:out value="${list.ts}"/><br>
<c:out value="${list.comment}"/></p>
</c:forEach>
<br>

<!-- 絞り込み -->
<form action="/sukkiriShop/SearchServlet" method="post" >
<div style="position: absolute; right: 10%; top: 0px">
<h2>検索条件</h2>
<p>投稿日:<input type="text" name="ts"></p>
<p>投稿者:<input type="text" name="name"></p>
<p align = "right">
</p>
</div>
<!-- 名前 年齢 絞り込み -->
<div style="position: absolute; right: 10%; top: 180px">
<p>
<select name="sort">
<option value="sortNone">なし</option>
<option value="sortName">名前</option>
<option value="sortAge">年齢</option>
</select>
</p>
</div>
<!--表示切り替え  -->
  <div style="position: absolute; right: 10%; top: 240px">
    <p>表示切り替え</p>
    <input id="all" type="radio" name="display" value="all">
    <label for="all">全件表示</label>
    <input id="10" type="radio" name="display" value="latest" checked>
    <label for="10">最新10件表示</label>
	<input type="submit" value="検索する">
  </div>
</form>
<br>
<br>
<footer>
<a href="/sukkiriShop/WelcomeServlet">トップへ</a>
</footer>
</body>
</html>