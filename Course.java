import java.util.*;

public class Course {
    private String courseId;
    private String courseName;
    private String instructorId;
    private int credits;
    private int maxCapacity;
    private List<String> enrolledStudents;
    
    public Course(String courseId, String courseName, int credits, int maxCapacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }
    
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getInstructorId() { return instructorId; }
    public int getCredits() { return credits; }
    public int getMaxCapacity() { return maxCapacity; }
    public int getCurrentEnrollment() { return enrolledStudents.size(); }
    
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setInstructorId(String instructorId) { this.instructorId = instructorId; }
    public void setCredits(int credits) { this.credits = credits; }
    
    public List<String> getEnrolledStudents() { return new ArrayList<>(enrolledStudents); }
    
    public boolean addStudent(String studentId) {
        if (enrolledStudents.size() < maxCapacity && !enrolledStudents.contains(studentId)) {
            enrolledStudents.add(studentId);
            return true;
        }
        return false;
    }
    
    public boolean removeStudent(String studentId) {
        return enrolledStudents.remove(studentId);
    }
    
    public boolean isFull() {
        return enrolledStudents.size() >= maxCapacity;
    }
    
    @Override
    public String toString() {
        return String.format("Course[ID: %s, Name: %s, Credits: %d, Enrolled: %d/%d, Instructor: %s]",
                           courseId, courseName, credits, enrolledStudents.size(), maxCapacity,
                           instructorId != null ? instructorId : "TBA");
    }
}