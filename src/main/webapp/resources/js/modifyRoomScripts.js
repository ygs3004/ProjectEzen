// let weeklyList = new Array('mentorRoom.getWeeklyList}');
//
// for(let weeklys in weeklyList){
//     $("input:checkbox[value=weeklys]).prop("checked", true);
// };
window.onload = function(){
    let delBtn = document.querySelector(".delev");
    delBtn.addEventListener("click", delAct);

    let weeklyList = new Array('mentorRoom.getWeeklyList');

    for(let weeklys in weeklyList){
        $(value=weeklys).prop("checked", true);
    };
}

function delAct(event){
    const removeLine = event.target.parentElement;
    removeLine.remove();
}