package com.SRP.ExpenseTracker.Service.income;

import java.util.List;

import com.SRP.ExpenseTracker.dto.IncomeDTO;
import com.SRP.ExpenseTracker.entity.Income;

public interface IncomeService {

	Income postIncome(IncomeDTO incomeDTO);

	List<IncomeDTO> getAllIncomes();

    Income updateIncome(Long id, IncomeDTO incomeDTO);

    IncomeDTO getIncomeById(Long id);

    void deleteIncome(Long id);

}
