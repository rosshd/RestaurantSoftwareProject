package controllers;

public class TableLayout {
    private String tableName;
    private String status;  // e.g., "clean", "dirty", "occupied"
    private String serverAssigned;  // The name of the server assigned to this table
    private boolean reservation;  // Whether the table has a reservation
    private int guests;  // Number of guests assigned to the table
    private String order;  // Order details, if any

    public TableLayout(String tableName, String status, String serverAssigned, boolean reservation, int guests, String order) {
        this.tableName = tableName;
        this.status = status;
        this.serverAssigned = serverAssigned;
        this.reservation = reservation;
        this.guests = guests;
        this.order = order;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServerAssigned() {
        return serverAssigned;
    }

    public void setServerAssigned(String serverAssigned) {
        this.serverAssigned = serverAssigned;
    }

    public boolean isReservation() {
        return reservation;
    }

    public void setReservation(boolean reservation) {
        this.reservation = reservation;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
