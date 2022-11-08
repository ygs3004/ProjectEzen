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

    // mentorRoom 에 info db추가
    public void createRoom(MentorRoom roomInfo) {
        roomMapper.createRoom(roomInfo);

    }

    // num == 멘토룸 num
    public MentorRoom getMentorRoomInfo(int num){
        return roomMapper.getUserMentorRoom(num);
    }

    public int getRoomNoByID(String user_id){
        return roomMapper.getRoomNoByID(user_id);
    }
    // user_id로 MentorRoom No 찾기
    public int getAssignedRoomNo(String user_id){
        return userMapper.getAssignedRoomNo(user_id);
    }



}
