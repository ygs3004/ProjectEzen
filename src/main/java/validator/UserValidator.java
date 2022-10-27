package validator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.User;

public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        User userBean = (User)target;

        if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
            errors.rejectValue("user_pw", "NotEquals");
            errors.rejectValue("user_pw2", "NotEquals");
        }

        if(userBean.isUserIdExist() == false) {
            errors.rejectValue("user_id", "DontCheckUserIdExist");
        }
    }

}