package service;

import dao.MentorRoomDAO;
import domain.MentorRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MentorRoomService {

    final MentorRoomDAO mentorRoomDAO;

    public void createRoom(MentorRoom roomInfo) {
        mentorRoomDAO.createRoom(roomInfo);
    }
}
