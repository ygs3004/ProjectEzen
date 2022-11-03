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

    // mentorRoom 에 info db추가
    public void createRoom(MentorRoom roomInfo) {
        roomMapper.createRoom(roomInfo);
    }

    // num == 멘토룸 num
    public MentorRoom getMentorRoomInfo(int num){
        return roomMapper.getUserMentorRoom(num);
    }

    // user_id로 MentorRoom Num 찾기
    public int getRoomNo(String user_id){
        return roomMapper.getRoomNo(user_id);
    }
}
