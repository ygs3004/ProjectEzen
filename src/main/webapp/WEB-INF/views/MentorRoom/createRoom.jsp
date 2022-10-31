<%--
  Created by IntelliJ IDEA.
  User: i7A-56
  Date: 2022-10-27
  Time: 오전 10:30
  To change this template use File | Settings | File Templates.
--%>
<style>
    #formTitle{font-size: 5vw; font-weight: bold;}
    #formDes{font-size: 15px;}
    /*input[type="text"][id="career"]{display:inline; outline:none; vertical-align:middle}*/
    input[id="addCareer"]{outline:none; display:inline; width:50px; height: 38px; font-size:12px; text-align: center;}
    .formHeader{width: 70%; margin: 4% auto 4% auto; display: block; text-align: center;} /*폼 헤더*/
    .formBody{width: 70%; margin: 5% auto 5% auto; display: block; }
    .user_name{font-size:3vh; font-weight: bold; margin: 3% auto 3% auto;}
    .studyWeekly{width: 9vw;}
    .useMove, .notMove { position:relative; height: 3.5em;}
    .desc{margin: -0.5em auto 1.2em 0.5em; font-size: 1.5vh;}
    .useMove label {position:relative;  left:0.5em; bottom:2em; width:100%; height:100%;  text-align:left; pointer-events:none; }
    .useMove label span {position:absolute;  left:0; transition:all .3s ease; } /**/
    .useMove input.form-control:focus + label span,
    .useMove input.form-control:valid + label span { transform:translateY(-120%); font-size:12px; background-color: #ffffff }
    .useMove input.form-control:focus + label::after,
    .useMove input.form-control:valid + label::after { width:100%; transform:translateX(0); }
    .useMove textarea.form-control:focus + label span,
    .useMove textarea.form-control:valid + label span { transform:translateY(-120%); font-size:12px; background-color: #ffffff }
    .useMove textarea.form-control:focus + label::after,
    .useMove textarea.form-control:valid + label::after { width:100%; transform:translateX(0); }
    span.block { position:relative; left:0.7em; bottom:4em; font-size:12px; background-color: #ffffff }
    input[type="time"]{width: 32vw;}
    .content{position:relative; left:0.7em; bottom:4em; top:-32em; font-size:12px; background-color: #ffffff }

    @media screen and (max-width: 900px) {
        #formTitle{font-size: 35px; font-weight: bold;}
        #formDes{font-size: 14px;}
        .formBody {width: 90%; margin: 3% auto 3% auto;}
        .studyWeekly{width:11vw;}
        input[type="time"]{width: 40vw;}
    }

</style>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<script type="text/javascript">
    // $(function() {
    //     $('input[name="datetimes"]').daterangepicker({
    //         timePicker: true,
    //         startDate: moment().startOf('hour'),
    //         endDate: moment().startOf('hour').add(32, 'hour'),
    //         locale: {
    //             format: 'M/DD hh:mm A'
    //         }
    //     });
    // });

    <%--    console.log(inputCareer);--%>
    <%--let inputCareer = document.getElementById("career").value;--%>
    <%--    function addCareer(){--%>
    <%--            const  tmp= document.getElementById("careerList");--%>
    <%--            tmp.innerText += `<p>${inputCareer}</p>`;--%>
    <%--    };--%>

    $(function() {
        $('input[name="datefilter"]').daterangepicker({
            autoUpdateInput: false,
            locale: {
                cancelLabel: 'Clear'
            }
        });

        // $(.addCareer).on("click",addCareer());

        $('input[name="datefilter"]').on('apply.daterangepicker', function(ev, picker) {
            $(this).val(picker.startDate.format('YYYY/MM/DD') + ' - ' + picker.endDate.format('YYYY/MM/DD'));
        });

        $('input[name="datefilter"]').on('cancel.daterangepicker', function(ev, picker) {
            $(this).val('');
        });

    });
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../includes/header.jsp"%>

<form action="createRoom" method="post">
    <div class="formHeader">
            <span id="formTitle"><b>스터디 개설</b></span>
            <p id="formDes">스터디를 개설해 멘티들을 모아볼까요?</p>
    </div>
    <div class="shadow p-3 mb-5 bg-white rounded formBody">
        <div class="user_name">
            <span>멘토 user_name 님</span>
        </div>
        <div class="useMove">
            <input type="text" class="form-control" id="title" autocomplete="on" required>
            <label for="title"><span>스터디 이름</span></label>
        </div>
        <div class="useMove">
            <input type="text" class="form-control" id="studyPeriodStart" name="datefilter" required>
            <label for="studyPeriodStart"><span>스터디 기간</span></label>
        </div>
            <div class="notMove">
         <div style="display: flex;justify-content: space-between;">
             <div>
                <input type="checkbox" class="btn-check" name="studyWeekly" id="mon" value="1">
                <label class="btn btn-outline-primary studyWeekly" for="mon">월</label>
             </div>
             <div>
                <input type="checkbox" class="btn-check" name="studyWeekly" id="tue" value="2">
                <label class="btn btn-outline-primary studyWeekly" for="tue">화</label>
             </div>
             <div>
                <input type="checkbox" class="btn-check" name="studyWeekly" id="wed" value="3">
                <label class="btn btn-outline-primary studyWeekly" for="wed">수</label>
             </div>
             <div>
                <input type="checkbox" class="btn-check" name="studyWeekly" id="thur" value="4">
                <label class="btn btn-outline-primary studyWeekly" for="thur">목</label>
             </div>
             <div>
                <input type="checkbox" class="btn-check" name="studyWeekly" id="fri" value="5">
                <label class="btn btn-outline-primary studyWeekly" for="fri">금</label>
             </div>
             <div>
                <input type="checkbox" class="btn-check" name="studyWeekly" id="sat" value="6">
                <label class="btn btn-outline-primary studyWeekly" for="sat">토</label>
             </div>
             <div>
                <input type="checkbox" class="btn-check" name="studyWeekly" id="sun" value="7">
                <label class="btn btn-outline-primary studyWeekly" for="sun">일</label>
             </div>
         </div>
            </div>
            <div style="display: flex; justify-content: space-between;">
            <div class="useMove">
                <div><input type="time" class="form-control" id="studyTimeStart" value="09:00" required>
                    <label for="studyTimeStart"><span>스터디 시간</span></label></div>
            </div>
            <div class="useMove">
                <input type="time" class="form-control" id="studyTimeEnd" value="18:00" required>
                <label for="studyTimeEnd"><span>스터디 종료 시간</span></label>
            </div>
            </div>
        <div class="useMove">
            <input type="number" class="form-control" id="capacity" min="1" max="30" required>
            <label for="capacity"><span>모집인원</span></label>
        </div>
        <div class="desc">
            <span> * 최대인원 30명</span>
        </div>
        <div style="display: flex;justify-content: space-between;">
            <div class="useMove">
                <input type="text" class="form-control" id="career" required onchange="">
                <label for="career"><span>멘토 경력</span></label>
            </div>
            <input type="button" class="form-control btn-outline-primary" id="addCareer" value="add" onclick="addCareer()">
        </div>
        <div id="careerList">
            <p>경력1</p>
            <p>경력2</p>
        </div>
        <div class="notMove">
            <input type="text" class="form-control" id="school" value="user_school" readonly>
            <label for="school"><span class="block">멘토 학력</span></label>
        </div>
        <div>
            <textarea class="form-control" id="content" rows="15" style="resize: none;"></textarea>
            <label for="content"><span class="content">스터디 상세설명</span></label>
        </div>
        <div style="text-align: center; margin-bottom: 2%;"><button type="submit" class="btn btn-primary">스터디 개설</button></div>
    </div>
</form>

<%@ include file="../includes/footer.jsp"%>
