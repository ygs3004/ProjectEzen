package mapper;

import domain.MentoRoom;
import org.apache.ibatis.annotations.Select;

public interface MyStudyMapper {

    @Select("select * from mentoroom where name = #{user_id}")
    public MentoRoom getMyStudyRoom(String user_id);

}
