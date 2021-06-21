<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>result1</h1>
	<h3>${requestScope.sessionBean1.data1 }</h3>
	<h3>${requestScope.sessionBean1.data2 }</h3>

	<h3>${requestScope.sessionBean2.data3 }</h3>
	<h3>${requestScope.sessionBean2.data4 }</h3>
	
	<h3>${requestScope.sessionBean3.data5 }</h3>
	<h3>${requestScope.sessionBean3.data6 }</h3>
	
	<h3>${requestScope.sessionBean4.data7 }</h3>
	<h3>${requestScope.sessionBean4.data8 }</h3>
</body>
</html>