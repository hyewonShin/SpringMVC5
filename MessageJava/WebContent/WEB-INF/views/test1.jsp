<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>test1</h1>
	<h3><spring:message code="aaa.a1"/></h3>
	<h3><spring:message code="bbb.b1"/></h3>
	<h3><spring:message code="aaa.a2" arguments="${args }"/></h3>
</body>
</html>