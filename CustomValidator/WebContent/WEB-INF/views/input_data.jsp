<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>input_data</h1>
	<form:form action='input_pro' modelAttribute="dataBean1" method="post">
	
		data1 : <form:input path='data1'/><br/>
				<form:errors path="data1"/><br/>
				
		data2 : <form:input path='data2'/><br/>
				<form:errors path="data2"/><br/>
				
		data3 : <form:input path='data3'/><br/>
				<form:errors path="data3"/><br/>		
	
		<form:button type='submit'>확인</form:button>
	</form:form>
	
</body>
</html>