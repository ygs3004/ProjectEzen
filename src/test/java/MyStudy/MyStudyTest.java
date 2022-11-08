package MyStudy;

import config.ServletAppContext;
import dao.MyStudyDao;
import dao.UserDao;
import domain.MentorRoom;
import lombok.extern.log4j.Log4j;
import mapper.BoardMapper;
import mapper.MyStudyMapper;
import mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServletAppContext.class})
@WebAppConfiguration
@Log4j
public class MyStudyTest {

    @Autowired
    MyStudyDao dao;

    @Autowired
    UserDao userDao;

    @Autowired
    MyStudyMapper mapper;
    @Autowired
    UserMapper userMapper;

    @Autowired
    BoardMapper boardMapper;

    @Test
    public void daoAutowired(){
        assertThat(dao, is(notNullValue()));
        assertThat(userDao, is(notNullValue()));
        assertThat(boardMapper, is(notNullValue()));
    }

    @Test
    public void test(){
        log.info(mapper);
        log.info(mapper.getTime());
        log.info(userMapper.getTime());
        log.info(userMapper.getUserInfo("JEJA"));
    }

    @Test
    public void select_test(){
        String user_id = "김멘토";
        log.info(mapper);
        MentorRoom mentorRoom = mapper.getMyStudyRoom(user_id);
        assertThat(user_id, is(mentorRoom.getUser_id()));
    }

}
