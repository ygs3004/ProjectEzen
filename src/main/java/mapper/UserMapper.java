package mapper;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select user_name " +
            "from user " +
            "where user_id = #{user_id}")
    String checkUserIdExist(String user_id);
}
