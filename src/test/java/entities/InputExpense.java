package entities;

public record InputExpense(int carId, String reportedAt, int mileage, int liters, int totalCost, boolean forceMileage) {
}
