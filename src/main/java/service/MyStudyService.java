package service;

import dao.MentorRoomDAO;
import dao.MyStudyDao;
import dao.UserDao;
import domain.HomeWorkInfo;
import domain.MentorRoom;
import domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyStudyService {

    final MyStudyDao studyDao;
    final UserDao userDao;
    final MentorRoomDAO mentorRoomDAO;
    final UserService userService;

    public MentorRoom getMyStudyRoom(String user_id) {
        return studyDao.getMyStudyRoom(user_id);
    }

    public int uploadHomeWork(HomeWorkInfo homeWorkInfo) {
        return studyDao.uploadHomeWork(homeWorkInfo);
    }

    public HomeWorkInfo getHomeWork(String user_id) {

        String mentor_id = userService.getMentorId(user_id);

        return studyDao.getHomeWork(mentor_id);
    }


}
