package com.CodeElevate.ExpenseTracker.Service.income.stats;

import com.CodeElevate.ExpenseTracker.dto.GraphDTO;
import com.CodeElevate.ExpenseTracker.dto.StatsDTO;

public interface StatsService {

	GraphDTO getChartData();
	
	StatsDTO getStats();
}
