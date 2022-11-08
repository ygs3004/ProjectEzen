package dao;

import domain.HomeWork;
import domain.HomeWorkInfo;
import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import service.mapper.MyStudyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyStudyDao {

    final MyStudyMapper mapper;

    public MentorRoom getMyStudyRoom(String mentor_id){
        return mapper.getMyStudyRoom(mentor_id);
    }

    public int uploadHomeWorkInfo(HomeWorkInfo homeWorkInfo) {
        return mapper.uploadHomeWorkInfo(homeWorkInfo);
    }

    public HomeWorkInfo getHomeWork(String mentor_id) {
        return mapper.getHomeWork(mentor_id);
    }

    public void homeWorkSubmit(HomeWork homeWork) {
        mapper.homeWorkSubmit(homeWork);
    }

    public int checkHomeWork(String mentor_id) {
        return mapper.checkHomeWork(mentor_id); // count HomeWorkInfo table
    }

    public List<HomeWork> getHomeWorkList(String user_id) {
        return mapper.getHomeWorkList(user_id);
    }
}
