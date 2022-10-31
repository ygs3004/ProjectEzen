<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>과제 정보</title>
</head>
<body>

<div class="container-sm study-information">
    <table class="table">
        <thead class="thead-dark">
        <tr style="background-color: rgba(0, 0, 0, 0.9)">
            <th scope="col" colspan="2" style="color:white; height:70px" >스터디 정보</th>
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
        <tr>
            <th scope="row">스터디 내용</th>
            <td><c:out value=" ${mentoRoom.content}" /></td>
        </tr>
        <tr>
            <th scope="row">현재인원 / <br> 모집인원</th>
            <td><c:out value="${mentoRoom.nowCapacity}  /  ${mentoRoom.capacity} 명" /> </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
