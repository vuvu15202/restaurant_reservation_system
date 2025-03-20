package com.hcr.swd392g3.project.repository;

import com.hcr.swd392g3.project.entity.ReceiptDetail;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, Integer> {
//	@Query("SELECT c FROM ReceiptDetail c WHERE c.receiptID = :receiptID")
//	List<ReceiptDetail> findBy(@Param("receiptID") int receiptID);

}
