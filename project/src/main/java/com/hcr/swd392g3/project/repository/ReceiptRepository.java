package com.hcr.swd392g3.project.repository;

import com.hcr.swd392g3.project.entity.Receipt;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
//	List<Receipt> findAllByPersonID(int customerID);
	
//	@Query("SELECT r FROM Receipt r WHERE c.customerID = :customerID ")
//	List<Receipt> findAllByCustomerID(@Param("customerID") int customerID);
}
