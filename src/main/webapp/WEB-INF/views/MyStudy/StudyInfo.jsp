<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .study-information{
        margin-top: 40px;
        margin-bottom: 40px;
        width: 70%;
    }

    table{
        height: 70%;
        width: 50%;
    }

    th, td {
        vertical-align : middle;
    }

    th{
        text-align: center;
        width:30%;
    }

</style>

<div class="container-sm study-information">
<table class="table">
    <thead class="thead-dark">
    <tr style="background-color: rgba(0, 0, 0, 0.9)">
        <th scope="col" colspan="2" style="color:white; height:70px" >스터디 정보</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row" >스터디 이름</th>
        <td><c:out value=" ${mentoRoom.title}" /></td>
    </tr>
    <tr>
        <th scope="row">멘토</th>
        <td><c:out value=" ${mentoRoom.name}" /></td>
    </tr>
    <tr>
        <th scope="row">멘토님 학교</th>
        <td><c:out value=" ${mentoRoom.school}" /></td>
    </tr>
    <tr>
        <th scope="row">멘토 경력</th>
        <td><c:out value=" ${mentoRoom.career}" /></td>
    </tr>
    <tr>
        <th scope="row">시작일 / <br> 종료일</th>
        <td><c:out value=" ${mentoRoom.studyStart} ~ ${mentoRoom.studyEnd}" /></td>
    </tr>
    <tr>
        <th scope="row">스터디 내용</th>
        <td><c:out value=" ${mentoRoom.content}" /></td>
    </tr>
    <tr>
        <th scope="row">현재인원 / <br> 모집인원</th>
        <td><c:out value="${mentoRoom.nowCapacity}  /  ${mentoRoom.capacity} 명" /> </td>
    </tr>
    <tr>
        <th scope="row">진행중인 과제</th>
        <%--<c:if test="${과제 == null}">버튼 넣기</c:if> 과제 있는지 없는지 체크할것 --%>
        <td> 없음 or 있음
            멘토& 멘티 없을경우. &nbsp; <a type="button" class="btn btn-secondary" href="/MyStudy/UploadHomeWork">과제 생성</a><br>
            멘토 + 과제있을경우 &nbsp; <a type="button" class="btn btn-secondary" href="/MyStudy/HomeWorkInfo">과제 정보</a><br>
            멘토 + 과제 있 & 미제출&nbsp; <a type="button" class="btn btn-secondary" href="/MyStudy/UploadHomeWork">과제 정보 </a><br>
            멘토 + 과제 있 & 제출&nbsp; <a type="button" class="btn btn-secondary" href="/MyStudy/MenteeHomeWorkInfo">과제 정보확인(수정/삭제)</a><br>
        </td>
    </tr>
    </tbody>
</table>
</div>
<%@ include file="../includes/footer.jsp"%>