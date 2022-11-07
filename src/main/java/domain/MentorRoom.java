package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MentorRoom {

    private Integer num;
    private String user_id;
    private String title;
    private String studyPeriod;
    private String studyWeekly;
    private String studyTimeStart;
    private String studyTimeEnd;
    private Integer capacity;
    private Integer nowCapacity;
    private String career;
    private String school;
    private String content;

    public void setStudyWeekly(String[] studyWeekly) {
        String weekly = String.join(",", studyWeekly);
        this.studyWeekly = weekly;
    }

    public void setCareer(String[] career) {
        String careers = String.join(",", career);
        this.career = careers;
    }


}
