package com.SRP.ExpenseTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SRP.ExpenseTracker.Service.Expense.ExpenseService;
import com.SRP.ExpenseTracker.dto.ExpenseDTO;
import com.SRP.ExpenseTracker.entity.Expense;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenseController {

	private final ExpenseService expenseService;

	@PostMapping("/")
	public ResponseEntity<?> postExpense(@RequestBody ExpenseDTO dto) {
		try {
			Expense createdExpense = expenseService.postExpense(dto);
			if (createdExpense != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create expense");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllExpenses(){
		return ResponseEntity.ok(expenseService.getAllExpenses());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getExpenseById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(expenseService.getExpenseById(id));
		}catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateExpense(@PathVariable Long id, @RequestBody(required = false) ExpenseDTO dto) {
		if (dto == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request body is missing or invalid.");
		}

		try {
			Expense updatedExpense = expenseService.updateExpense(id, dto);
			return ResponseEntity.ok(updatedExpense);
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteExpense(@PathVariable Long id){
		try {
			expenseService.deleteExpense(id);
			return ResponseEntity.ok(null);
		}catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
		}
	}

}
