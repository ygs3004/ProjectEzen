package controller;

import dao.UserDao;
import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.MentorRoomService;
import service.MyStudyService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/MentorRoom")
@RequiredArgsConstructor
public class MentorRoomController {

    final String user_id = "mentor_id"; //테스트용
    final UserDao userDao;
    final MentorRoomService mentorRoomService;
    final MyStudyService myStudyService;
    final HomeController homeController;
    final MyStudyController myStudyController;


    //스터디개설 (추후 @SessionAttribute("user_id") String user_id 추가 )
    @GetMapping("/createRoom")
    public String CreateMentorRoom(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user_id", user_id);

        //user_id 앞으로 개설된 방 있는지 확인
        boolean result = mentorRoomService.getAssignedRoomNo(user_id);
        if(result){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('스터디는 한개만 개설할 수 있습니다.'); history.back();</script>");
            out.close();
//            request.setAttribute("message", "스터디는 한개만 개설할 수 있습니다.");
            return "redirect:/";
        }else{
            model.addAttribute("user_school",mentorRoomService.getUserByID(user_id).getUser_school());
            model.addAttribute("user_name",mentorRoomService.getUserByID(user_id).getUser_name());

            return "/MentorRoom/createRoom"+user_id;
        }
    }

    //스터디개설 후 이동 (@SessionAttribute("user_id") String user_id)
    @PostMapping("/roomInfo")
    public String createRoom(HttpSession session, MentorRoom roomInfo, Model model){
        String user_id = (String)session.getAttribute("user_id");
        roomInfo.getUser_id();
        roomInfo.setUser_id(user_id);
        mentorRoomService.createRoom(roomInfo); //roominfo db추가
        int roomNum = mentorRoomService.getRoomNoByID(roomInfo.getUser_id()); //id로 만들어진 roomNum 조회
        mentorRoomService.usersAddRoomNo(roomNum, roomInfo.getUser_id()); //roomNum user에 추가

        //StudyInfo
        model.addAttribute("mentorRoom", roomInfo);

        //
        int user_role = userDao.getUserInfo(user_id).getUser_role();
        System.out.println("user_role"+user_role);
        boolean checkHomeWork = myStudyService.checkHomeWork(user_id);
        System.out.println("checkHomeWork"+checkHomeWork);

        model.addAttribute("user_id",user_id);
        model.addAttribute("user_role", user_role);
        model.addAttribute("checkHomeWork", checkHomeWork);
        return "redirect:/MyStudy/StudyInfo";
    }




}
