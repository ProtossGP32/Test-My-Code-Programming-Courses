public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory productHistory;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.productHistory = new ChangeHistory();
        this.addToWarehouse(initialBalance);
    }

    public String history() {
        return this.productHistory.toString();
    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.productHistory.add(this.getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double takenAmount = super.takeFromWarehouse(amount);
        this.productHistory.add(this.getBalance());
        return takenAmount;
    }

    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.productHistory);
        System.out.println("Largest amount of product: " + this.productHistory.maxValue());
        System.out.println("Smallest amount of product: " + this.productHistory.minValue());
        System.out.println("Average: " + this.productHistory.average());
    }
}
