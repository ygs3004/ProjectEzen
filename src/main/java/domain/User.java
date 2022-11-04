package domain;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.*;

@Getter
@Setter
public class User {

    private int user_idx;
    private int mentorRoomNo;
    private int user_role;

    @Size(min=2, max=4)
    @Pattern(regexp = "[가-힣]*")
    private String user_name;
    @Size(min=4, max=20)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_id;
    @Size(min=4, max=20)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw;
    @Size(min=4, max=20)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw2;

    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String user_email;

    private String user_phone;
    private String user_gender;
    private String user_school;

    private boolean userIdExist;

    private boolean userLogin;

    private boolean userEmailExist;

}
