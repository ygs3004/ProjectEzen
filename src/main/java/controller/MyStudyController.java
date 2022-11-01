package controller;

import domain.HomeWork;
import domain.MentorRoom;
import domain.User;
import lombok.RequiredArgsConstructor;
import mapper.MyStudyMapper;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MyStudyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/MyStudy")
@RequiredArgsConstructor
public class MyStudyController {

    MyStudyService myStudyService;

    @GetMapping("/StudyInfo")
    public String myStudyMentor(String user_id, Model model, HttpServletRequest request){

        HttpSession session =  request.getSession();
        session.setAttribute("user_id", user_id);
        MentorRoom mentorRoom =  myStudyService.getMyStudyRoom(user_id);

        model.addAttribute("mentorRoom", mentorRoom);
        return "/MyStudy/StudyInfo";
    }

    @GetMapping("/UploadHomeWork")
    public String uploadHomeWork(User user){
        return "/MyStudy/UploadHomeWork";
    }

    @PostMapping("/UploadSuccess")
    public String uploadSuccess(HomeWork homeWork, HttpServletRequest request, Model model){

        String user_id = User.getSessionUserId(request);

        homeWork.setWriter(user_id);

        int success = myStudyService.uploadHomeWork(homeWork);
        model.addAttribute("homeWork", homeWork);

        return "redirect:/MyStudy/MentorHomeWorkInfo";
    }

    @GetMapping("/MentorHomeWorkInfo")
    public String MentorHomeWorkInfo (HttpServletRequest request, Model model) {

        String user_id = User.getSessionUserId(request);

        HomeWork homeWork = myStudyService.getHomeWork(user_id);
        MentorRoom mentorRoom = myStudyService.getMyStudyRoom(user_id);

        model.addAttribute("homeWork", homeWork);
        model.addAttribute("mentorRoom", mentorRoom);

        return "/MyStudy/MentorHomeWorkInfo";
    }

    @GetMapping("/MenteeHomeWorkInfo")
    public String MenteeHomeWorkInfo(String user_id){

        HomeWork homeWork = myStudyService.getHomeWork(user_id);

        return "/MyStudy/MenteeHomeWorkInfo";
    }

    @PostMapping("/HomeWorkSubmit")
    public String HomeWorkSubmit(){
        return "/MyStudy/HomeWorkSubmit";
    }

}
