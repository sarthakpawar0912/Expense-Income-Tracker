package com.CodeElevate.ExpenseTracker.dto;

import java.util.List;

import com.CodeElevate.ExpenseTracker.entity.Expense;
import com.CodeElevate.ExpenseTracker.entity.Income;

import lombok.Data;

@Data
public class GraphDTO {

	private List<Expense> expenseList;
	
	private List<Income> incomeList;

	public void setExpenseList(List<Expense> byDateBetween) {
		// TODO Auto-generated method stub
		
	}

	public void setIncomeList(List<Income> byDateBetween) {
		// TODO Auto-generated method stub
		
	}

	
	
}
