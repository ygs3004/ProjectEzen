package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import domain.User;

public class CheckLoginInterceptor implements HandlerInterceptor{

    private User loginUserBean;

    public CheckLoginInterceptor(User loginUserBean) {
        // TODO Auto-generated constructor stub
        this.loginUserBean = loginUserBean;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
        if(loginUserBean.isUserLogin() == false) {
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/user/not_login");
            return false;
        }
        return true;
    }
}








