package controller;

import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MentorRoomService;

@Controller
@RequestMapping("/MentorRoom")
@RequiredArgsConstructor
public class MentorRoomController {

    final MentorRoomService mentorRoomService;

    @GetMapping("/createRoom")
    public String CreateMentorRoom(){
        //user_id 받아야함.
        return "/MentorRoom/createRoom";
    }

    @PostMapping("/roomInfo")
    public String createRoom(MentorRoom roomInfo){
        mentorRoomService.createRoom(roomInfo);
        return "/MentorRoom/roomInfo";
    }


}
