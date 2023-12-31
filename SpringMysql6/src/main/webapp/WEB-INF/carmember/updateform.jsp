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
<div style="margin: 100px 50px;">
<form action="update" method="post">
<input type="hidden" name="num" value="${dto.num }">
  <table class="table table-bordered" style="width: 350px;">
    <tr>
      <th>고객명</th>
      <td>
        <input type="text" name="name" required="required" value="${dto.name }"
        class="form-control">
      </td>
    </tr>
     <tr>
      <th>전화번호</th>
      <td>
        <input type="text" name="hp" required="required" value="${dto.hp }"
        class="form-control">
      </td>
    </tr>
     <tr>
      <th>주소</th>
      <td>
        <input type="text" name="addr" required="required" value="${dto.addr }"
        class="form-control">
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <button type="submit" class="btn btn-info">DB저장</button>
        <button type="button" class="btn btn-success"
        onclick="location.href='list'">목록</button>
      </td>
    </tr>
  </table>
</form>
</div>
</body>
</html>