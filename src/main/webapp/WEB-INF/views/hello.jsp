<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>register-jsp</title>
</head>
<body>

<form action="./registerUser" method="post">
		
		
		账户：<input type="text" name="uname" value="" placeholder="请输入账户名·"><br>
 
		
		密码：<input type="password" name="upassword" value="" placeholder="请输入密码"><br>
		电话：<input type="text" name="code" value="" placeholder="test-code"><br>
 
		隐藏内容<input type="hidden" name="uid" value="1" placeholder="3"><br>
 
		<input type="submit" name="" value="提交" placeholder=""><br>
 
		<input type="reset" name="重置" value="重置" placeholder=""><br>
 
 
		
	</form>

</body>
</html>