package com.CodeElevate.ExpenseTracker.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseDTO {

	private Long id;
	
	
	 private String title;
	 
		private String description;
		
		private String category; 
		
		private LocalDate date;
		
		private Integer amount;

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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public Integer getAmount() {
			return amount;
		}

		public void setAmount(Integer amount) {
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "ExpenseDTO [id=" + id + ", title=" + title + ", description=" + description + ", category="
					+ category + ", date=" + date + ", amount=" + amount + "]";
		}

		public ExpenseDTO(Long id, String title, String description, String category, LocalDate date, Integer amount) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.category = category;
			this.date = date;
			this.amount = amount;
		}

		public ExpenseDTO() {
				// TODO Auto-generated constructor stub
		}
	 
}
