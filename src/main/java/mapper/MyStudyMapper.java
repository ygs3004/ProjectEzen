package mapper;

import domain.HomeWork;
import domain.MentorRoom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface MyStudyMapper {

    public MentorRoom getMyStudyRoom(String user_id);

    public int uploadHomeWork(HomeWork homeWork);

    public HomeWork getHomeWork(String user_id);

    @Select("select sysdate from dual")
    public String getTime();
}
