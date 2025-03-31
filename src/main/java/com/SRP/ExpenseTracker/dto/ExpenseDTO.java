package com.SRP.ExpenseTracker.dto;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDTO {

	@JsonProperty("id")
	private Long id;
	private String title;
	private String description;
	private String category;
	private LocalDate date;
	private Integer amount;

}
