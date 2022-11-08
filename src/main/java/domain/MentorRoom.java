package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class MentorRoom {

    private int num;
    private String user_id;
    private String title;
    private String studyPeriod;
    private String studyWeekly;
    private String studyTimeStart;
    private String studyTimeEnd;
    private String capacity;
    private String nowCapacity;
    private String career;
    private String school;
    private String content;

    public void setStudyWeekly(String[] studyWeekly) {
        String weekly = String.join(", ", studyWeekly);
        System.out.println(weekly);
        this.studyWeekly = weekly;
    }

    public void setCareer(String[] career) {
        String careers = String.join(", ", career);
        System.out.println(careers);
        this.career = careers;
    }
}
