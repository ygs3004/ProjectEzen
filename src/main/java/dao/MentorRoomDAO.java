package dao;

import domain.MentorRoom;
import domain.User;
import lombok.RequiredArgsConstructor;
import mapper.MentorRoomMapper;
import mapper.UserMapper;
import org.springframework.stereotype.Repository;

// DAO(Data Access Object) : Repository를 활용하는 곳
@Repository
@RequiredArgsConstructor
public class MentorRoomDAO {

    final MentorRoomMapper roomMapper;
    final UserMapper userMapper;

    // ADD info TO mentorRoom
    public int createRoom(MentorRoom mentorRoom) {
        return roomMapper.createRoom(mentorRoom);
    }

    public MentorRoom getRoomInfoByID(String user_id){
        return roomMapper.getRoomInfoByID(user_id);
    }

    // users 에서 user_id로 RoomNo받아오기
    public int getAssignedRoomNo(String user_id){
        return userMapper.getUserInfo(user_id).getMentorRoomNo();
    }


}
