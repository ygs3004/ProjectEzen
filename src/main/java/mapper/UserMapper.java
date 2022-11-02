package mapper;

import domain.MentorRoom;
import domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("select user_id " +
            "from users " +
            "where user_id = #{user_id}")
    String checkUserIdExist(String user_id);

    @Select("select user_email " +
            "from users " +
            "where user_email = #{user_email}")
    String checkUserEmailExist(String user_email);

    @Select("select user_idx, user_name " +
            "from users " +
            "where user_id=#{user_id} and user_pw=#{user_pw}")
    User getLoginUserInfo(User tempLoginUserBean);

//    @Select("select user_name " +
//            "from users " +
//            "where user_id=#{user_id} and user_pw=#{user_pw}")
//    User getLoginUserInfo(User tempLoginUserBean);
    @Select("select user_id, user_name " +
        "from user_table " +
        "where user_idx = #{user_idx}")
    User getModifyUserInfo(int user_idx);

    @Update("update user_table " +
            "set user_pw = #{user_pw} " +
            "where user_idx = #{user_idx}")
    void modifyUserInfo(User modifyUserBean);

    @Insert("insert into users (user_idx, user_role, user_name, user_id, user_pw, user_pw2, user_email, user_phone, user_gender, user_school) " +"values (user_seq.nextval, #{user_role}, #{user_name}, #{user_id}, #{user_pw}, #{user_pw2}, #{user_email}, #{user_phone}, #{user_gender}, #{user_school})")
    void addUserInfo(User joinUserBean);

    @Select("select * from users where user_id = #{user_id}")
    User getUserInfo(String user_id);

    // 매퍼 테스트용
    @Select("select sysdate from dual")
    public String getTime();

}
