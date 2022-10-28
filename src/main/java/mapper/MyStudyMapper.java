package mapper;

import domain.HomeWork;
import domain.MentoRoom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MyStudyMapper {

    @Select("select * from mentoroom where name = #{user_id}")
    public MentoRoom getMyStudyRoom(String user_id);

    @Insert("insert into hwboard" +
            "(hwNo, hwName, hwContent, writer, hwRegDate, hwDeadLine) " +
            "values(hw_seq.nextval, #{hwName}, #{hwContent}, #{writer}, SYSDATE, #{hwDeadLine})")
    public void uploadHomeWork(HomeWork homeWork);

}
