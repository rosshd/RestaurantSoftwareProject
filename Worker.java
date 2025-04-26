public class Worker {
    protected int workerId;
    protected String name;
    protected String contactInfo;
    protected String role;
    protected String availability;

    public Worker(int workerId, String name, String contactInfo, String role, String availability) {
        this.workerId = workerId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.role = role;
        this.availability = availability;
    }

    public Worker( ,  ,  ) {
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }
}