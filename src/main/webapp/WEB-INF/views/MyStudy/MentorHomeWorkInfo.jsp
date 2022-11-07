<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
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

    .container {
        margin-top: 40px;
        margin-bottom: 40px;
    }

    .study-informartion {
        margin-top: 40px;
        margin-bottom: 40px;
        width: 70%;
    }

    table {
        height: 70%;
        width: 70%;
    }

    th, td {
        vertical-align: middle;
    }

    th {
        text-align: center;
        width: 30%;
    }

    textarea {
        resize: none;
    }

    ul, li {
        list-style: none;
        padding-left: 0;
        margin-bottom: 15px;
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
                <ul>
                <c:forEach var="hw" items="${hwList}" varStatus="index">
                    <li>
                        <c:out value="${index.count}. 제출자 : ${hw.user_id}, 제출일 : ${hw.hwRegDate}"/><br>
                        <textarea rows="5" cols="15" readonly>
                            <c:out value="${hw.content}"/>
                        </textarea>
                        <br>
                        <a href="#"><c:out value="첨부파일 : ${hw.filename}"/></a>
                    </li>
                </c:forEach>
                </ul>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous"></script>
<script>
    $(function () {

        let writer = '<c:out value="${homeWork.writer}"/>';

        $.getJSON("/MyStudy/homeWorkList", {writer: writer},
            arr => console.log(arr)
        )
    });
</script>

</html>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>