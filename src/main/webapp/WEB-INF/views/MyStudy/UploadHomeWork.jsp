<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../includes/header.jsp"%>
<html>
<head>
    <title>UploadHomeWork</title>
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

    label{
        margin-top : 20px;
    }

</style>

<body>
<div class="container">
<form action="/MyStudy/UploadSuccess" method="post">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="hwName">과제명</label>
            <input type="text" class="form-control" id="hwName" placeholder="과제1" name="hwName" >
        </div>
    </div>
    <div class="form-group col-md-6">
        <label for="hwDeadLine">제출기한</label>
        <input type="date" class="form-control" id="hwDeadLine" name="hwDeadLine">
    </div>
    <div class="form-group">
        <label for="hwContent">과제내용</label>
        <textarea type="text" class="form-control" id="hwContent" name="hwContent" rows="15" cols="70"></textarea>
    </div>
    <br>
    <input type="hidden" name="completeMentee" value="0">
    <button type="submit" class="btn btn-primary" onclick="return checkSubmit()">과제 게시하기</button>
</form>
</div>
</body>
</html>
<script>

    function getFormatDate(date){
        var year = date.getFullYear();              //yyyy
        var month = (1 + date.getMonth());          //M
        month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
        var day = date.getDate();                   //d
        day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
        return  year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
    }

    const checkSubmit = () => {

        let today = new Date();
        let date = getFormatDate(today);
        console.log($("#hwDeadLine").val())
        console.log(date)

        if($("#hwName").val().trim().length <= 0){
            alert("과제명을 입력해주세요");
            $("#hwName").onfocus;
            return false;
        }

        if($("#hwDeadLine").val().length <= 0){
            alert("제출 기한을 입력해주세요");
            return false;
        }

        if($("#hwDeadLine").val() <= date){
            alert("제출 기한일이 적절치 않습니다.(과제 등록 이후 날짜로 지정해주세요)")
            return false;
        }

        if($("#hwContent").val().trim().length <= 0){
            alert("과제 내용을 입력해주세요");
            $("#hwContent").onfocus;
            return false;
        }

        return true;
    }
</script>

<%@ include file="../includes/footer.jsp"%>
