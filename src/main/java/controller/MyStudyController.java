package controller;

import domain.HomeWork;
import domain.MentoRoom;
import domain.User;
import mapper.MyStudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
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
    public String uploadSuccess(HomeWork homeWork, HttpServletRequest request){

        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("user_id");

        homeWork.setWriter(user_id);
        System.out.println(homeWork);

        mapper.uploadHomeWork(homeWork);

        return "/MyStudy/HomeWorkNow";
    }


}
