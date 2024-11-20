package com.CodeElevate.ExpenseTracker.Service.income;

import java.util.List;

import com.CodeElevate.ExpenseTracker.dto.IncomeDTO;
import com.CodeElevate.ExpenseTracker.entity.Income;

public interface IncomeService {

	Income postIncome(IncomeDTO incomeDTO);
	
	
	List<IncomeDTO> getAllIncomes();
    Income updateIncome(Long id, IncomeDTO incomeDTO);
    
    IncomeDTO getIncomeById(Long id);
    void deleteIncome(Long id);
}
