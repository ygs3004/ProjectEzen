package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MyStudy")
public class MyStudyMentorController {

    @GetMapping("/Mentor")
    public String myStudyMentor(){
        String asdf;
        return "/MyStudy/Mentor";
    }


}
