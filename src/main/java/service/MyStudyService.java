package service;

import dao.MyStudyDao;
import domain.HomeWork;
import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyStudyService {

    MyStudyDao studyDao;

    public MentorRoom getMyStudyRoom(String user_id) {
        return studyDao.myStudyMenor(user_id);
    }

    public int uploadHomeWork(HomeWork homeWork) {
        return studyDao.uploadHomeWork(homeWork);
    }

    public HomeWork getHomeWork(String user_id) {
        return studyDao.getHomeWork(user_id);
    }
}
