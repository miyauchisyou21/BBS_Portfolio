<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/login.css">
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title >ログイン</title>
<!-- header -->
<hgroup class="heading">
<h1 class="major">ログイン</h1>
</hgroup>

<!-- form starts here -->
<form class="sign-up" action="/sukkiriShop/LoginServlet" method="post">
    <h1 class="sign-up-title">Sign up in seconds</h1>
    <input type="text" name ="userId" class="sign-up-input" placeholder="ユーザーID" autofocus>
    <input type="password" name="pass" class="sign-up-input" placeholder="password">
    <input type="submit" value="Sign me up!" class="sign-up-button">
  </form>
<%
	if(request.getAttribute("error_msg")!=null){%>
	<script type="text/javascript">
		 window.alert('ログインID,パスワードが間違っています');
    </script>
	<%}
%>
  <br>
 <a href="/sukkiriShop/WelcomeServlet" class="btn btn--yellow btn--cubic">Top</a>
  </html>