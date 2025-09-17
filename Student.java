import java.util.*;


public class Student extends Person {
    private String major;
    private List<String> enrolledCourses;
    
    public Student(String id, String name, String email, String major) throws InvalidPersonDataException {
        super(id, name, email);
        if (major == null || major.trim().isEmpty()) {
            throw new InvalidPersonDataException("Exception: 👉Major cannot be null or empty");
        }
        this.major = major;
        this.enrolledCourses = new ArrayList<>();
    }
    
    public String getMajor() { return major; }
    public void setMajor(String major) throws InvalidPersonDataException {
        if (major == null || major.trim().isEmpty()) {
            throw new InvalidPersonDataException("Exception: 👉Major cannot be null or empty");
        }
        this.major = major;
    }
    
    public List<String> getEnrolledCourses() { return new ArrayList<>(enrolledCourses); }
    
    public void enrollInCourse(String courseId) throws InvalidPersonDataException {
        if (courseId == null || courseId.trim().isEmpty()) {
            throw new InvalidPersonDataException("Exception: 👉Course ID cannot be null or empty");
        }
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
        return super.getInfo() + String.format(", Major: %s, Courses: %s", 
                                             major, enrolledCourses.toString());
    }
}