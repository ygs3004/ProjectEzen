<%--
  Created by IntelliJ IDEA.
  User: i7A-56
  Date: 2022-10-27
  Time: 오전 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../includes/header.jsp"%>
<style>
    table {
        width: 80%;
        margin-top: 10%;
        margin-right: auto;
        margin-left: auto;
    }
    tr, td{
        certical-align : middle;
    }

</style>

<form action="#" method="post">
<table>
    <tr>
        <td><label for="title" class="col-sm-2 col-form-label">스터디 이름</label></td>
        <td><input type="text" class="form-control" id="title" placeholder="제목"></td>
    </tr>
    <tr>
        <td><label for="name" class="col-sm-2 col-form-label">멘토명</label></td>
        <td><input type="text" readonly class="form-control-plaintext" id="name" value="#"></td>
    </tr>
    <tr>
        <td rowspan="2"><label class="col-sm-2 col-form-label">스터디 기간</label></td>
        <td><input type="date" class="form-control-plaintext" id="studyDayStart">
        <input type="time" id="studyTimeStart"></td>
    </tr>
    <tr>
        <td><input type="date" class="form-control-plaintext" id="studyDayEnd">
        <input type="time" id="studyTimeEnd"></td>
    </tr>
    <tr>
        <td><label for="capacity" class="col-sm-2 col-form-label">모집인원</label></td>
        <td><select class="custom-select" id="capacity">
            <option selected>선택 (최대 7명)</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
        </select></td>
    </tr>
    <tr>
        <td><label for="career" class="col-sm-2 col-form-label">멘토 경력</label></td>
        <td><input type="text" class="form-control" id="career" height="50"></td>
    </tr>
    <tr>
        <td><label for="school" class="col-sm-2 col-form-label">멘토 학력</label></td>
        <td><input type="text" readonly class="form-control-plaintext" id="school" value="user_school"></td>
    </tr>
    <tr>
        <td><label for="content">스터디 상세설명</label></td>
        <td><textarea class="form-control" id="content" rows="10"></textarea></td>
    </tr>
    <tr>
        <td><button type="submit" class="btn btn-primary">스터디개설하기</button></td>
    </tr>
</table>
</form>

<%@ include file="../includes/footer.jsp"%>
