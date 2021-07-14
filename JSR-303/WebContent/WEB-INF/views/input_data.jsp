<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>	
	<h1>input_data</h1>
	<form:form action="input_pro" modelAttribute="dataBean1" method="post">
	
		data1 : <form:radiobutton path="data1" value='true'/>true
				<form:radiobutton path="data1" value='false'/>false <br/>
				<form:errors path='data1'/><br/> <!-- 해당 에러메세지 출력 -->
				
		data2 : <form:radiobutton path="data2" value='true'/>true
				<form:radiobutton path="data2" value='false'/>false <br/>
				<form:errors path='data2'/><br/> <!-- 해당 에러메세지 출력 -->		
				
		data3 : <form:input path='data3' type='text'/><br/>
			    <form:errors path='data3'/>
			    
		data4 : <form:input path="data4" type='text'/><br/>
				<form:errors path='data4'/>
				
		data5 : <form:checkbox path="data5" value="check1"/>checkbox1<br/>
				<form:errors path="data5"/>
				
		data6 : <form:checkbox path="data6" value="check2"/>checkbox2<br/>
				<form:errors path="data6"/>		
		
		data7 : <form:input path="data7" type = 'text'/><br/>
				<form:errors path="data7"/>
				
		data8 : <form:input path="data8" type = 'text'/><br/>
				<form:errors path="data8"/>
				
		data9 : <form:input path="data9" type = 'text'/><br/>
				<form:errors path="data9"/>
		
		<form:button type='submit'>확인</form:button>
	</form:form>
</body>
</html>