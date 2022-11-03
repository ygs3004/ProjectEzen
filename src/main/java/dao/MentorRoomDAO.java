package dao;

import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import mapper.MentorRoomMapper;
import mapper.UserMapper;
import org.springframework.stereotype.Repository;

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

    public MentorRoom getUserMentorRoomByID(String user_id){
        return roomMapper.getUserMentorRoomByID(user_id);
    }
    // user_id로 MentorRoom No 찾기
    public int getAssignedRoomNo(String user_id){
        return userMapper.getAssignedRoomNo(user_id);
    }


}
