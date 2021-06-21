<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<h1>test1</h1>
 	<form:form modelAttribute="dataBean" action="result">
 		<form:hidden path="a1"/>
 		text : <form:input path="a2"/><br/>
 		password : <form:password path="a3" showPassword="true"/>
 		textarea : <form:textarea path="a4"/>
 		<form:button disabled="true" >확인 버튼</form:button>
 	</form:form>
</body>
</html>


<%-- 
<form:* path="a1"/>
path:설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입합니다. 
--%>