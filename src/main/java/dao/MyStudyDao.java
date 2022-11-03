package dao;

import domain.HomeWork;
import domain.HomeWorkInfo;
import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import mapper.MyStudyMapper;
import org.springframework.stereotype.Repository;

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
}
