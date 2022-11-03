package domain;

import lombok.Data;

import java.sql.Date;

@Data
public class HomeWork {

    private String mentorId; //  HomeWork를 내준 멘토 이름
    private String userId; // HomeWork 제출자
    private String content; // 내용
    private String filename; // 제출 파일 이름
    private Date hwRegDate; // 제출일

}
