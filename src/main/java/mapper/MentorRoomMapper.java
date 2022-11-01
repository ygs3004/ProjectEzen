package mapper;

import domain.HomeWork;
import domain.MentorRoom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MentorRoomMapper {

    @Insert("INSERT INTO MentorRoom" +
            "(user_id, num, title," +
            "studyPeriod, studyWeekly, studyTimeStart, studyTimeEnd," +
            "capacity, nowCapacity, career, school, content) " +
            "values (#{user_id}, mentor_room_seq.nextval, #{title}, #{studyPeriod}, #{studyWeekly}, #{studytimestart}, #{studyTimeEnd}, #{capacity}, 0, #{career}, #{school}, #{content}")
    public int createRoom(MentorRoom roomInfo);

}
