package com.hcr.swd392g3.project.service.IService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcr.swd392g3.project.dto.ReceiptDTO;
import com.hcr.swd392g3.project.entity.Receipt;


public interface IReceiptService {
	ReceiptDTO insertReceipt(Receipt receipt);
	List<ReceiptDTO> findAll();
}
