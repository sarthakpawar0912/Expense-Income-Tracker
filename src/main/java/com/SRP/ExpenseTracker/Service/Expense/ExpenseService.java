package com.SRP.ExpenseTracker.Service.Expense;

import java.util.List;

import com.SRP.ExpenseTracker.dto.ExpenseDTO;
import com.SRP.ExpenseTracker.entity.Expense;
public interface ExpenseService {

	Expense postExpense(ExpenseDTO expenseDTO);

	List<Expense> getAllExpenses();

	Expense updateExpense(Long id,ExpenseDTO expenseDTO);

	Expense getExpenseById(Long id);

	void deleteExpense(Long id) ;

}
