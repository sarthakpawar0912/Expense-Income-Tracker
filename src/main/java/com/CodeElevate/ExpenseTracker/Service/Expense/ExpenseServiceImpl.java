package com.CodeElevate.ExpenseTracker.Service.Expense;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodeElevate.ExpenseTracker.Repository.ExpenseRepository;
import com.CodeElevate.ExpenseTracker.dto.ExpenseDTO;
import com.CodeElevate.ExpenseTracker.entity.Expense;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl  implements ExpenseService{

	@Autowired
	private ExpenseRepository expenseRepository ;
	
	public Expense postExpense(ExpenseDTO expenseDTO) {
		return saveOrUpdateExpense(new Expense(),expenseDTO);
	}
	
	private Expense saveOrUpdateExpense(Expense expense,ExpenseDTO expenseDTO) {
		 expense.setTitle(expenseDTO.getTitle());
		 expense.setDate(expenseDTO.getDate());
		 expense.setAmount(expenseDTO.getAmount());
		 expense.setCategory(expenseDTO.getCategory());
		 expense.setDescription(expenseDTO.getDescription());
		 
		 
		 
		 
		return expenseRepository.save(expense);
		 
	}
	
	
	public Expense updateExpense(Long id,ExpenseDTO expenseDTO) {
		Optional<Expense> optionalExpense= expenseRepository.findById(id);
		if(optionalExpense.isEmpty()) {
			return saveOrUpdateExpense(optionalExpense.get(), expenseDTO);
		}else {
			throw new EntityNotFoundException("Expense is not present with id "+id);
		}
	}
	
	
	public List<Expense> getallExpenses(){
		return expenseRepository.findAll().stream().sorted(Comparator.comparing(Expense::getDate).reversed()).collect(Collectors.toList());
	}
	
	
	public Expense getExpenseById(Long id) {
		Optional<Expense> optionalExpense= expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			throw new EntityNotFoundException("Expense is not present with id="+id);
		}
	}	
	public void deleteExpense(Long id) {
		Optional<Expense> optionalExpense= expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			expenseRepository.deleteById(id);
		}else {
			throw new EntityNotFoundException("Expense is not present with id"+id);
		}
	}
		
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
