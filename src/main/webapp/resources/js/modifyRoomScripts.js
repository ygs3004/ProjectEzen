// let weeklyList = new Array('mentorRoom.getWeeklyList}');
//
// for(let weeklys in weeklyList){
//     $("input:checkbox[value=weeklys]).prop("checked", true);
// };
// window.onload = function(){
//     // for(let btns in document.getElementById("delev")){
//     //     btns.addEventListener("click", delAct);
//     // }
//
//     // let weeklyList = new Array('mentorRoom.getWeeklyList');
//     //
//     // for(let weeklys in weeklyList){
//     //     $('[value=weeklys]').prop("checked", true);
//     // };
// }

function addCreerList() {
    const addstr = document.getElementById('addCareer');
    const li = document.createElement('li');
    const input = document.createElement('input');
    const del = document.createElement('a');

    //<input type="hidden" name="carrer" value=add.value>
    input.setAttribute('type',"hidden");
    input.setAttribute('name','career');
    input.setAttribute('value',addstr.value);

    //<a id="delByn">삭제</a>
    del.append("삭제");
    del.setAttribute('id','delBtn');
    del.addEventListener("click", delAct);

    //<p>str<input type="hidden" name="carrer" value=add.value><a>삭제</a></p>
    const str = document.createTextNode(addstr.value);
    li.appendChild(str);
    li.append(" ");
    li.appendChild(input);

    document.getElementById('careerList').appendChild(li).appendChild(del);
    addstr.value=""; //추가 후 input 비우기
};

function delAct(e) {
    const event = e || window.event;
    const targetElement = event.target.parentElement;
    targetElement.remove();
}