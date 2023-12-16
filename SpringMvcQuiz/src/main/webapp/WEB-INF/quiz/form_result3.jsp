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
	<h2>post방식_dto_ 테이블출력(상품명,카테고리,색상,가격)_result3</h2>
	<form action="shopipgo" method="post">
	  상품: <input type="text" name="sang" size="10"><br>
	  카테고리: <input type="text" name="category" size="10"><br>
	  색상: <input type="text" name="color" size="10"><br>
	  가격: <input type="text" name="price" size="10"><br>
	  <button type="submit">post방식 전송</button>
	</form>
</body>
</html>