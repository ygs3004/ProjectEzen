package dao;

import domain.HomeWork;
import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import mapper.MyStudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyStudyDao {

    @Autowired
    MyStudyMapper mapper;

    public MentorRoom getMyStudyRoom(String user_id){
        return mapper.getMyStudyRoom(user_id);
    }

    public int uploadHomeWork(HomeWork homeWork) {
        return mapper.uploadHomeWork(homeWork);
    }

    public HomeWork getHomeWork(String user_id) {
        return mapper.getHomeWork(user_id);
    }

}
