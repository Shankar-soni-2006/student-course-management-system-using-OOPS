public abstract class Person {
    private String id;
    private String name;
    private String email;
    
    public Person(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    
    public abstract String getRole();
    
    public String getInfo() {
        return String.format("ID: %s, Name: %s, Email: %s, Role: %s", 
                           id, name, email, getRole());
    }
}