import java.util.*;


public class Student extends Person {
    private String major;
    private List<String> enrolledCourses;
    
    public Student(String id, String name, String email, String major) {
        super(id, name, email);
        this.major = major;
        this.enrolledCourses = new ArrayList<>();
    }
    
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    
    public List<String> getEnrolledCourses() { return new ArrayList<>(enrolledCourses); }
    
    public void enrollInCourse(String courseId) {
        if (!enrolledCourses.contains(courseId)) {
            enrolledCourses.add(courseId);
        }
    }
    
    public void dropCourse(String courseId) {
        enrolledCourses.remove(courseId);
    }
    
    
    @Override
    public String getRole() {
        return "Student";
    }
    
    
    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Major: %s, Courses: %d", 
                                             major, enrolledCourses.size());
    }
}