package domain;

public class MentorRoom {

    private String user_id;
    private String title;
    private String name;
    private String studyPeriod;
    private String[] studyWeekly;
    private String studyTimeStart;
    private String studyTimeEnd;
    private String capacity;
    private String nowCapacity;
    private String[] career;
    private String school;
    private String content;

    public MentorRoom() {
    }

    public MentorRoom(String user_id, String title, String name, String studyPeriod, String[] studyWeekly, String studyTimeStart, String studyTimeEnd, String capacity, String nowCapacity, String[] career, String school, String content) {
        this.user_id = user_id;
        this.title = title;
        this.name = name;
        this.studyPeriod = studyPeriod;
        this.studyWeekly = studyWeekly;
        this.studyTimeStart = studyTimeStart;
        this.studyTimeEnd = studyTimeEnd;
        this.capacity = capacity;
        this.nowCapacity = nowCapacity;
        this.career = career;
        this.school = school;
        this.content = content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudyPeriod() {
        return studyPeriod;
    }

    public void setStudyPeriod(String studyPeriod) {
        this.studyPeriod = studyPeriod;
    }

    public String[] getStudyWeekly() {
        return studyWeekly;
    }

    public void setStudyWeekly(String[] studyWeekly) {
        this.studyWeekly = studyWeekly;
    }

    public String getStudyTimeStart() {
        return studyTimeStart;
    }

    public void setStudyTimeStart(String studyTimeStart) {
        this.studyTimeStart = studyTimeStart;
    }

    public String getStudyTimeEnd() {
        return studyTimeEnd;
    }

    public void setStudyTimeEnd(String studyTimeEnd) {
        this.studyTimeEnd = studyTimeEnd;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getNowCapacity() {
        return nowCapacity;
    }

    public void setNowCapacity(String nowCapacity) {
        this.nowCapacity = nowCapacity;
    }

    public String[] getCareer() {
        return career;
    }

    public void setCareer(String[] career) {
        this.career = career;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
