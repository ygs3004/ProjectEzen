package mapper;

import domain.HomeWork;
import domain.HomeWorkInfo;
import domain.MentorRoom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MyStudyMapper {

    // 매퍼 테스트용
    @Select("select sysdate from dual")
    public String getTime();

    public MentorRoom getMyStudyRoom(String mentor_id);

    public int uploadHomeWorkInfo(HomeWorkInfo homeWorkInfo);

    public HomeWorkInfo getHomeWorkInfo(String mentor_id);

    public void homeWorkSubmit(HomeWork homeWork);

    public int checkHomeWork(String mentor_id);

    public List<HomeWork> getHomeWorkList(String user_id);

    public int modifyHwInfo(HomeWorkInfo hwInfo);

    public int deleteHwInfo(String writer);

    public HomeWork getHomeWork(String user_id);
}
