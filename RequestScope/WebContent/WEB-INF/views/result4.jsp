<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>result4</h1>
	<!-- databean 객체에 저장된 데이터 가져오는 EL태그 -->
	<h3>${requestScope.bean1.data1 }</h3>
	<h3>${requestScope.bean1.data2 }</h3>
</body>
</html>