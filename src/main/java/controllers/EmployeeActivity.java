package controllers;

public class EmployeeActivity {
    private String employeeName;
    private String action;

    public EmployeeActivity(String employeeName, String action) {
        this.employeeName = employeeName;
        this.action = action;
    }

    public String getEmployeeName() { return employeeName; }
    public String getAction() { return action; }
}