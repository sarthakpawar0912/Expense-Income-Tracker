package com.CodeElevate.ExpenseTracker.entity;

import java.time.LocalDate;

import com.CodeElevate.ExpenseTracker.dto.IncomeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", title=" + title + ", amount=" + amount + ", date=" + date + ", category="
				+ category + ", description=" + description + "]";
	}

	public Income(Long id, String title, Integer amount, LocalDate date, String category, String description) {
		super();
		this.id = id;
		this.title = title;
		this.amount = amount;
		this.date = date;
		this.category = category;
		this.description = description;
	}

	public Income() {

	}

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
