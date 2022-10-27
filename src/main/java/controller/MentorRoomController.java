package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MentorRoomController {

        @GetMapping("/MentoRoom")
        public String CreateMentoRoom(){

            return "/MentoRoom/createMR";
        }

    @GetMapping("/create")
    public String Create(){

        return "/MentoRoom/create";
    }

}
