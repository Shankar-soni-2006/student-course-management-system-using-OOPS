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
    
    public void addStudent(String id, String name, String email, String major) throws InvalidPersonDataException {
        if (people.containsKey(id)) {
            throw new InvalidPersonDataException("Student ID already exists: " + id);
        }
        try {
            people.put(id, new Student(id, name, email, major));
        } catch (InvalidPersonDataException e) {
            throw e;
        }
    }
    
    public void addInstructor(String id, String name, String email, String department) throws InvalidPersonDataException {
        if (people.containsKey(id)) {
            throw new InvalidPersonDataException("Instructor ID already exists: " + id);
        }
        try {
            people.put(id, new Instructor(id, name, email, department));
        } catch (InvalidPersonDataException e) {
            throw e;
        }
    }
    
    public void addCourse(String courseId, String courseName, int credits, int maxCapacity) throws InvalidPersonDataException {
        if (courses.containsKey(courseId)) {
            throw new InvalidPersonDataException("Course ID already exists: " + courseId);
        }
        try {
            courses.put(courseId, new Course(courseId, courseName, credits, maxCapacity));
        } catch (InvalidPersonDataException e) {
            throw e;
        }
    }
    
    public boolean enrollStudentInCourse(String studentId, String courseId) throws PersonNotFoundException, CourseNotFoundException, CourseCapacityException, InvalidPersonDataException {
        Person person = people.get(studentId);
        Course course = courses.get(courseId);
        
        if (person == null) {
            throw new PersonNotFoundException("Student not found: " + studentId);
        }
        if (course == null) {
            throw new CourseNotFoundException("Course not found: " + courseId);
        }
        if (!(person instanceof Student)) {
            throw new InvalidPersonDataException("Person is not a student: " + studentId);
        }
        
        Student student = (Student) person;
        if (course.addStudent(studentId)) {
            try {
                student.enrollInCourse(courseId);
            } catch (InvalidPersonDataException e) {
                throw e;
            }
            return true;
        }
        return false;
    }
    
    public boolean assignInstructorToCourse(String courseId, String instructorId) throws PersonNotFoundException, CourseNotFoundException, InvalidPersonDataException {
        Person person = people.get(instructorId);
        Course course = courses.get(courseId);
        
        if (person == null) {
            throw new PersonNotFoundException("Instructor not found: " + instructorId);
        }
        if (course == null) {
            throw new CourseNotFoundException("Course not found: " + courseId);
        }
        if (!(person instanceof Instructor)) {
            throw new InvalidPersonDataException("Person is not an instructor: " + instructorId);
        }
        
        Instructor instructor = (Instructor) person;
        try {
            course.setInstructorId(instructorId);
            instructor.assignCourse(courseId);
        } catch (InvalidPersonDataException e) {
            throw e;
        }
        return true;
    }
    
    public void displayPersonInfo(String personId) throws PersonNotFoundException {
        Person person = people.get(personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found: " + personId);
        }
        System.out.println(getDetailedPersonInfo(person));
    }
    
    private String getDetailedPersonInfo(Person person) {
        StringBuilder info = new StringBuilder(person.getInfo());
        
        if (person instanceof Student) {
            Student student = (Student) person;
            List<String> courseNames = new ArrayList<>();
            for (String courseId : student.getEnrolledCourses()) {
                Course course = courses.get(courseId);
                courseNames.add(course != null ? course.getCourseName() : courseId);
            }
            info.append(", Enrolled Courses: ").append(courseNames);
        } else if (person instanceof Instructor) {
            Instructor instructor = (Instructor) person;
            List<String> courseNames = new ArrayList<>();
            for (String courseId : instructor.getTeachingCourses()) {
                Course course = courses.get(courseId);
                courseNames.add(course != null ? course.getCourseName() : courseId);
            }
            info.append(", Teaching Courses: ").append(courseNames);
        }
        
        return info.toString();
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
            System.out.println(getDetailedCourseInfo(course));
        }
    }
    
    private String getDetailedCourseInfo(Course course) {
        StringBuilder info = new StringBuilder();
        info.append(String.format("Course[ID: %s, Name: %s, Credits: %d]", 
                   course.getCourseId(), course.getCourseName(), course.getCredits()));
        
        String instructorId = course.getInstructorId();
        if (instructorId != null) {
            Person instructor = people.get(instructorId);
            String instructorName = instructor != null ? instructor.getName() : instructorId;
            info.append(String.format(", Instructor: %s", instructorName));
        } else {
            info.append(", Instructor: TBA");
        }
        
        List<String> studentNames = new ArrayList<>();
        for (String studentId : course.getEnrolledStudents()) {
            Person student = people.get(studentId);
            studentNames.add(student != null ? student.getName() : studentId);
        }
        info.append(String.format(", Enrolled Students: %s (%d/%d)", 
                   studentNames, course.getCurrentEnrollment(), course.getMaxCapacity()));
        
        return info.toString();
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
            
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Exception: 👉Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }
            
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
        
        try {
            addStudent(id, name, email, major);
            System.out.println("Student added successfully!");
        } catch (InvalidPersonDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
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
        
        try {
            addInstructor(id, name, email, department);
            System.out.println("Instructor added successfully!");
        } catch (InvalidPersonDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void addCourseMenu() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter Credits: ");
        int credits;
        try {
            credits = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid credits input!");
            scanner.nextLine();
            return;
        }
        System.out.print("Enter Max Capacity: ");
        int maxCapacity;
        try {
            maxCapacity = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid capacity input!");
            scanner.nextLine();
            return;
        }
        
        try {
            addCourse(courseId, courseName, credits, maxCapacity);
            System.out.println("Course added successfully!");
        } catch (InvalidPersonDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void enrollStudentMenu() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        
        try {
            if (enrollStudentInCourse(studentId, courseId)) {
                System.out.println("Enrollment successful!");
            } else {
                System.out.println("Enrollment failed!");
            }
        } catch (PersonNotFoundException | CourseNotFoundException | CourseCapacityException | InvalidPersonDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void assignInstructorMenu() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter Instructor ID: ");
        String instructorId = scanner.nextLine();
        
        try {
            if (assignInstructorToCourse(courseId, instructorId)) {
                System.out.println("Instructor assigned successfully!");
            } else {
                System.out.println("Assignment failed!");
            }
        } catch (PersonNotFoundException | CourseNotFoundException | InvalidPersonDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void displayPersonMenu() {
        System.out.print("Enter Person ID: ");
        String personId = scanner.nextLine();
        try {
            displayPersonInfo(personId);
        } catch (PersonNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new StudentCourseManagementSystem().run();
    }
}