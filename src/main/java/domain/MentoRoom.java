package domain;

public class MentoRoom {

    private String user_id;
    private String title;
    private String name;
    private String career;
    private String school;
    private String capacity;
    private String StudyStart;
    private String StudyEnd;
    private String content;

    public MentoRoom(String user_id, String title, String name, String career, String school, String capacity, String studyStart, String studyEnd, String content) {
        this.user_id = user_id;
        this.title = title;
        this.name = name;
        this.career = career;
        this.school = school;
        this.capacity = capacity;
        StudyStart = studyStart;
        StudyEnd = studyEnd;
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

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStudyStart() {
        return StudyStart;
    }

    public void setStudyStart(String studyStart) {
        StudyStart = studyStart;
    }

    public String getStudyEnd() {
        return StudyEnd;
    }

    public void setStudyEnd(String studyEnd) {
        StudyEnd = studyEnd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
