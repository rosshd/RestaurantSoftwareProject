public class Server extends Worker {
    private int assignedTableId;

    public Server(int workerId, String name, String contactInfo, String availability) {
        super(workerId, name, contactInfo, "Server", availability);
    }

    public Server(int workerId, String part, String part1) {
        super();
    }

    public void setAssignedTableId(int tableId) {
        this.assignedTableId = tableId;
    }

    public int getAssignedTableId() {
        return assignedTableId;
    }
}