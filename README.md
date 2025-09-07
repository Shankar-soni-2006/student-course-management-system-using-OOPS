# Student Course Management System

A console-based Java application demonstrating Object-Oriented Programming principles including encapsulation, inheritance, and polymorphism.

## Features

- **Dynamic Student Management**: Add and manage student records
- **Instructor Management**: Add and assign instructors to courses
- **Course Management**: Create courses with capacity limits
- **Enrollment System**: Enroll students in courses with validation
- **Interactive Console Interface**: Menu-driven operations

## OOP Principles Demonstrated

### Encapsulation
- Private fields with public getter/setter methods
- Controlled access to class data

### Inheritance
- `Student` and `Instructor` classes inherit from `Person` base class
- Shared attributes and methods

### Polymorphism
- Method overriding in subclasses
- Runtime polymorphism through abstract methods

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

- **Person**: Abstract base class
- **Student**: Inherits from Person, manages student data
- **Instructor**: Inherits from Person, manages instructor data
- **Course**: Manages course information and enrollment
- **StudentCourseManagementSystem**: Main application class