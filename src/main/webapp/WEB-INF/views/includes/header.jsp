<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<style>

    #grean{
        height: 710px;

    }
</style>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>-Welcome Our Mentor-</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="/assets/favicons.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="/css/styles.css" rel="stylesheet" />
    <%--jquery--%>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
</head>
<body id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
    <div class="container">

        <a class="navbar-brand" href="/">우리의 멘토</a>

        <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/board/boardList">자유게시판</a></li>
<%--                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/user/login">로그인</a></li>--%>
<%--                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/user/join">회원가입</a></li>--%>
                <%-- 멘토 : user_role==1 멘티 : user_role==2 --%>
                <c:choose>  <%-- 로그인 했을경우--%>
                    <c:when test="${loginUser.userLogin}">
                        <li class="nav-item">
                            <a href="${root}/user/modify" class="nav-link">회원수정</a>
                        </li>
                        <li class="nav-item">
                            <a href="${root}/user/logout" class="nav-link">로그아웃</a>
                        </li>
                    </c:when>
                    <c:otherwise> <%-- 로그인 하지않았을 경우 --%>
                        <li class="nav-item">
                            <a href="${root}/user/login" class="nav-link">로그인</a>
                        </li>
                        <li class="nav-item">
                            <a href="${root}/user/join"class="nav-link">회원가입</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${!loginUser.userLogin}"> <!-- 로그인하지 않았을 경우 -->
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/user/login">마이스터디</a></li>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${loginUser.mentorRoomNo >= 1}">
                            <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/MyStudy/StudyInfo">마이스터디</a></li>
                        </c:if>
                        <c:if test="${loginUser.mentorRoomNo == 0}">
                            <c:if test="${loginUser.user_role == 1}">
                                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/MentorRoom/createRoom">마이스터디</a></li>
                            </c:if>
                        </c:if>
                    </c:otherwise>
                </c:choose>

                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="#abouttime">어바웃(타임)</a></li>
                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="#moviecontact">(영화)콘택트</a></li>
                <c:choose>  <%-- 로그인 했을경우 회원탈퇴란 생성--%>
                    <c:when test="${loginUser.userLogin}">
                        <li class="nav-item">
                            <a href="${root}/user/delete" class="nav-link">회원탈퇴</a>
                        </li>
                    </c:when>
                </c:choose>
            </ul>
        </div>

    </div>
</nav>
<!-- Masthead-->

<header class="masthead bg-primary text-white text-center" id="grean">


    <div class="container d-flex align-items-center flex-column">
        <!-- Masthead Avatar Image-->
        <img src="..\img\mento.png" width="400" height="185"/>
        <!-- Masthead Heading-->
        <br>
        <br>
        <h3 class="masthead-heading text-uppercase mb-0">멘토 멘티 사이트</h3>
        <br>
        <br>

        <h3 class="masthead-heading text-uppercase mb-0"> 멘토 멘티</h3>
        <!-- Icon Divider-->
        <div class="divider-custom divider-light">
            <div class="divider-custom-line"></div>
            <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
            <div class="divider-custom-line"></div>
        </div>
        <!-- Masthead Subheading-->
        <p class="masthead-subheading font-weight-light mb-0">우리의 멘토 </p>
    </div>

</header>

