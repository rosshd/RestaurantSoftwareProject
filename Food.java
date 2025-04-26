public class Food {
    private int foodId;
    private String name;
    private double cost;
    private int stock;

    public Food(int foodId, String name, double cost, int stock) {
        this.foodId = foodId;
        this.name = name;
        this.cost = cost;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int qty) {
        this.stock -= qty;
    }
}