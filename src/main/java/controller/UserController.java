package controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import domain.User;
import service.UserService;
import validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Resource(name = "loginUser")
//    private User loginUser;


    @GetMapping("/login")
    public String login(@ModelAttribute("tempLoginUserBean") User tempLoginUserBean,
                        @RequestParam(value = "fail", defaultValue = "false") boolean fail,
                        Model model) {

        model.addAttribute("fail", fail);

        return "user/login";
    }

    @PostMapping("/login_pro")
    public String login_pro(@Valid @ModelAttribute("tempLoginUser") User tempLoginUser, BindingResult result) {

        if(result.hasErrors()) {
            return "user/login";
        }

//        userService.getLoginUserInfo(tempLoginUser);

//        if(loginUser.isUserLogin() == true) {
            return "user/login_success";
//        } else {
//            return "user/login_fail";
//        }
    }

    @GetMapping("/join")
    public String join(@ModelAttribute("joinUser") User joinUserBean) {
        return "user/join";
    }

    @PostMapping("/join_pro")
    public String join_pro(@Valid @ModelAttribute("joinUser") User joinUserBean, BindingResult result) {
        if(result.hasErrors()) {
            return "user/join";
        }

        userService.addUserInfo(joinUserBean);

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








