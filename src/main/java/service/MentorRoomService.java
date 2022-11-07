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

    // GET userInfo BY user_id
    public User getUserByID(String user_id){
        return userDAO.getUserInfo(user_id);
    }

    // ADD roomInfo BY roominfo
    public int createRoom(MentorRoom roomInfo) {
        return mentorRoomDAO.createRoom(roomInfo);
    }

    // ADD RoomNum BY user_id
    public void usersAddRoomNo(int num, String user_id){
        userDAO.usersAddRoomNo(num, user_id);
    }

    // CHECK RoomNum BY user_id
    public int getRoomNoByID(String user_id){
        return mentorRoomDAO.getRoomInfoByID(user_id).getNum();
    }

    //CHECK RoomNum BY user_id
    public boolean getAssignedRoomNo(String user_id){
        if(mentorRoomDAO.getAssignedRoomNo(user_id)>=1){
            return true; // 멘토룸 있음
        }else{
            return false; // 멘토룸 없음
        }
    }
}
