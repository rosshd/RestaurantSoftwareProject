public class Table {
    private int tableId;
    private int maxSeats;
    private int currentSeats;
    private String status;

    public Table(int tableId, int maxSeats) {
        this.tableId = tableId;
        this.maxSeats = maxSeats;
        this.status = "Available";
    }

    public int getTableId() {
        return tableId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}