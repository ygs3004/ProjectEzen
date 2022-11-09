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

    // User_id 넣으면 MentorRoomNo 나옴
    int getRoomNoByID(String user_id);
//
//    @Update("update users SET mentorRoomNo = #{num} where #{user_id}")
//    public int mentorRoomNoIntoUsers(int num);


}

