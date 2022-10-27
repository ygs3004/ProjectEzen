package mapper;

import domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select user_id " +
            "from user " +
            "where user_id = #{user_id}")
    String checkUserIdExist(String user_id);

    @Insert("insert into user (user_role, user_name, user_id, user_pw, user_email, user_phone, user_gender, user_school ) " +
            "values (${user_role}, #{user_name}, #{user_id}, #{user_pw}, #{user_email}, #{user_phone}, #{user_gender}, #{user_school})")
    void addUserInfo(User joinUserBean);
}
