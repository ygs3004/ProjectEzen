package mapper;

import domain.HomeWorkInfo;
import domain.MentorRoom;
import org.apache.ibatis.annotations.Select;

public interface MyStudyMapper {

    public MentorRoom getMyStudyRoom(String user_id);

    public int uploadHomeWork(HomeWorkInfo homeWorkInfo);

    public HomeWorkInfo getHomeWork(String user_id);

    

    // 매퍼 테스트용
    @Select("select sysdate from dual")
    public String getTime();
}
