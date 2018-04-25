<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="db.test,dao.StudentDao,entity.Student,java.util.List,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="web/css/function.css" type="text/css" rel = "stylesheet">
</head>
<body>
	<div id="centre">
		<ul>
			<td>ID</td>
			<td>姓名</td>
			<td>年龄</td>
		</ul>
	</div>
	<div>
	<%
	StudentDao dao = new StudentDao();
	List<Student> list = new ArrayList<Student>();
	list = dao.queryAll();
	%>
	<%for(Student user:list) {%>
	<%=user.getID()%>
	<%=user.getName()%>
	<%=user.getAge() %><br>
	<%} %>
	</div>

</body>
</html>