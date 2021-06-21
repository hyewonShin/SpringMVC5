<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test2</h1>
	<!-- TestController에서 지정해준 bean클래스 이름 사용 -->
	<h3>data1 : ${requestScope.testData.data1 }</h3>
	<h3>data2 : ${requestScope.testData.data2 }</h3>
</body>
</html>