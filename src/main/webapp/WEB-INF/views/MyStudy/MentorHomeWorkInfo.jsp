<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/includes/header.jsp"/>
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
            <th scope="row">제출자 명단 ajax</th>
            <td>
                <ul class="uploadedHwList">
                    <%--ajax 출력--%>
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

    var uploadedHwList = $(".uploadedHwList");

    function showUploadedHwList(uploadedHwResultArr){

        let str = "";

        $(uploadedHwResultArr).each((i, obj) =>{

            str += "<li> 제출자 : " + obj.user_id + " 제출일 : " + obj.hwRegDate + "</li>";
            str += "<textarea rows='5' cols='40' readonly>" + obj.content + "/></textarea>"

            if(obj.filename) {
                let uploadPathArr = obj.uploadPath.split(",");
                let uuidArr = obj.uuid.split(",")
                let filenameArr = obj.filename.split(",");

                for(let j=0; j<filenameArr.length; j++){
                    if(filenameArr[j].length>0) {
                        let fileCallPath = encodeURIComponent(uploadPathArr[j] + "/" + uuidArr[j] + "_" + filenameArr[j]);
                        str += "<li><a href='/MyStudy/downloadHw?filename=" + fileCallPath + "'> 첨부파일 : " + filenameArr[j] + "</a></li>";
                    }
                }
            }

        })

        uploadedHwList.append(str);
    }

    let writer = '<c:out value="${homeWork.writer}"/>';

    $(function(){
        $.getJSON("/MyStudy/homeWorkList", {writer:writer}, function(hwList) {
            console.log(hwList);
            showUploadedHwList(hwList);

        });
    })
       /* 참고 예제
        $.getJSON("/replies/pages/"+bno+"/"+page+".json",
            function(data){
                if(callback){
                    //callback(data); // 댓글 목록만 가져오는 경우
                    callback(data.replyCnt, data.list);
                }
            }).fail(function(xhr, status, er){
                if(error){
                    error();
                }
            }
        );
        */

</script>

</html>
<c:import url="/WEB-INF/views/includes/footer.jsp"/>