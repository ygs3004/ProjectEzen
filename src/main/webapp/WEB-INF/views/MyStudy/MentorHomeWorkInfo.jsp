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

    .modifyInfo{
        display: flex;
        justify-content: center;
        align-items: center;
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
                <td class="hwName"><c:out value="${homeWork.hwName}"/></td>
            </tr>
            <tr>
                <th scope="row">제출기한</th>
                <td class="hwDeadLine"> <c:out value="${homeWork.hwDeadLine}"/> </td>
            </tr>
            <tr>
                <th scope="row">과제내용</th>
                <td class="hwContent">
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
        <div class="modifyInfo">
            <button type="button" class="btn btn-outline-success btn-sm">과제 내용 수정 / 삭제</button>
        </div>
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

        $(".modifyInfo").on("click", () =>{
            const hwName = $(".hwName");
            const hwDeadLine = $(".hwDeadLine");
            const hwContent = $(".hwContent");
            const modifyAndDeleteButton = $(".modifyInfo");

            const hwNameInput = "<input name='hwName' value='<c:out value="${homeWork.hwName}"/>'/>"
            const hwDeadLineInput = "<input name='hwDeadLine' type='date' value='<c:out value="${homeWork.hwDeadLine}"/>'/>"
            const hwContentTextarea = "<textarea rows='10' cols='40' value='${homeWork.hwContent}'></textarea>"
            const divideButton = "<button type='button' class='btn btn-outline-success btn-sm' data-oper='modify'>수정완료</button>"
                                + "&nbsp;&nbsp;<button type='button' class='btn btn-outline-success btn-sm' data-oper='delete'>삭제</button>"

            hwName.html(hwNameInput);
            hwDeadLine.html(hwDeadLineInput);
            hwContent.html(hwContentTextarea);
            modifyAndDeleteButton.html(divideButton);
        })

        $("button[data-oper='modify']").on("click", () =>{

        })

        $("button[data-oper='delete']").on("click", () =>{
            location.href="histori"
        })

    })


</script>

</html>
<c:import url="/WEB-INF/views/includes/footer.jsp"/>