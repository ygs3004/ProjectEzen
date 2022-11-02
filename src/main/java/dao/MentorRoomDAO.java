package dao;

import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import mapper.MentorRoomMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MentorRoomDAO {

    final MentorRoomMapper mapper;

    public void createRoom(MentorRoom roomInfo) {
        mapper.createRoom(roomInfo);
    }

//    public MentorRoom mentorRoom(String user_id){
//        return mapper.getMyStudyRoom(user_id);
//    }

}
