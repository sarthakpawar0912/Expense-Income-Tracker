package com.SRP.ExpenseTracker.Service.Expense;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.SRP.ExpenseTracker.Repository.ExpenseRepository;
import com.SRP.ExpenseTracker.dto.ExpenseDTO;
import com.SRP.ExpenseTracker.dto.PagedResponseDTO;
import com.SRP.ExpenseTracker.entity.Expense;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl  implements ExpenseService{

	private final  ExpenseRepository expenseRepository ;

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
		if(optionalExpense.isPresent()) {
			return saveOrUpdateExpense(optionalExpense.get(), expenseDTO);
		}else {
			throw new EntityNotFoundException("Expense is not present with id "+id);
		}
	}

	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll()
				.stream().sorted(Comparator.comparing(Expense::getDate)
				.reversed()).collect(Collectors.toList());
	}

	public PagedResponseDTO<Expense> getAllExpensesPaginated(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Expense> expensePage = expenseRepository.findAllByOrderByDateDesc(pageable);

		PagedResponseDTO<Expense> response = new PagedResponseDTO<>();
		response.setContent(expensePage.getContent());
		response.setPageNumber(expensePage.getNumber());
		response.setPageSize(expensePage.getSize());
		response.setTotalElements(expensePage.getTotalElements());
		response.setTotalPages(expensePage.getTotalPages());
		response.setLast(expensePage.isLast());
		response.setFirst(expensePage.isFirst());

		return response;
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
