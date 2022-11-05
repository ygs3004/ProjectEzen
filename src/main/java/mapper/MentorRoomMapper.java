package mapper;

import domain.MentorRoom;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MentorRoomMapper {

    int createRoom(MentorRoom mentorRoom);

    // RoomInfo by num
    MentorRoom getRoomInfoByNum(int num);

    // RoomInfo by user_id
    MentorRoom getRoomInfoByID(String user_id);

}