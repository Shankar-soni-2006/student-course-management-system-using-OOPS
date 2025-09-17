# Student Course Management System

A console-based Java application demonstrating Object-Oriented Programming principles including encapsulation, inheritance, polymorphism, and comprehensive exception handling with enhanced display features.

## Features

- **Dynamic Student Management**: Add and manage student records with validation
- **Instructor Management**: Add and assign instructors to courses
- **Course Management**: Create courses with capacity limits and enrollment tracking
- **Enrollment System**: Enroll students in courses with comprehensive validation
- **Exception Handling**: Custom exceptions with throws/throw keywords
- **Enhanced Display**: Shows course names for students/instructors and names for course enrollments
- **Interactive Console Interface**: Menu-driven operations with detailed error handling

## OOP Principles Demonstrated

### Encapsulation
- Private fields with public getter/setter methods
- Controlled access to class data with validation

### Inheritance
- `Student` and `Instructor` classes inherit from `Person` base class
- Shared attributes and methods with specialized behavior

### Polymorphism
- Method overriding in subclasses
- Runtime polymorphism through abstract methods

### Exception Handling
- Custom exception classes for specific error scenarios
- Proper use of `throws` and `throw` keywords
- Comprehensive error validation and user feedback

## Exception Classes

- **InvalidPersonDataException**: Invalid data validation errors
- **CourseCapacityException**: Course enrollment capacity issues
- **PersonNotFoundException**: Person lookup failures
- **CourseNotFoundException**: Course lookup failures

## Display Features

### Student Information
- Shows enrolled course names instead of IDs
- Format: `Student[ID: S001, Name: John Doe, Email: john@email.com, Major: CS, Enrolled Courses: [Programming, Database]]`

### Instructor Information
- Shows teaching course names instead of IDs
- Format: `Instructor[ID: I001, Name: Dr. Smith, Email: smith@email.com, Department: CS, Teaching Courses: [Programming, Algorithms]]`

### Course Information
- Shows instructor name and enrolled student names
- Format: `Course[ID: CS101, Name: Programming, Credits: 3], Instructor: Dr. Smith, Enrolled Students: [John Doe, Jane Smith] (2/30)`

## How to Run

1. Compile all Java files:
   ```bash
   javac *.java
   ```

2. Run the application:
   ```bash
   java StudentCourseManagementSystem
   ```

## Menu Options

1. Add Student
2. Add Instructor
3. Add Course
4. Display All People
5. Display All Courses
6. Enroll Student in Course
7. Assign Instructor to Course
8. Display Person Info
9. Exit

## Classes

- **Person**: Abstract base class with validation
- **Student**: Inherits from Person, manages student data and course enrollment
- **Instructor**: Inherits from Person, manages instructor data and course assignments
- **Course**: Manages course information, enrollment, and capacity validation
- **CustomExceptions**: Contains all custom exception classes
- **StudentCourseManagementSystem**: Main application class with exception handling and enhanced display methods

## Error Handling Features

- Input validation for all user entries
- Duplicate ID prevention
- Course capacity enforcement
- Email format validation
- Type validation (student vs instructor)
- Comprehensive error messages with meaningful feedback