import java.util.*;

public class StudentCourseManagementSystem {
    private Map<String, Person> people;
    private Map<String, Course> courses;
    private Scanner scanner;
    
    public StudentCourseManagementSystem() {
        this.people = new HashMap<>();
        this.courses = new HashMap<>();
        this.scanner = new Scanner(System.in);
        initializeData();
    }
    
    private void initializeData() {
    }
    
    public void addStudent(String id, String name, String email, String major) {
        people.put(id, new Student(id, name, email, major));
    }
    
    public void addInstructor(String id, String name, String email, String department) {
        people.put(id, new Instructor(id, name, email, department));
    }
    
    public void addCourse(String courseId, String courseName, int credits, int maxCapacity) {
        courses.put(courseId, new Course(courseId, courseName, credits, maxCapacity));
    }
    
    public boolean enrollStudentInCourse(String studentId, String courseId) {
        Person person = people.get(studentId);
        Course course = courses.get(courseId);
        
        if (person instanceof Student && course != null) {
            Student student = (Student) person;
            if (course.addStudent(studentId)) {
                student.enrollInCourse(courseId);
                return true;
            }
        }
        return false;
    }
    
    public boolean assignInstructorToCourse(String courseId, String instructorId) {
        Person person = people.get(instructorId);
        Course course = courses.get(courseId);
        
        if (person instanceof Instructor && course != null) {
            Instructor instructor = (Instructor) person;
            course.setInstructorId(instructorId);
            instructor.assignCourse(courseId);
            return true;
        }
        return false;
    }
    
    public void displayPersonInfo(String personId) {
        Person person = people.get(personId);
        if (person != null) {
            System.out.println(person.getInfo());
        }
    }
    
    public void displayAllPeople() {
        System.out.println("\n=== All People ===");
        for (Person person : people.values()) {
            System.out.println(person.getInfo());
        }
    }
    
    public void displayAllCourses() {
        System.out.println("\n=== All Courses ===");
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }
    
    public void run() {
        System.out.println("=== Student Course Management System ===");
        
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Instructor");
            System.out.println("3. Add Course");
            System.out.println("4. Display All People");
            System.out.println("5. Display All Courses");
            System.out.println("6. Enroll Student in Course");
            System.out.println("7. Assign Instructor to Course");
            System.out.println("8. Display Person Info");
            System.out.println("9. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addStudentMenu();
                    break;
                case 2:
                    addInstructorMenu();
                    break;
                case 3:
                    addCourseMenu();
                    break;
                case 4:
                    displayAllPeople();
                    break;
                case 5:
                    displayAllCourses();
                    break;
                case 6:
                    enrollStudentMenu();
                    break;
                case 7:
                    assignInstructorMenu();
                    break;
                case 8:
                    displayPersonMenu();
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    
    private void addStudentMenu() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Major: ");
        String major = scanner.nextLine();
        
        addStudent(id, name, email, major);
        System.out.println("Student added successfully!");
    }
    
    private void addInstructorMenu() {
        System.out.print("Enter Instructor ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        
        addInstructor(id, name, email, department);
        System.out.println("Instructor added successfully!");
    }
    
    private void addCourseMenu() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter Credits: ");
        int credits = scanner.nextInt();
        System.out.print("Enter Max Capacity: ");
        int maxCapacity = scanner.nextInt();
        scanner.nextLine();
        
        addCourse(courseId, courseName, credits, maxCapacity);
        System.out.println("Course added successfully!");
    }
    
    private void enrollStudentMenu() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        
        if (enrollStudentInCourse(studentId, courseId)) {
            System.out.println("Enrollment successful!");
        } else {
            System.out.println("Enrollment failed!");
        }
    }
    
    private void assignInstructorMenu() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter Instructor ID: ");
        String instructorId = scanner.nextLine();
        
        if (assignInstructorToCourse(courseId, instructorId)) {
            System.out.println("Instructor assigned successfully!");
        } else {
            System.out.println("Assignment failed!");
        }
    }
    
    private void displayPersonMenu() {
        System.out.print("Enter Person ID: ");
        String personId = scanner.nextLine();
        displayPersonInfo(personId);
    }
    
    public static void main(String[] args) {
        new StudentCourseManagementSystem().run();
    }
}