class InvalidPersonDataException extends Exception {
    public InvalidPersonDataException(String message) {
        super(message);
    }
}

class CourseCapacityException extends Exception {
    public CourseCapacityException(String message) {
        super(message);
    }
}

class PersonNotFoundException extends Exception {
    public PersonNotFoundException(String message) {
        super(message);
    }
}

class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String message) {
        super(message);
    }
}