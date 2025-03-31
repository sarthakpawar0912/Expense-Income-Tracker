package com.SRP.ExpenseTracker.entity;

import java.time.LocalDate;

import com.SRP.ExpenseTracker.dto.IncomeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class Income {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Integer amount;
	private LocalDate date;
	private String category;
	private String description;


	public IncomeDTO getIncomeDTO() {
		IncomeDTO incomeDTO = new IncomeDTO();

		incomeDTO.setId(id);
		incomeDTO.setTitle(title);
		incomeDTO.setAmount(amount);
		incomeDTO.setDate(date);
		incomeDTO.setDescription(description);
		incomeDTO.setCategory(category);
		return incomeDTO;

	}

}
