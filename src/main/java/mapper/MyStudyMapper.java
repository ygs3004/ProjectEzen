package mapper;

import domain.HomeWork;
import domain.HomeWorkInfo;
import domain.MentorRoom;
import org.apache.ibatis.annotations.Select;

public interface MyStudyMapper {

    public MentorRoom getMyStudyRoom(String mentor_id);

    public int uploadHomeWorkInfo(HomeWorkInfo homeWorkInfo);

    public HomeWorkInfo getHomeWork(String mentor_id);

    public void homeWorkSubmit(HomeWork homeWork);

    // 매퍼 테스트용
    @Select("select sysdate from dual")
    public String getTime();

}
