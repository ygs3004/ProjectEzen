package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import dao.UserDao;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean checkuserIdExist(String user_id) {

        String user_name = userDao.checkUserIdExist(user_id);

        if(user_name == null) {
            return true;
        } else {
            return false;
        }
    }

    public void addUserInfo(User joinUserBean) {
        userDao.addUserInfo(joinUserBean);
    }


    public boolean checkuserEmailExist(String user_email) {

        String user_name = userDao.checkUserEmailExist(user_email);

        if(user_name == null) {
            return true;
        } else {
            return false;
        }
    }


}











