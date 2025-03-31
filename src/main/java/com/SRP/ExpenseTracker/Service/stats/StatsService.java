package com.SRP.ExpenseTracker.Service.stats;

import com.SRP.ExpenseTracker.dto.GraphDTO;
import com.SRP.ExpenseTracker.dto.StatsDTO;

public interface StatsService {

	GraphDTO getChartData();
	
	StatsDTO getStats();
}
