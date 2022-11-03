package service;

import dao.MentorRoomDAO;
import dao.UserDao;
import domain.MentorRoom;
import domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

@Service
@RequiredArgsConstructor
public class MentorRoomService {
    final UserDao userDAO;
    final MentorRoomDAO mentorRoomDAO;

//    // user 에서 userInfo 조회 (나중에 uerService로 옮기기..)
//    public User getUserInfo (@SessionAttribute("user_id") String user_id){
//        User userInfo = userDAO.getUserInfo(user_id);
//        return userInfo;
//    }

    // mentorroom 에 roomInfo 추가
    public void createRoom(MentorRoom roomInfo) {
        mentorRoomDAO.createRoom(roomInfo);
    }

    // users 에 roomNo 추가
    public void usersAddRoomNo(int num, String user_id){
        userDAO.usersAddRoomNo(num, user_id);
    }

    public int getRoomNo(String user_id){
        return mentorRoomDAO.getRoomNo(user_id);
    }

    // created Room 있는지 여부 확인 (있을 시 true / 없을 시 false)
    public boolean searchCreatedRoom(String user_id){
        if(!userDAO.getRoomNo(user_id)){

        }
    }



}
