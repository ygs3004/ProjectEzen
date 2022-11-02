package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.User;
import mapper.UserMapper;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public String checkUserIdExist(String user_id) {
        return userMapper.checkUserIdExist(user_id);
    }

    public String checkUserEmailExist(String user_email) {

        return userMapper.checkUserEmailExist(user_email);
    }

    public void addUserInfo(User joinUser) {
        userMapper.addUserInfo(joinUser);
    }
    public User getLoginUserInfo(User tempLoginUserBean) {
        return userMapper.getLoginUserInfo(tempLoginUserBean);
    }
    public User getModifyUserInfo(int user_idx) {
        return userMapper.getModifyUserInfo(user_idx);
    }

    public void modifyUserInfo(User modifyUserBean) {
        userMapper.modifyUserInfo(modifyUserBean);
    }
//    public User getLoginUserInfo(User tempLoginUser) {
//        return userMapper.getLoginUserInfo(tempLoginUser);
//    }

    public User getUserInfo(String user_id){

        return userMapper.getUserInfo(user_id);
    }

}
