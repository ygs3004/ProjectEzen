package controller;

import domain.MentoRoom;
import mapper.MyStudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MyStudy")
public class MyStudyMentorController {

    @Autowired
    MyStudyMapper mapper;

    @GetMapping("/Mentor")
    public String myStudyMentor(String user_id, Model model){

        MentoRoom mentoRoom =  mapper.getMyStudyRoom(user_id);

        model.addAttribute("mentoRoom", mentoRoom);

        return "/MyStudy/Mentor";
    }


}
