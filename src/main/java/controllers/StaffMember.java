package controllers;

public class StaffMember {
    private String name;
    private String pin;
    private String role;

    public StaffMember(String name, String pin, String role) {
        this.name = name;
        this.pin = pin;
        this.role = role;
    }

    public String getName() { return name; }
    public String getPin() { return pin; }
    public String getRole() { return role; }
}
