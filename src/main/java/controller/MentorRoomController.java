package controller;

import domain.MentorRoom;
import domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import service.MentorRoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/MentorRoom")
@RequiredArgsConstructor
public class MentorRoomController {
    final MentorRoomService mentorRoomService;

    //스터디개설 (추후 @SessionAttribute String user_id 추가 )
    @GetMapping("/createRoom")
    public String CreateMentorRoom(HttpServletRequest request){
        HttpSession session =  request.getSession();
        session.setAttribute("user_id", "김멘토");
        return "/MentorRoom/createRoom";
    }

    //스터디개설 후 이동
    @PostMapping("/roomInfo")
    public String createRoom(MentorRoom roomInfo, @SessionAttribute String user_id, Model model){
        mentorRoomService.createRoom(roomInfo); //roominfo db추가
        mentorRoomService.usersAddRoomNo(roomInfo.getNum(), user_id);
        model.addAttribute("roomInfo", roomInfo);
        return "redirect:/MentorRoom/roomInfo";
    }


}
