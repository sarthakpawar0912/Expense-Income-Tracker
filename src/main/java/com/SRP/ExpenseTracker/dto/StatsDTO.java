package com.SRP.ExpenseTracker.dto;

import com.SRP.ExpenseTracker.entity.Expense;
import com.SRP.ExpenseTracker.entity.Income;

import lombok.*;

@Data
public class StatsDTO {

	private Double income;
	private Double expense;
	private Income latestIncome;
	private Expense latestExpense;
	private Double balance;
	private Double minIncome;
	private Double maxIncome;
	private Double minExpense;
	private Double maxExpense;
}
