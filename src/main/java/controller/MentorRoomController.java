package controller;

import domain.MentoRoom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MentorRoomController {

    @GetMapping("/MentorRoom")
    public String CreateMentorRoom(){

        return "/MentorRoom/createRoom";
    }

//    @GetMapping("/StudyInfo")
//    public String myStudyMentor(String user_id, Model model, HttpServletRequest request){
//
//        HttpSession session = request.getSession();
//        session.setAttribute("user_id", user_id);
//        MentoRoom mentoRoom =  mapper.getMyStudyRoom(user_id);
//
//        model.addAttribute("mentoRoom", mentoRoom);
//        return "/MyStudy/StudyInfo";
//    }
//


}
