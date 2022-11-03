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

    // mentorRoom 에서 user_id 로 No 존재하는지 확인
    public int getRoomNoByID(String user_id){
        return mentorRoomDAO.getRoomNoByID(user_id);
    }

    // users 에서 user_id 로 소속된 MentorRoomNo 존재하는지 확인.
    public boolean getAssignedRoomNo(String user_id){
        if(mentorRoomDAO.getAssignedRoomNo(user_id)>=1){
            return true; //있음
        }else{
            return false; //없음
        }
    }





}
