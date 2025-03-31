package com.SRP.ExpenseTracker.dto;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.SRP.ExpenseTracker.entity.Expense;
import com.SRP.ExpenseTracker.entity.Income;
import lombok.Data;
@Data
@ResponseBody
public class GraphDTO {
	private List<Expense> expenseList;
	private List<Income> incomeList;

	public void setExpenseList(List<Expense> expenseList) {
		this.expenseList = expenseList;
	}

	public void setIncomeList(List<Income> incomeList) {
		this.incomeList = incomeList;
	}
}
