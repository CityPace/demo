<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登入</title>
<link href="web/css/Login.css" type="text/css" rel = "stylesheet">

</head>
<body>
<%
    String errorMsg = (String)session.getAttribute("errorMsg");
    errorMsg = errorMsg ==null?"":errorMsg;
    String name = request.getParameter("USER_NAME");
    name = name == null ? "" : name;
%>
	<%@include file="WEB-INF/includes/header.jsp"%>
	<div id="content">
		<div id="left">
			<h1>系统使用说明</h1>
			<div class="ft" style="border: none">
				<table>
					<tr>
						<td>1、还没有账号，<a href="Register.jsp">进入注册</</a></td>
					</tr>
					<tr>
						<td>2、已有账号，在本页右侧登入！</td>
					</tr>
					<tr>
						<td>3、登入成功后，按页面右边操作菜单操作！</td>
					</tr>
					<tr>
						<td>4、咨询电话:</td>
					</tr>
				</table>
			</div>
		</div>
		<div id="right">
			<h1>用户登入</h1>
			<div class="operation">
				验证登入信息 <span class="mess" id="errorMsg"><%=errorMsg %>></span>
			</div>
			<div class="ft">
				<form action="LoginServlet" method="post">
				<table>
					<tr>
						<td class="label">用户名：</td>
						<td colspan="2"><input type="text" name="name"></td>
						<td class="hint">*</td>
					</tr>
					<tr>
						<td class="label">密码：</td>
						<td colspan="2"><input type="password" name="pass"></td>
						<td class="hint">*</td>
					</tr>
					<tr>
						<td class="label">验证码：</td>
						<td><input type="text" style="width: 65px;" name="randomCode"></td>
						<td><img src="/demo/RandomServlet" id="randomCodeImg" title="看不起，换一张" onclick="this.src+='?tm='+Math.random();" style="cursor:pointer;"></td>
						<td class="hint">*</td>
					</tr>
					<tr>
						<td colspan="3"><input type="submit" value="登入系统"
							class="button" id="submit" > <input type="reset" value="重置"
							class="button" id="reset" ></td>
							<td class="hint">*还没有账号,<a href="Register.jsp">点击注册</a></td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		<div class="clearf"></div>
	</div>

	<%@include file="WEB-INF/includes/footer.jsp"%>
</body>
</html>













