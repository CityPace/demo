<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="web/css/Login.css" type="text/css" rel = "stylesheet">
</head>
<body>
<div id="hmenu">
		<ul>
			<li><a href="#">退出系统</a></li>
			<li><a href="#">修改密码</a></li>
			<li><a href="#">我的登入历史</a></li>
			<li>欢迎您：<%=session.getAttribute("USER_NAME")%></li>
		</ul>
	</div>
</body>
</html>