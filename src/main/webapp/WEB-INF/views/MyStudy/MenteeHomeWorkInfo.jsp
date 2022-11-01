<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<html>
<head>
    <title>과제 정보</title>
</head>
<body>

<div class="container-sm study-information">
    <table class="table">
        <thead class="thead-dark">
        <tr style="background-color: rgba(0, 0, 0, 0.9)">
            <th scope="col" colspan="2" style="color:white; height:70px" >과제 정보</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row" >과제명</th>
            <td>hwName</td>
        </tr>
        <tr>
            <th scope="row">과제 내용</th>
            <td>hwContent</td>
        </tr>
        <tr>
            <th scope="row">과제 기한</th>
            <td>hwDeadLine</td>
        </tr>

        </tbody>
    </table>
    <button type="button" onclick="location.href='HomeWorkSubmitForm'">제출하기</button>
</div>
</body>
</html>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
