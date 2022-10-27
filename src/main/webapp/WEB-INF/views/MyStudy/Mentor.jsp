<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .study-informartion{
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
        width:10%;
    }

</style>

<div class="container-sm study-informartion">
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col" colspan="2" bgcolor="">스터디 정보</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">스터디 이름</th>
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
        <%--<c:if test="${과제 == null}">버튼 넣기</c:if>--%>
        <td>
            없습무니다. &nbsp; <button type="button" class="btn btn-secondary pull-right" href="#">과제 생성</button>
        </td>
    </tr>
    </tbody>
</table>
</div>
<%@ include file="../includes/footer.jsp"%>