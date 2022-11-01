package mapper;

import domain.HomeWork;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MentorRoom {


//    @Select("select * from mentoroom where name = #{user_id}")
//    public domain.MentorRoom getMyStudyRoom(String user_id);

    @Insert("insert into mentorroom" +
            "(user_id, num, title, " +
            "studyPeriod, studyWeekly, studyTimeStart, studyTimeEnd," +
            "capacity, nowCapacity, career, school, content ) " +
            "values(#{user_id}, mento_room_seq.nextval, #{title}," +
            "#{studyPeriod}, #{studyWeekly}, #{studyTimeStart}, #{studyTimeEnd}" +
            "#{capacity}, 0, #{career}, #{school}, #{content})")
    public int createRoom(MentorRoom roomInfo);

//    @Select("select * from hwInfo where writer = #{user_id}")
//    public HomeWork getHomeWork(String user_id);

    @Select("select * from mentorroom where name = #{user_id}")
    public domain.MentorRoom getMyStudyRoom(String user_id);

    @Insert("insert into mentorroom" +
            "() " +
            "values(#{hwName}, #{hwContent}, #{writer}, SYSDATE, #{hwDeadLine}, 0)")
    public int uploadHomeWork(HomeWork homeWork);

    @Select("select * from hwboard where writer = #{user_id}")
    public HomeWork getHomeWork(String user_id);


}
