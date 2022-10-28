package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import domain.User;
import service.UserService;
import validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
//        HttpSession session= request.getSession();
//        session.setAttribute("user_id",접속한 사람 아이디);
//        session.setAttribute("user_role", 아이디에 부여된 롤 );

        return "user/login";
    }

    @GetMapping("/join")
    public String join(@ModelAttribute("joinUserBean") User joinUserBean) {
        return "user/join";
    }

    @PostMapping("/join_pro")
    public String join_pro(@Valid @ModelAttribute("joinUserBean") User joinUserBean, BindingResult result) {
        if(result.hasErrors()) {
            return "user/join";
        }

        return "user/join_success";
    }



    @GetMapping("/modify")
    public String modify() {
        return "user/modify";
    }

    @GetMapping("/logout")
    public String logout() {

        return "user/logout";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        UserValidator validator1 = new UserValidator();
        binder.addValidators(validator1);
    }
}