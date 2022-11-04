// document.addEventListener('keydown', function(event) {
//     if (event.keyCode === 13) {
//         event.preventDefault();
//     };
// }, true);

function addCreerList() {
    const add = document.getElementById('addCareer');
    const p = document.createElement('p');
    const input = document.createElement('input');
    const delBtn = document.createElement('button');
    // const a = document.createElement('a');
    input.setAttribute('type',"hidden");
    input.setAttribute('name','career');
    input.setAttribute('value',add.value);

    // a.append("x");
    // a.setAttribute('onclick','delCareer()');
    const temp = document.createTextNode(add.value);
    p.appendChild(temp);
    document.getElementById('careerList').appendChild(p);
    document.getElementById('careerList').appendChild(input);
    add.value="";
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

//입력값이 잘못된 경우 false를 리턴.
function doCheck(){
    let enPeriod = document.getElementById("studyPeriod").value;
    let periodRule = /\d{4}\/\d{2}\/\d{2} - \d{4}\/\d{2}\/\d{2}/; //폼양식
    let enWeekly = document.querySelectorAll("input[type=checkbox][name=studyWeekly]:checked"); //체크된 요일리스트 불러오기
    if(document.getElementById("title").value.length == 0){
        alert('스터디 이름을 입력해주세요.')
        document.getElementById("title").focus();
        return false;
    }
    //스터디 기간 양식에 맞는지 확인
    if(!periodRule.test(enPeriod)){
            alert('스터디 기간을 정확히 입력해주세요.\r(YYYY/MM/DD - YYYY/MM/DD)')
            document.getElementById("studyPeriod").focus();
        return false;
    }
    //요일이 선택되었는지 확인
    if(enWeekly.length == 0 | enWeekly==null){
        alert('요일을 선택해 주세요.');
        return false;
    }

    if(document.getElementById("capacity").value.length == 0){
        alert('모집인원을 입력해주세요.');
        return false;
    }

    if(document.getElementById("content").value.length == 0){
        alert('상세설명을 입력해주세요.');
        return false;
    }
        return lastCheck();
}
function lastCheck() {
    if (confirm("스터디를 등록하시겠습니까?") == true){    //확인
        return true;
    }else{   //취소
        return false;
    }
}

