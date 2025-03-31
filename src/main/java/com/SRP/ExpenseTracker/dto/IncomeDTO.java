package com.SRP.ExpenseTracker.dto;

import java.time.LocalDate;

import lombok.*;

@Data
public class IncomeDTO {

	private Long id;
	private String title;
	private Integer amount;
	private LocalDate date;
	private String category;
	private String description;

}
