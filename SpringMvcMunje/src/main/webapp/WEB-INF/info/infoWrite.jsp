<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Moirai+One&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<h2>입력정보출력_dto</h2>
	이름: ${dto.name }<br>
	좋아하는색: <div style="background-color: ${dto.color }; width:30px; height:30px;"></div>

			취미:
			 	<%-- <c:forEach var="s" items="${dto.hobby }" varStatus="i">
				     [${s}]
				  </c:forEach><br> --%>
				  <c:if test="${empty dto.hobby }">없음</c:if>
				  
				  <c:if test="${!empty dto.hobby }">
				    <c:forEach var="h" items="${dto.hobby }">
				     [${h}]
				  </c:forEach>
				  </c:if><br>
	
	가장좋아하는언어: ${dto.language }<br>
</body>
</html>