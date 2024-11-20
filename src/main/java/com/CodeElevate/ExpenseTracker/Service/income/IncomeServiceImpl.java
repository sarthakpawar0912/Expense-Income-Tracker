package com.CodeElevate.ExpenseTracker.Service.income;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodeElevate.ExpenseTracker.Repository.IncomeRepository;
import com.CodeElevate.ExpenseTracker.dto.IncomeDTO;
import com.CodeElevate.ExpenseTracker.entity.Income;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
	@Autowired
	private IncomeRepository incomeRepository;
	
	public Income postIncome(IncomeDTO incomeDTO) {
		return saveOrUpdateIncome(new Income(), incomeDTO);
		
	}
	
	private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO) {
		income.setTitle(incomeDTO.getTitle());
		income.setId(incomeDTO.getId());
		income.setDescription(incomeDTO.getDescription());
		income.setDate(incomeDTO.getDate());
		income.setCategory(incomeDTO.getCategory());
		income.setAmount(incomeDTO.getAmount());
		incomeRepository.save(income);
		return income;
	}
	
	public List<IncomeDTO> getAllIncomes(){
		return incomeRepository.findAll().stream().sorted(Comparator.comparing(Income::getDate)
				.reversed()).map(Income::getIncomeDTO).collect(Collectors.toList());
				
	}
	 

	public Income updateIncome(Long id, IncomeDTO incomeDTO) {
		Optional<Income> optionalIncome =incomeRepository.findById(id);
		if(optionalIncome.isPresent()) {
			return saveOrUpdateIncome(optionalIncome.get(), incomeDTO);
		}else {
			throw new EntityNotFoundException("Income is not present with id"+id);
		}
		
	}


	public IncomeDTO getIncomeById(Long id) {
		Optional<Income> optionalIncome=incomeRepository.findById(id);
		if(optionalIncome.isPresent()) {
			return optionalIncome.get().getIncomeDTO();
		}else {
			throw new EntityNotFoundException("Income is not present with id"+id);
		}
	}	
	public void deleteIncome(Long id) {
		Optional<Income> optionalIncome=incomeRepository.findById(id);
		if(optionalIncome.isPresent()) {
			incomeRepository.deleteById(id);
		}else {
			throw new EntityNotFoundException("expense is not present with id");
		}
			
	}
	public Income updateIncome(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public IncomeDTO incomeDTO() {
		// TODO Auto-generated method stub
		return null;
	}	
}


