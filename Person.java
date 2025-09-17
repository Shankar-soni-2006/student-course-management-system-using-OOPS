public abstract class Person {
    private String id;
    private String name;
    private String email;
    
    public Person(String id, String name, String email) throws InvalidPersonDataException {
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidPersonDataException("Exception: 👉ID cannot be null or empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPersonDataException("Exception: 👉Name cannot be null or empty");
        }
        if (email == null || !email.contains("@")) {
            throw new InvalidPersonDataException("Exception: 👉Invalid email format");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }
    

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    
    public void setName(String name) throws InvalidPersonDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPersonDataException("Exception: 👉Name cannot be null or empty");
        }
        this.name = name;
    }
    
    public void setEmail(String email) throws InvalidPersonDataException {
        if (email == null || !email.contains("@")) {
            throw new InvalidPersonDataException("Exception: 👉Invalid email format");
        }
        this.email = email;
    }
    
    public abstract String getRole();
    
    public String getInfo() {
        return String.format("ID: %s, Name: %s, Email: %s, Role: %s", 
                           id, name, email, getRole());
    }
}