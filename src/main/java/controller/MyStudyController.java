package controller;

import dao.UserDao;
import domain.HomeWork;
import domain.HomeWorkInfo;
import domain.MentorRoom;
import domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import service.MyStudyService;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@Log4j
@RequestMapping("/MyStudy")
@RequiredArgsConstructor
public class MyStudyController {

    final MyStudyService myStudyService;

    final UserDao userDao;

    @GetMapping("/StudyInfo")
    public String myStudy(String user_id, Model model, HttpSession session){

        // 접속한 회원의 멘토룸 정보
        session.setAttribute("user_id", user_id);
        MentorRoom mentorRoom =  myStudyService.getMyStudyRoom(user_id);
        // 접속한 회원의 등급정보
        int user_role = userDao.getUserInfo(user_id).getUser_role();
        //접속한 회원의 과제 유무 체크
        boolean checkHomeWork = myStudyService.checkHomeWork(user_id);

        model.addAttribute("mentorRoom", mentorRoom);
        model.addAttribute("user_role", user_role);
        model.addAttribute("checkHomeWork", checkHomeWork);
        return "/MyStudy/StudyInfo";
    }

    @GetMapping("/UploadHomeWork")
    public String uploadHomeWork(User user){
        return "/MyStudy/UploadHomeWork";
    }

    @PostMapping("/UploadSuccess")
    public String uploadSuccess(HomeWorkInfo homeWorkInfo, HttpSession session, Model model){

        String user_id = (String) session.getAttribute("user_id");

        homeWorkInfo.setWriter(user_id);

        int success = myStudyService.uploadHomeWorkInfo(homeWorkInfo);
        model.addAttribute("homeWork", homeWorkInfo);

        return "redirect:/MyStudy/MentorHomeWorkInfo";
    }

    @GetMapping("/MentorHomeWorkInfo")
    public String MentorHomeWorkInfo (HttpSession session, Model model) {

        String user_id = (String) session.getAttribute("user_id");

        HomeWorkInfo homeWorkInfo = myStudyService.getHomeWork(user_id);
        MentorRoom mentorRoom = myStudyService.getMyStudyRoom(user_id);

        model.addAttribute("homeWork", homeWorkInfo);
        model.addAttribute("mentorRoom", mentorRoom);

        return "/MyStudy/MentorHomeWorkInfo";
    }

    @GetMapping("/MenteeHomeWorkInfo")
    public String MenteeHomeWorkInfo(HttpSession session, Model model){

        String user_id = (String) session.getAttribute("user_id");
        HomeWorkInfo homeWorkInfo = myStudyService.getHomeWork(user_id);

        model.addAttribute("homeWork", homeWorkInfo);

        return "/MyStudy/MenteeHomeWorkInfo";
    }

    @GetMapping("/HomeWorkSubmitForm")
    public String HomeWorkSubmit(HttpSession session, Model model){

        String user_id = (String) session.getAttribute("user_id");
        HomeWorkInfo homeWorkInfo = myStudyService.getHomeWork(user_id);

        model.addAttribute("homeWork", homeWorkInfo);

        return "/MyStudy/HomeWorkSubmitForm";
    }

    @PostMapping("/HomeWorkSubmit")
    public String homeWorkSubmit(HomeWork homeWork, MultipartFile[] uploadFile){

        myStudyService.homeWorkSubmit(homeWork, uploadFile);

        return "redirect:/MyStudy/MenteeHomeWorkInfo";
    }


}
