<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>input_data</h1>
	<form action="input_pro" method="post">
		data 1 : <input type="text" name="data1"><br/>
				<Spring:hasBindErrors name="dataBean1">
			<c:if test="${errors.hasFieldErrors('data1') }">
				${ errors.getFieldError('data1').defaultMessage }
			</c:if>
		</Spring:hasBindErrors>
		data 2 : <input type="text" name="data2"><br/>
				<Spring:hasBindErrors name="dataBean1">
			<c:if test="${errors.hasFieldErrors('data2') }">
				${ errors.getFieldError('data2').defaultMessage }
			</c:if>
		</Spring:hasBindErrors>
		<button type="submit">확인</button>
	</form>
</body>
</html>