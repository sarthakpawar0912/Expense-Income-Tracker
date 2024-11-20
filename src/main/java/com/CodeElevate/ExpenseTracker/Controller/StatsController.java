package com.CodeElevate.ExpenseTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CodeElevate.ExpenseTracker.Service.income.stats.StatsService;
import com.CodeElevate.ExpenseTracker.dto.GraphDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {

	@Autowired
	private StatsService statsService;

	@GetMapping("/chart")
	public ResponseEntity<GraphDTO> getChartData() {
		return ResponseEntity.ok(statsService.getChartData());
	}

	public ResponseEntity<?> getStats() {
		return ResponseEntity.ok(statsService.getStats());
	}

}
