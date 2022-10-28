package mapper;

import domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select user_id " +
            "from users " +
            "where user_id = #{user_id}")
    String checkUserIdExist(String user_id);

    @Select("select user_email " +
            "from users " +
            "where user_email = #{user_email}")
    String checkUserEmailExist(String user_email);

    @Insert("insert into users (user_role, user_name, user_id, user_pw, user_email, user_phone, user_gender, user_school ) " +
            "values (${user_role}, #{user_name}, #{user_id}, #{user_pw}, #{user_email}, #{user_phone}, #{user_gender}, #{user_school})")
    void addUserInfo(User joinUserBean);
}
