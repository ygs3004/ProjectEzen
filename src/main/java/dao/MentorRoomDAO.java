package dao;

import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import mapper.MentorRoomMapper;
import mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MentorRoomDAO {

    final MentorRoomMapper mapper;

    public void createRoom(MentorRoom roomInfo) {
        mapper.createRoom(roomInfo);
    }

    // num == 멘토룸 num
    public MentorRoom getMentorRoomInfo(int num){
        return mapper.getUserMentorRoom(num);
    }

}
