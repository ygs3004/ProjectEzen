<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<html>
<head>
    <title>과제 제출하기</title>
</head>
<body>
  <form action="/MyStudy/HomeWorkSubmit">
      

      <button type="submit">전송</button>
      <button type="reset">다시쓰기</button>
  </form>
</body>
</html>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>