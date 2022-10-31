package mapper;

import domain.HomeWork;
import domain.MentoRoom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MyStudyMapper {

    @Select("select * from mentoroom where name = #{user_id}")
    public MentoRoom getMyStudyRoom(String user_id);

    @Insert("insert into hwboard" +
            "(hwName, hwContent, writer, hwRegDate, hwDeadLine, CompleteMentee) " +
            "values(#{hwName}, #{hwContent}, #{writer}, SYSDATE, #{hwDeadLine}, 0)")
    public int uploadHomeWork(HomeWork homeWork);

    @Select("select * from hwboard where writer = #{user_id}")
    public HomeWork getHomeWork(String user_id);

}
