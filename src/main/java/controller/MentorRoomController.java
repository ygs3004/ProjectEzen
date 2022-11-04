package controller;

import domain.MentorRoom;
import domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.MentorRoomService;
import service.MyStudyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/MentorRoom")
@RequiredArgsConstructor
public class MentorRoomController {

    final String user_id = "mentor_id"; //테스트용
    final MentorRoomService mentorRoomService;
    final MyStudyService myStudyService;


    //스터디개설 (추후 @SessionAttribute("user_id") String user_id 추가 )
    @GetMapping("/createRoom")
    public String CreateMentorRoom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user_id", user_id);

        //user_id 앞으로 개설된 방 있는지 확인
        boolean result = mentorRoomService.getAssignedRoomNo(user_id);
        if(result){
            request.setAttribute("message", "스터디는 한개만 개설할 수 있습니다.");
            return "redirect:/";
        }else{
            return "/MentorRoom/createRoom";
        }
    }

    //스터디개설 후 이동 (@SessionAttribute("user_id") String user_id)
    @PostMapping("/roomInfo")
    public String createRoom(HttpSession session, MentorRoom roomInfo, Model model){
        String user_id = (String)session.getAttribute("user_id");
//        roomInfo.setUser_id(user_id); //테스트
        System.out.println(user_id);
        mentorRoomService.createRoom(roomInfo); //roominfo db추가
        int roomNum = mentorRoomService.getRoomNoByID(roomInfo.getUser_id()); //id로 만들어진 roomNum 조회
        mentorRoomService.usersAddRoomNo(roomNum, roomInfo.getUser_id()); //roomNum user에 추가
        model.addAttribute("roomInfo",myStudyService.getMyStudyRoom(user_id));
        return "/MentorRoom/roomInfo";
    }




}
