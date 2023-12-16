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
	<h2>post방식 Map출력(이름,나이,혈액형,주소)_result4</h2>
	<form action="myshinsanginfo" method="post">
	  이름: <input type="text" name="name" size="4"><br>
	  나이: <input type="text" name="age" size="3"><br>
	  혈액형: <input type="text" name="bloodtype" size="2"><br>
	  주소: <input type="text" name="addr" size="25"><br>
	  <button type="submit">post방식 전송</button>
	</form>
</body>
</html>