import java.util.*;
public class Instructor extends Person {
    private String department;
    private List<String> teachingCourses;
    
    public Instructor(String id, String name, String email, String department) throws InvalidPersonDataException {
        super(id, name, email);
        if (department == null || department.trim().isEmpty()) {
            throw new InvalidPersonDataException("Exception: 👉Department cannot be null or empty");
        }
        this.department = department;
        this.teachingCourses = new ArrayList<>();
    }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) throws InvalidPersonDataException {
        if (department == null || department.trim().isEmpty()) {
            throw new InvalidPersonDataException("Exception: 👉Department cannot be null or empty");
        }
        this.department = department;
    }
    
    public List<String> getTeachingCourses() { return new ArrayList<>(teachingCourses); }
    
    public void assignCourse(String courseId) throws InvalidPersonDataException {
        if (courseId == null || courseId.trim().isEmpty()) {
            throw new InvalidPersonDataException("Exception: 👉Course ID cannot be null or empty");
        }
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
        return super.getInfo() + String.format(", Department: %s, Teaching: %s", 
                                             department, teachingCourses.toString());
    }
}