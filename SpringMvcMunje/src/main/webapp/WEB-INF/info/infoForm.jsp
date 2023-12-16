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
	<form action="result" method="post">
  <table class="table table-bordered" style="width: 300px;">
  <caption align="top"><b>입력받을 정보</b></caption>
    <tr>
      <th>이름</th>
      <td>
        <input type="text" name="name" class="form-control"
        style="width: 100px;">
      </td>
    </tr>
  
  	<tr>
      <th>좋아하는색</th>
      <td>
        <input type="color" name="color" 
        style="width: 100px;">
      </td>
    </tr>
    
     <tr>
      <th>취미</th>
      <td>
        <input type="checkbox" name="hobby" value="독서" 
        style="width: 100px;">독서
        <input type="checkbox" name="hobby" value="낚시" 
        style="width: 100px;">낚시
        <input type="checkbox" name="hobby" value="영화감상" 
        style="width: 100px;">영화감상
        <input type="checkbox" name="hobby" value="걷기" 
        style="width: 100px;">걷기
        <input type="checkbox" name="hobby" value="코딩" 
        style="width: 100px;">코딩
      </td>
    </tr>
    
    <tr>
      <th>가장좋아하는언어</th>
      <td>
        
        <input type="radio" name="language" value="JAVA" 
        style="width: 100px;">JAVA
        <input type="radio" name="language" value="HTML" 
        style="width: 100px;">HTML
        <input type="radio" name="language" value="ORACLE" 
        style="width: 100px;">ORACLE
        <input type="radio" name="language" value="JSP" 
        style="width: 100px;">JSP
        <input type="radio" name="language" value="SPRING" 
        style="width: 100px;">SPRING
      </td>
    </tr>
    
     <tr>
      <td colspan="2" align="center">
        <input type="submit" name="전송" class="btn btn-info"
        style="width: 100px;">
      </td>
  </table>
</form>
</body>
</html>