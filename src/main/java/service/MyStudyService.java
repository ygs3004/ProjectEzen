package service;

import dao.MentorRoomDAO;
import dao.MyStudyDao;
import dao.UserDao;
import domain.HomeWorkInfo;
import domain.MentorRoom;
import domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j
public class MyStudyService {

    final UserService userService;
    final UserDao userDao;
    final MyStudyDao studyDao;
    final MentorRoomDAO mentorRoomDAO;

    public MentorRoom getMyStudyRoom(String user_id) {

        String mentor_id = userService.getMentorId(user_id);

        return studyDao.getMyStudyRoom(mentor_id);
    }

    public int uploadHomeWork(HomeWorkInfo homeWorkInfo) {
        return studyDao.uploadHomeWork(homeWorkInfo);
    }

    public HomeWorkInfo getHomeWork(String user_id) {

        String mentor_id = userService.getMentorId(user_id);

        return studyDao.getHomeWork(mentor_id);
    }


}
