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

    public MentorRoom getMyStudyRoom(String user_id) {
        return studyDao.getMyStudyRoom(user_id);
    }

    public int uploadHomeWork(HomeWorkInfo homeWorkInfo) {
        return studyDao.uploadHomeWork(homeWorkInfo);
    }

    public HomeWorkInfo getHomeWork(String user_id) {

        User user = userDao.getUserInfo(user_id);
        String mentor_id = "";

        // 접속해 있는 유저가 멘티라면
        if(user.getUser_role() == 2){
            int mentorRoomNo = user.getMentorRoomNo();
            mentor_id = mentorRoomDAO.getMentorRoomInfo(mentorRoomNo).getUser_id();
        }else{ // 멘티가 아니라면(멘토라면
            mentor_id = user_id;
        }

        return studyDao.getHomeWork(mentor_id);
    }
}
