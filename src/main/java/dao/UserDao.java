package dao;

import mapper.MentorRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.User;
import mapper.UserMapper;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MentorRoomMapper mentorRoomMapper;

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


    public User getUserInfo(String user_id){
        return userMapper.getUserInfo(user_id);
    }

    public int usersAddRoomNo(int num, String user_id){
        return userMapper.updateRoomNo(num,user_id);
    }

    public String getMentorId(String user_id){

        User user = getUserInfo(user_id);
        String mentor_id = "";

        // 접속해 있는 유저가 멘티라면
        if(user.getUser_role() == 2){
            int mentorRoomNo = user.getMentorRoomNo();
            mentor_id = mentorRoomMapper.getUserMentorRoom(mentorRoomNo).getUser_id();
        }else{ // 멘티가 아니라면(멘토라면
            mentor_id = user_id;
        }
        return mentor_id;
    }

}
