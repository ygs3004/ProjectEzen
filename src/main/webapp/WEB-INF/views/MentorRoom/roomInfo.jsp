<%--
  Created by IntelliJ IDEA.
  User: i7A-56
  Date: 2022-11-02
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../includes/header.jsp"%>
<section class="formHeader">
    <span id="formTitle"><b>스터디 정보</b></span>
    <p id="formDes">개설된 스터디 정보입니다.</p>
</section>
<div class="shadow p-3 mb-5 bg-white rounded formBody">
    <table>
        <tr>
            <td><c:out value="${roomInfo.title}"></td>
            <td><c:out value="${roomInfo.num}"></td>
        </tr>
    </table>
</div>

<%@ include file="../includes/footer.jsp"%>