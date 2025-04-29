public class FoodOrder {
    private int orderId;
    private int tableId;
    private Server server;
    private String status;

    public FoodOrder(int orderId, int tableId, Server server) {
        this.orderId = orderId;
        this.tableId = tableId;
        this.server = server;
        this.status = "Pending";
    }

    public void markCompleted() {
        this.status = "Completed";
    }

    public String getStatus() {
        return status;
    }
}