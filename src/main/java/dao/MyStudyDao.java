package dao;

import domain.HomeWorkInfo;
import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import mapper.MyStudyMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MyStudyDao {

    final MyStudyMapper mapper;

    public MentorRoom getMyStudyRoom(String user_id){
        return mapper.getMyStudyRoom(user_id);
    }

    public int uploadHomeWork(HomeWorkInfo homeWorkInfo) {
        return mapper.uploadHomeWork(homeWorkInfo);
    }

    public HomeWorkInfo getHomeWork(String user_id) {
        return mapper.getHomeWork(user_id);
    }

}
