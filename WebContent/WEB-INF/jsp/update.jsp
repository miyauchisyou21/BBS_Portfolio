<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報更新</title>
</head>
<body>
<form action="/sukkiriShop/UpdateServlet" method="post">
ユーザーID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
メールアドレス:<input type="text" name="mail"><br>
名前:<input type="text" name="name"><br>
年齢:<input type="number" name="age"><br>
<input type="submit" value="アカウント情報更新">
<font color="red">
<%
	if(request.getAttribute("error_msg")!=null){%>
		<%=request.getAttribute("error_msg") %>
	<%}
%>
<br>
<a href="/sukkiriShop/WelcomeServlet">トップへ</a>
</font>
</form>

</body>
</html>