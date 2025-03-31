package com.SRP.ExpenseTracker.Repository;

import java.util.List;
import java.util.Optional;

import com.SRP.ExpenseTracker.dto.IncomeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SRP.ExpenseTracker.entity.Income;
import java.time.LocalDate;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long>{

	List<Income> findByDateBetween(LocalDate startDate,LocalDate endDate);

	@Query("SELECT SUM(i.amount) FROM Income i")
	Double sumAllAmounts();

	Optional<Income> findFirstByOrderByDateDesc();

}
