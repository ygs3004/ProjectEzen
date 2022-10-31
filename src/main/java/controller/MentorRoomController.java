package controller;

import domain.MentorRoom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MentorRoomController {


    @GetMapping("/MentorRoom")
    public String CreateMentorRoom(){

        return "/MentorRoom/createRoom";
    }

    @PostMapping("/createRoom")
    public String createRoom(MentorRoom roomInfo){

        return "/mentorRoominfo";
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
