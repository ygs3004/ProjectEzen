package service;

import javax.annotation.Resource;

import dao.MentorRoomDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import dao.UserDao;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    final UserDao userDao;

    final MentorRoomDAO mentorRoomDAO;


    @Resource(name = "loginUserBean")
    private User loginUserBean;



    public boolean checkuserIdExist(String user_id) {

        String user_name = userDao.checkUserIdExist(user_id);

        if(user_name == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkuserEmailExist(String user_email) {
        System.out.println(user_email);
        String user_emailCheck = userDao.checkUserEmailExist(user_email);
        
        if(user_emailCheck == null) {
            return true;
        } else {
            return false;
        }
    }

    public void addUserInfo(User joinUserBean) {
        userDao.addUserInfo(joinUserBean);
    }

    public void getLoginUserInfo(User tempLoginUserBean) {
        System.out.println("service : "+tempLoginUserBean.getUser_id());
        System.out.println("service : "+tempLoginUserBean.getUser_pw());

        User tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);

        if(tempLoginUserBean2 != null) {
            loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
            loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
            loginUserBean.setUser_id(tempLoginUserBean2.getUser_id());
            loginUserBean.setUser_role(tempLoginUserBean2.getUser_role());
            loginUserBean.setUserLogin(true);
        }
    }


    public void getModifyUserInfo(User modifyUserBean) {
        User tempModifyUserBean = userDao.getModifyUserInfo(loginUserBean.getUser_idx());

        modifyUserBean.setUser_id(tempModifyUserBean.getUser_id());
        modifyUserBean.setUser_name(tempModifyUserBean.getUser_name());
        modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
    }

    public void modifyUserInfo(User modifyUserBean) {


        modifyUserBean.setUser_idx(loginUserBean.getUser_idx());

        userDao.modifyUserInfo(modifyUserBean);
    }
    /**
     *  user_id를 넣엇을때 mentee의 아이디면 mentor id를 알려주는 method
    */


}











