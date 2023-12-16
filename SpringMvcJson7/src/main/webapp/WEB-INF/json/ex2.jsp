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
<h3>2번예제</h3>
<button type="button" id="btn2" class="btn btn-info">list2 json데이터 출력</button>
<div id="out2"></div>

<script type="text/javascript">
$("#btn2").click(function(){
	 
	  $.ajax({
		 
		  type:"get",
		  dataType:"json",
		  url:"list2",
		  success:function(wa){
			  
			  $("#out2").empty();
			  $("#out2").append("상품명: "+wa.name+"<br>");
			  $("#out2").append("색상: "+wa.color+"<br>");
			  $("#out2").append("가격: "+wa.price+"원<br>");
		  }
	  });
});
</script>
</body>
</html>