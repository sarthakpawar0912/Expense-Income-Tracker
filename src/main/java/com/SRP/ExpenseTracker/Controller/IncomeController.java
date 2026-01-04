package com.SRP.ExpenseTracker.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SRP.ExpenseTracker.Service.income.IncomeService;
import com.SRP.ExpenseTracker.dto.IncomeDTO;
import com.SRP.ExpenseTracker.dto.PagedResponseDTO;
import com.SRP.ExpenseTracker.entity.Income;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeController {

	private final IncomeService incomeService ;

	@PostMapping
	public ResponseEntity<?> postIncome(@RequestBody IncomeDTO incomeDTO){
		Income createdIncome= incomeService.postIncome(incomeDTO);
		if(createdIncome!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
		}else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllIncome(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size){
		PagedResponseDTO<IncomeDTO> response = incomeService.getAllIncomesPaginated(page, size);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateIncome(@PathVariable Long id, @RequestBody IncomeDTO incomeDTO) {
		try {
			IncomeDTO updatedIncome = incomeService.updateIncome(id, incomeDTO).getIncomeDTO();
			return ResponseEntity.ok(updatedIncome);
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong: " + e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getIncomeById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(incomeService.getIncomeById(id));
		}catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteIncome(@PathVariable Long id){
		try {
			incomeService.deleteIncome(id);
			return ResponseEntity.ok(null);
		}catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
		}
	}

}
