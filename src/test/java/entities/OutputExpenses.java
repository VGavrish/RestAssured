package entities;

import java.util.List;

public record OutputExpenses(String status, List<OutputExpense> data, int currentPage, int totalItems) {
}
