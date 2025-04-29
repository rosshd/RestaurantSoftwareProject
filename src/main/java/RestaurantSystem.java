import java.util.*;
import java.io.*;

public class RestaurantSystem {
    private List<Worker> staff = new ArrayList<>();
    private List<Table> tables = new ArrayList<>();

    public void loadStaff(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[2].equalsIgnoreCase("Server")) {
                    staff.add(new Server(Integer.parseInt(parts[0]), parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeTables() {
        for (int i = 1; i <= 30; i++) {
            tables.add(new Table(i, 4));
        }
    }

    public List<Worker> getStaff() { return staff; }
    public List<Table> getTables() { return tables; }
}