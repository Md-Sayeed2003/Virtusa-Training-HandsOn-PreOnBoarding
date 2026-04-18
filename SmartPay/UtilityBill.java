public class UtilityBill implements Billable {

    private String customerName;
    private int previousReading;
    private int currentReading;
    private int unitsConsumed;
    private double totalAmount;

    // Constructor
    public UtilityBill(String customerName, int previousReading, int currentReading) {
        this.customerName = customerName;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.unitsConsumed = currentReading - previousReading;
    }

    
    @Override
    public double calculateTotal(int units) {
        double amount = 0;

        if (units <= 100) {
            amount = units * 1.0;
        } else if (units <= 300) {
            amount = (100 * 1.0) + (units - 100) * 2.0;
        } else {
            amount = (100 * 1.0) + (200 * 2.0) + (units - 300) * 5.0;
        }

        return amount;
    }

    // Generate receipt
    public void generateBill() {
        totalAmount = calculateTotal(unitsConsumed);

        System.out.println("\n===== SMARTPAY DIGITAL RECEIPT =====");
        System.out.println("Customer Name   : " + customerName);
        System.out.println("Units Consumed  : " + unitsConsumed);
        System.out.println("Total Amount ($): " + totalAmount);
        System.out.println("====================================\n");
    }

    // Getter method
    public int getUnitsConsumed() {
        return unitsConsumed;
    }
}