import java.util.*;

public class Course {
    private String courseId;
    private String courseName;
    private String instructorId;
    private int credits;
    private int maxCapacity;
    private List<String> enrolledStudents;
    
    public Course(String courseId, String courseName, int credits, int maxCapacity) throws InvalidPersonDataException {
        if (courseId == null || courseId.trim().isEmpty()) {
            throw new InvalidPersonDataException("Course ID cannot be null or empty");
        }
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new InvalidPersonDataException("Course name cannot be null or empty");
        }
        if (credits <= 0) {
            throw new InvalidPersonDataException("Credits must be positive");
        }
        if (maxCapacity <= 0) {
            throw new InvalidPersonDataException("Max capacity must be positive");
        }
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
    
    public void setCourseName(String courseName) throws InvalidPersonDataException {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new InvalidPersonDataException("Course name cannot be null or empty");
        }
        this.courseName = courseName;
    }
    
    public void setInstructorId(String instructorId) throws InvalidPersonDataException {
        if (instructorId == null || instructorId.trim().isEmpty()) {
            throw new InvalidPersonDataException("Instructor ID cannot be null or empty");
        }
        this.instructorId = instructorId;
    }
    
    public void setCredits(int credits) throws InvalidPersonDataException {
        if (credits <= 0) {
            throw new InvalidPersonDataException("Credits must be positive");
        }
        this.credits = credits;
    }
    
    public List<String> getEnrolledStudents() { return new ArrayList<>(enrolledStudents); }
    
    public boolean addStudent(String studentId) throws CourseCapacityException, InvalidPersonDataException {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new InvalidPersonDataException("Student ID cannot be null or empty");
        }
        if (enrolledStudents.size() >= maxCapacity) {
            throw new CourseCapacityException("Course is at maximum capacity");
        }
        if (!enrolledStudents.contains(studentId)) {
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
        return String.format("Course["ID: %s" + "\n" + "Name: %s" + "\n" + "Credits: %d" + "\n" + "Enrolled: %s" + "\n" + "Capacity: %d/%d"  + "\n" + "Instructor: %s]",
                           courseId, courseName, credits, enrolledStudents.toString(), enrolledStudents.size(), maxCapacity,
                           instructorId != null ? instructorId : "TBA");
    }
}
