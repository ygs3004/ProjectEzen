package service;

import dao.MyStudyDao;
import domain.HomeWorkInfo;
import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyStudyService {

    final MyStudyDao studyDao;

    public MentorRoom getMyStudyRoom(String user_id) {
        return studyDao.getMyStudyRoom(user_id);
    }

    public int uploadHomeWork(HomeWorkInfo homeWorkInfo) {
        return studyDao.uploadHomeWork(homeWorkInfo);
    }

    public HomeWorkInfo getHomeWork(String user_id) {

        return studyDao.getHomeWork(user_id);
    }
}
