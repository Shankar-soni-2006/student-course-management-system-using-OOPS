import java.util.*;
public class Instructor extends Person {
    private String department;
    private List<String> teachingCourses;
    
    public Instructor(String id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
        this.teachingCourses = new ArrayList<>();
    }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public List<String> getTeachingCourses() { return new ArrayList<>(teachingCourses); }
    
    public void assignCourse(String courseId) {
        if (!teachingCourses.contains(courseId)) {
            teachingCourses.add(courseId);
        }
    }
    
    public void removeCourse(String courseId) {
        teachingCourses.remove(courseId);
    }
    
    
    @Override
    public String getRole() {
        return "Instructor";
    }
    
    
    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Department: %s, Teaching: %d courses", 
                                             department, teachingCourses.size());
    }
}