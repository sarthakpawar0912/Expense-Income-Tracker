package com.SRP.ExpenseTracker.Service.income;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.SRP.ExpenseTracker.Repository.IncomeRepository;
import com.SRP.ExpenseTracker.dto.IncomeDTO;
import com.SRP.ExpenseTracker.entity.Income;

import jakarta.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

	private final IncomeRepository incomeRepository ;

	public Income postIncome(IncomeDTO incomeDTO) {
		return saveOrUpdateIncome(new Income(), incomeDTO);

	}

	private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO) {
		income.setTitle(incomeDTO.getTitle());
		income.setDescription(incomeDTO.getDescription());
		income.setDate(incomeDTO.getDate());
		income.setCategory(incomeDTO.getCategory());
		income.setAmount(incomeDTO.getAmount());

		return incomeRepository.save(income);
	}

	public List<IncomeDTO> getAllIncomes(){
		return incomeRepository.findAll().stream()
				.sorted(Comparator.comparing(Income::getDate)
				.reversed()).map(Income::getIncomeDTO)
				.collect(Collectors.toList());

	}

	public Income updateIncome(Long id, IncomeDTO incomeDTO) {
		Optional<Income> optionalIncome = incomeRepository.findById(id);
		if (optionalIncome.isPresent()) {
			Income income = optionalIncome.get();

			// Update fields without modifying the ID
			income.setTitle(incomeDTO.getTitle());
			income.setDescription(incomeDTO.getDescription());
			income.setDate(incomeDTO.getDate());
			income.setCategory(incomeDTO.getCategory());
			income.setAmount(incomeDTO.getAmount());

			// Save and return updated Income entity
			return incomeRepository.save(income);
		} else {
			throw new EntityNotFoundException("Income not found with ID: " + id);
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
			throw new EntityNotFoundException("Expense is not present with id"+id);
		}
	}

}
