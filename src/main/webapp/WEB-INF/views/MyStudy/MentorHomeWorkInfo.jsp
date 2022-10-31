<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>과제 정보</title>
</head>
<style>

    @media (min-width: 768px) {
        .container {
            width: 750px;
        }
    }

    @media (min-width: 992px) {
        .container {
            width: 940px;
        }
    }

    .container{
        margin-top: 40px;
        margin-bottom: 40px;
    }

    .study-informartion{
        margin-top: 40px;
        margin-bottom: 40px;
        width: 70%;
    }

    table{
        height: 70%;
        width: 70%;
    }

    th, td {
        vertical-align : middle;
    }

    th{
        text-align: center;
        width:30%;
    }

</style>
<body>
<div class="container">
<div class="container-sm study-informartion">
    <table class="table">
        <thead class="thead-dark">
        <tr style="background-color: rgba(0, 0, 0, 0.9)">
            <th scope="col" colspan="2" style="color:white">과제 정보</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">과제 이름</th>
            <td><c:out value="${homeWork.hwName}"/></td>
        </tr>
        <tr>
            <th scope="row">제출기한</th>
            <td> <c:out value="${homeWork.hwDeadLine}"/> </td>
        </tr>
        <tr>
            <th scope="row">과제내용</th>
            <td>
                <c:out value="${homeWork.hwContent}"/>
            </td>
        </tr>
        <tr>
            <th scope="row">제출인원 / <br> 스터디인원</th>
            <td> <c:out value="${homeWork.completeMentee} / ${mentorRoom.nowCapacity} 명" /> </td>
        </tr>
        <tr>
            <th scope="row">제출자 명단</th>
            <td>
                제출자,
            </td>
        </tr>
        </tbody>
    </table>
</div>
</div>
</body>
</html>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>