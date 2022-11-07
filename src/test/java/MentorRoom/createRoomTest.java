package MentorRoom;

import config.ServletAppContext;
import dao.MentorRoomDAO;
import dao.UserDao;
import lombok.extern.log4j.Log4j;
import mapper.MentorRoomMapper;
import mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import service.MentorRoomService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServletAppContext.class})
@WebAppConfiguration
@Log4j
public class createRoomTest {

    String user_id ="mentoer_id";
    @Autowired
    MentorRoomDAO roomDAO;
    @Autowired
    UserDao userDao;
    @Autowired
    MentorRoomMapper roomMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    MentorRoomService mentorRoomService;


    @Test
    public void daoGetAssignedRoomNo(){
        userMapper.getUserInfo(user_id).getMentorRoomNo();
    }

}
