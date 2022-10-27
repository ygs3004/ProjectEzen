package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MyStudy")
public class MyStudyMenteeController {

    @GetMapping("/Mentee")
    public String myStudyMentor(){

        return "/MyStudy/Mentee";
    }

}
