package dao;

import domain.HomeWork;
import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import mapper.MyStudyMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MyStudyDao {

    MyStudyMapper mapper;

    public MentorRoom myStudyMenor(String user_id){
        return mapper.getMyStudyRoom(user_id);
    }

    public int uploadHomeWork(HomeWork homeWork) {
        return mapper.uploadHomeWork(homeWork);
    }

    public HomeWork getHomeWork(String user_id) {
        return mapper.getHomeWork(user_id);
    }

}
