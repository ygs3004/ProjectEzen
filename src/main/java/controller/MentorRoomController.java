package controller;

import dao.UserDao;
import domain.MentorRoom;
import domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.MentorRoomService;
import service.MyStudyService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/MentorRoom")
@RequiredArgsConstructor
public class MentorRoomController {

    @Resource(name = "loginUserBean")
    private User loginUserBean;

    final UserDao userDao;
    final MentorRoomService mentorRoomService;
    final MyStudyService myStudyService;
    final HomeController homeController;

    //스터디개설
    @GetMapping("/createRoom")
    public String CreateMentorRoom(HttpServletResponse response) throws IOException {
        //user_id 앞으로 개설된 방 있는지 확인
        boolean result = mentorRoomService.getAssignedRoomNo(loginUserBean.getUser_id());
        if(result){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('스터디는 한개만 개설할 수 있습니다.'); history.back();</script>");
            out.close();
//            request.setAttribute("message", "스터디는 한개만 개설할 수 있습니다.");
            return homeController.home();
        }else{
            return "/MentorRoom/createRoom";
        }
    }

    //스터디개설 후 이동
    @PostMapping("/roomInfo")
    public String createRoom(MentorRoom mentorRoom, Model model){
        mentorRoom.setNum(0);
        mentorRoom.setUser_id(loginUserBean.getUser_id());
        mentorRoomService.createRoom(mentorRoom, loginUserBean.getUser_id());
        boolean checkHomeWork = myStudyService.checkHomeWork(loginUserBean.getUser_id());
        model.addAttribute("mentorRoom", mentorRoom);
        model.addAttribute("checkHomeWork", checkHomeWork);
        return "/MyStudy/StudyInfo";
    }

    @GetMapping("/modifyRoom")
    public String modifyRoom(Model model){
        MentorRoom roomInfo = mentorRoomService.getRoomInfoByID(loginUserBean.getUser_id());
        model.addAttribute("mentorRoom",roomInfo);
        return "/MentorRoom/modifyRoom";
    }

}