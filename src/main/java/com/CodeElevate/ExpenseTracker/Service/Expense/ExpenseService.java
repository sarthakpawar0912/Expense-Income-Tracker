package com.CodeElevate.ExpenseTracker.Service.Expense;

import java.util.List;

import com.CodeElevate.ExpenseTracker.dto.ExpenseDTO;
import com.CodeElevate.ExpenseTracker.entity.Expense;

public interface ExpenseService {

	Expense postExpense(ExpenseDTO expenseDTO);

	List<Expense> getallExpenses();

	Expense updateExpense(Long id,ExpenseDTO expenseDTO);
	 Expense getExpenseById(Long id);
	 void deleteExpense(Long id) ;
}
