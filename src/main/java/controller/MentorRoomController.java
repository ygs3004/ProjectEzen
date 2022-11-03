package controller;

import domain.MentorRoom;
import domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.MentorRoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/MentorRoom")
@RequiredArgsConstructor
public class MentorRoomController {

    final String user_id = "mentor_id"; //테스트용
    final MentorRoomService mentorRoomService;


    //스터디개설 (추후 @SessionAttribute("user_id") String user_id 추가 )
    @GetMapping("/createRoom")
    public String CreateMentorRoom(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("user_id", user_id);

        //user_id 앞으로 개설된 방 있는지 확인
        boolean result = mentorRoomService.getAssignedRoomNo(user_id);
        if(result){
            System.out.println("이미 개설된 스터디룸이 있습니다.");
            return "/index";
        }else{
            return "/MentorRoom/createRoom";
        }
    }

    //스터디개설 후 이동 (@SessionAttribute("user_id") String user_id)
    @PostMapping("/roomInfo")
    public String createRoom(MentorRoom roomInfo, Model model){
        roomInfo.setUser_id(user_id); //테스트

        System.out.println(roomInfo.getNum());
        System.out.println(roomInfo.getUser_id());
        System.out.println(roomInfo.getTitle());
        System.out.println(roomInfo.getStudyPeriod());
        System.out.println(roomInfo.getStudyWeekly());
        System.out.println(roomInfo.getStudyTimeStart());
        System.out.println(roomInfo.getStudyTimeEnd());
        System.out.println(roomInfo.getCapacity());
        System.out.println(roomInfo.getNowCapacity());
        System.out.println(roomInfo.getCareer());
        System.out.println(roomInfo.getSchool());
        System.out.println(roomInfo.getContent());

        mentorRoomService.createRoom(roomInfo); //roominfo db추가
        int roomNum = mentorRoomService.getUserMentorRoomByID(roomInfo.getUser_id()).getNum(); //id로 만들어진 roomNum 조회
        mentorRoomService.usersAddRoomNo(roomNum, roomInfo.getUser_id()); //roomNum user에 추가

        return "/MentorRoom/roomInfo";
    }




}
