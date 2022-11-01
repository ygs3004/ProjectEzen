// document.addEventListener('keydown', function(event) {
//     if (event.keyCode === 13) {
//         event.preventDefault();
//     };
// }, true);



function addCreerList() {
    const add = document.getElementById('addCareer').value;
    const p = document.createElement('p');
    const input = document.createElement('input');
    input.setAttribute('type',"hidden");
    input.setAttribute('name','career');
    input.setAttribute('value',add);
    const temp = document.createTextNode(add);
    p.appendChild(temp);

    document.getElementById('careerList').appendChild(p);
    document.getElementById('careerList').appendChild(input);
};

// const temp= document.getElementById("careerList");
// function addList(){
//     let add = document.getElementById("career").value;
//     temp.innerHTML += `<p>${add}</p>`;
// };

$(function() {
    $('input[name="studyPeriod"]').daterangepicker({
        autoUpdateInput: false,
        locale: {
            cancelLabel: 'Clear'
        }
    });
    $('input[name="studyPeriod"]').on('apply.daterangepicker', function(ev, picker) {
        $(this).val(picker.startDate.format('YYYY/MM/DD') + ' - ' + picker.endDate.format('YYYY/MM/DD'));
    });
    $('input[name="studyPeriod"]').on('cancel.daterangepicker', function(ev, picker) {
        $(this).val('');
    });
});


// $(function() {
//     $('input[name="datetimes"]').daterangepicker({
//         timePicker: true,
//         startDate: moment().startOf('hour'),
//         endDate: moment().startOf('hour').add(32, 'hour'),
//         locale: {
//             format: 'M/DD hh:mm A'
//         }
//     });
// // });
// let formCheck = document.getElementById("formCheck");
// formCheck.addEventListener("click", function () {
//     let form = document.getElementById("form"); // 스터디기간 폼 체크
//     let period = document.getElementById("studyPeriod");
//     let weekly = document.getElementsByName("studyWeekly"); // 요일 체크되었는지 확인
//     // var pw = document.getElementById("pw");
//
//     let periodRule = /\d{4}\/\d{2}\/\d{2} - \d{4}\/\d{2}\/\d{2}/;
//
//     if (!periodRule.test(period.value)) {
//         alert("날짜를 다시 입력하세요.");
//         period.focus();
//         return false;
//     }
//     form.action = "/createRoom";
//     form.mothod = "POST";
//     form.submit();
// });

//인원수 30이하 체크

