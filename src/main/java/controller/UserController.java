package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import lombok.extern.log4j.Log4j;
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
@Log4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource(name = "loginUserBean")
    private User loginUserBean;

    // 로그인하기
    @GetMapping("/login")
    public String login(@ModelAttribute("tempLoginUserBean") User tempLoginUserBean,
                        @RequestParam(value = "fail", defaultValue = "false") boolean fail,
                        Model model) {

        model.addAttribute("fail", fail);

        return "user/login";
    }

    @PostMapping("/login_pro")
    public String login_pro(@Valid @ModelAttribute("tempLoginUserBean") User tempLoginUser, BindingResult result) {
        log.info(tempLoginUser.toString());
        System.out.println("controller : "+tempLoginUser.getUser_id());
        System.out.println("controller : "+tempLoginUser.getUser_pw());
        System.out.println(result.getAllErrors().toString());

        if(result.hasErrors()) {
            return "user/login";

        }
        userService.getLoginUserInfo(tempLoginUser);

        if(loginUserBean.isUserLogin() == true) {
            log.info("로그인에 성공하셨습니다 : "+loginUserBean);
            return "user/login_success";
        } else {
            return "user/login_fail";
        }
    }

    // 가입하기
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
    // 정보수정
    @GetMapping("/modify")
    public String modify(@ModelAttribute("modifyUserBean") User modifyUserBean) {

        userService.getModifyUserInfo(modifyUserBean);
        return "user/modify";
    }
    @PostMapping("/modify_pro")
    public String modify_pro(@Valid @ModelAttribute("modifyUserBean") User modifyUserBean, BindingResult result) {

        if(result.hasErrors()) {
            return "user/modify";
        }
        userService.modifyUserInfo(modifyUserBean);
        return "user/modify_success";
    }
    //로그아웃
    @GetMapping("/logout")
    public String logout() {
        loginUserBean.setUserLogin(false);
        return "user/logout";
    }
    // 로그인안했을경우
    @GetMapping("/not_login")
    public String not_login() {
        return "user/not_login";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        UserValidator validator1 = new UserValidator();
        binder.addValidators(validator1);
    }
}








