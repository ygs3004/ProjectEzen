package service;
import dao.MentorRoomDAO;
import dao.UserDao;
import domain.MentorRoom;
import domain.User;
import lombok.RequiredArgsConstructor;
import mapper.MentorRoomMapper;
import mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;

@Service
@RequiredArgsConstructor
public class MentorRoomService {

    final UserDao userDAO;
    final MentorRoomDAO mentorRoomDAO;
    final UserMapper userMapper;
    final MentorRoomMapper roomMapper;

//    // user 에서 userInfo 조회 (나중에 uerService로 옮기기..)
//    public User getUserInfo (@SessionAttribute("user_id") String user_id){
//        User userInfo = userDAO.getUserInfo(user_id);
//        return userInfo;
//    }

    // GET userInfo BY user_id
    public User getUserByID(String user_id){
        return userDAO.getUserInfo(user_id);
    }

    // GET roomInfo BY user_id
    public MentorRoom getRoomInfoByID(String user_id){
        return roomMapper.getRoomInfoByID(user_id);
    }

    // ADD roomInfo
    public void createRoom(MentorRoom roomInfo, String user_id) {
        roomMapper.createRoom(roomInfo);
        int roomNo = getRoomNoByID(user_id); //id로 만들어진 roomNum 조회
        usersAddRoomNo(roomNo, user_id);
    }

    // ADD RoomNum TO users BY user_id
    public void usersAddRoomNo(int mentorRoomNo, String user_id){
        userMapper.updateRoomNo(mentorRoomNo, user_id);
    }

    // CHECK RoomNum BY user_id
    public int getRoomNoByID(String user_id){
        int roomNum = roomMapper.getRoomInfoByID(user_id).getNum();
        return roomNum;
    }

    //CHECK RoomNum BY user_id
    public boolean getAssignedRoomNo(String user_id){
        if(roomMapper.getRoomInfoByID(user_id) == null){
            return false;
        } else{
            return true;
        }
    }

}
