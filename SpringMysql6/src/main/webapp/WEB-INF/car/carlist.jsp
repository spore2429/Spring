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
	<button type="button" onclick="location.href='writeform'" class="btn btn-info">차 정보 입력</button>
	<c:if test="${totalCount==0}">
	  <h3 class="alert alert-info">저장된 차의 정보가 없습니다</h3>
	</c:if>
	<c:if test="${totalCount>0}">
	  <h3 class="alert alert-info">${totalCount }개의 자동차가 등록되었습니다</h3>
	</c:if>
	
<hr>
<div style="text-align: center">
<table class="table table-bordered" style="width: 700px;">
  <tr valign="middle">
    <th width="120">번호</th>
    <th width="120">차량명</th>
    <th width="120">차색상</th>
    <th width="120">차랑가격</th>
    <th width="120">구입일</th>
    <th width="160">편집</th>
  </tr>
  <c:forEach var="dto" items="${list }" varStatus="i">
  	<tr valign="middle">
  	  <td><b>${i.count }</b></td>
  	  <td><b>${dto.carname }</b></td>
  	  <td align="center">
  	  	<div style="width: 40px; height: 40px; background-color:${dto.carcolor };" ></div>
  	  </td>
  	  <td>
  	    <b><fmt:formatNumber value="${dto.carprice }" type="currency"/></b>
  	  </td>
  	  <td><b>${dto.carguip }</b></td>
  	  <td>
  	    <button type="button" class="btn btn-success"
  	    onclick="location.href='updateform?num=${dto.num}'">수정</button>
  	    <button type="button" class="btn btn-danger"
  	    onclick="location.href='delete?num=${dto.num}'">삭제</button>
  	  </td>
  	</tr>
  </c:forEach>
</table>
</div>
<img alt="" src="../res/image/seonsu.jpg" style="width: 700px; height: 550px;">
<img alt="" src="../res/image/wow.jpg" style="width: 700px; height: 550px;">
</body>
</html>