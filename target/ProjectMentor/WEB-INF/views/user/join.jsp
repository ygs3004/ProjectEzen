<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2022-10-26
  Time: 오후 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 가입</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원 가입</title>
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<script>
    function checkUserIdExist(){

        var user_id = $("#user_id").val()

        if(user_id.length == 0){
            alert('아이디를 입력해주세요')
            return
        }


        /*'#user_id'*/
        $.ajax({
            url : '${root}user/checkUserIdExist/' + user_id,
            type : 'get',
            dataType : 'text',
            success : function(result){
                if(result.trim() == 'true'){
                    alert('사용할 수 있는 아이디입니다')
                    $("#userIdExist").val('true')
                } else {
                    alert('사용할 수 없는 아이디 입니다')
                    $("#userIdExist").val('false')
                }
            }
        })
    }

    function resetUserIdExist(){
        $("#userIdExist").val('false')
    }

    function checkUserEmailExist(){
        var user_email = $("#user_email").val()
        if(user_email.length == 0){
            alert('이메일을 입력해주세요')
            return
        }

        $.ajax({
            url : '${'#user_email'}user/checkEmailExist/' + user_email,
            type : 'get',
            dataType : 'text',
            success : function(result){
                if(result.trim() == 'true'){
                    alert('사용할 수 있는 이메일 입니다')
                    $("#userEmailExist").val('true')
                } else {
                    alert('사용할 수 없는 이메일 입니다')
                    $("#userEmailExist").val('false')
                }
            }
        })
    }
    function resetUserEmailExist(){
        $('#userEmailExist').val('false')
    }
</script>
<body>

<c:import url="/WEB-INF/views/includes/header.jsp"/>
<h1 align="center">회원 가입</h1>
<div class="container" style="margin-top:100px">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="card shadow">
                <div class="card-body">
                    <form:form action="${root }user/join_pro" method='post' modelAttribute="joinUserBean">
                        <form:hidden path="userIdExist"/>
                      <div class="form-group">
                          멘토로 가입하기 <form:radiobutton path="user_role" value="1"></form:radiobutton>
                          <br>
                          멘티로 가입하기 <form:radiobutton path="user_role" value="2"></form:radiobutton>
                          <br>
                      </div>


                        <!-- 이름 -->
                          <div class="form-group">
                            <form:label path="user_name">이름</form:label>
                            <form:input path="user_name" class='form-control'/>
                            <form:errors path="user_name" style='color:red'/>
                        </div>
                        <!-- 아이디 & 중복확인 -->
                        <div class="form-group">
                            <form:label path="user_id">아이디</form:label>
                            <div class="input-group">
                                <form:input path="user_id" class='form-control' onkeypress="resetUserIdExist()"/>
                                <div class="input-group-append">
                                    <button type="button" class="btn btn-primary" onclick='checkUserIdExist()'>중복확인</button>
                                </div>
                            </div>
                            <form:errors path="user_id" style='color:red'/>
                        </div>

                        <!-- 비밀번호 입력 -->
                        <div class="form-group">
                            <form:label path="user_pw">비밀번호</form:label>
                            <form:password path="user_pw" class='form-control'/>
                            <form:errors path='user_pw' style='color:red'/>
                        </div>
                        <!-- 비밀번호 확인 -->
                        <div class="form-group">
                            <form:label path="user_pw2">비밀번호 확인</form:label>
                            <form:password path="user_pw2" class='form-control'/>
                            <form:errors path='user_pw2' style='color:red'/>
                        </div>
                        <!-- 이메일 입력 -->
                        <div class="form-group">
                            <form:label path="user_email">이메일</form:label>
                            <div class="input-group">
                                <form:input path="user_email" class='form-control' onkeypress="resetUserEmailExist()"/>
                               <!-- 이메일 중복 확인 -->
                                <div class="input-group-append">
                                    <button type="button" class="btn btn-primary" onclick='checkUserEmailExist()'>중복확인</button>
                                </div>
                            </div>
                            <form:errors path="user_email" style='color:red'/>
                            <!-- 전화 번호 -->
                            <div class="form-group">
                                <form:label path="user_phone">전화번호</form:label>
                                <form:input path="user_phone" class='form-control'/>
                                <form:errors path="user_phone" style='color:red'/>
                            </div>

                            <!--  성별 확인 (변경해야할듯 .. )-->
                            <div class="form-group">
                                <form:label path="user_gender">성별</form:label>
                                <form:input path="user_gender" class='form-control'/>
                                <form:errors path="user_gender" style='color:red'/>
                            </div>

                            <!-- 학교 입력 -->
                             <div class="form-group">
                                <form:label path="user_school">학교</form:label>
                                <form:input path="user_school" class='form-control'/>
                                <form:errors path="user_school" style='color:red'/>
                            </div>


                        <div class="form-group">
                            <div class="text-right">

                                <form:button class='btn btn-primary' >회원가입</form:button>

                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="col-sm-3"></div>
    </div>
</div>

<c:import url="/WEB-INF/views/includes/footer.jsp"/>

</body>
</html>

