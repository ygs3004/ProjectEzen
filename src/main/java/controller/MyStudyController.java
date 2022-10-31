package controller;

import domain.HomeWork;
import domain.MentoRoom;
import domain.User;
import mapper.MyStudyMapper;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/MyStudy")
public class MyStudyController {

    @Autowired
    MyStudyMapper mapper;

    @GetMapping("/StudyInfo")
    public String myStudyMentor(String user_id, Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        session.setAttribute("user_id", user_id);
        MentoRoom mentoRoom =  mapper.getMyStudyRoom(user_id);

        model.addAttribute("mentoRoom", mentoRoom);
        return "/MyStudy/StudyInfo";
    }

    @GetMapping("/UploadHomeWork")
    public String uploadHomeWork(User user){
        return "/MyStudy/UploadHomeWork";
    }

    @PostMapping("/UploadSuccess")
    public String uploadSuccess(HomeWork homeWork, HttpServletRequest request, Model model){

        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("user_id");

        homeWork.setWriter(user_id);

        int success = mapper.uploadHomeWork(homeWork);
        model.addAttribute("homeWork", homeWork);

        return "redirect:/MyStudy/MentorHomeWorkInfo";
    }

    @GetMapping("/MentorHomeWorkInfo")
    public String MentorHomeWorkInfo (HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("user_id");

        HomeWork homeWork = mapper.getHomeWork(user_id);
        MentoRoom mentoRoom = mapper.getMyStudyRoom(user_id);

        model.addAttribute("homeWork", homeWork);
        model.addAttribute("mentoRoom", mentoRoom);

        return "/MyStudy/MentorHomeWorkInfo";
    }

    @GetMapping("/MenteeHomeWorkInfo")
    public String MenteeHomeWorkInfo(){
        return "/MyStudy/MenteeHomeWorkInfo";
    }

    @PostMapping("/HomeWorkSubmit")
    public String HomeWorkSubmit(){
        return "/MyStudy/HomeWorkSubmit";
    }

}
