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

</style>

<body>
<div class="container">
<form action="/MyStudy/UploadSuccess" method="post">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="hwName">과제명</label>
            <input type="type" class="form-control" id="hwName" placeholder="과제1" name="hwName" >
        </div>
    </div>
    <div class="form-group col-md-6">
        <label for="hwDeadLine">제출기한</label>
        <input type="date" class="form-control" id="hwDeadLine" name="hwDeadLine">
    </div>
    <div class="form-group">
        <label for="hwContent">과제내용</label>
        <textarea type="text" class="form-control" id="hwContent" name="hwContent" rows="30" cols="100"> </textarea>
    </div>
    <br>
    <input type="submit" class="btn btn-primary" value="과제 업로드">
</form>
</div>
</body>
</html>
<%@ include file="../includes/footer.jsp"%>
