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
        //MentorRoom mentorRoom = mapper.createRoom(roomInfo);
        System.out.println(roomInfo.getStudyPeriod());
        System.out.println(roomInfo.getStudyWeekly());
        System.out.println(roomInfo.getStudyTimeStart());
        System.out.println(roomInfo.getStudyTimeEnd());
        System.out.println(roomInfo.getCareer());
        System.out.println(roomInfo.getUser_id());


        return "/roomInfo";
    }

//    @GetMapping("/StudyInfo")
//    public String myStudyMentor(String user_id, Model model, HttpServletRequest request){
//
//        HttpSession session = request.getSession();
//        session.setAttribute("user_id", user_id);
//        mentorRoom mentorRoom =  mapper.getMyStudyRoom(user_id);
//
//        model.addAttribute("mentorRoom", mentorRoom);
//        return "/MyStudy/StudyInfo";
//    }
}
