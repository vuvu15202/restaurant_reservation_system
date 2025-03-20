package com.hcr.swd392g3.project.service;

import com.hcr.swd392g3.project.converter.ReceiptConverter;
import com.hcr.swd392g3.project.dto.ReceiptDTO;
import com.hcr.swd392g3.project.entity.Receipt;
import com.hcr.swd392g3.project.repository.ReceiptRepository;
import com.hcr.swd392g3.project.service.IService.IReceiptService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl implements IReceiptService {

	@Autowired
	ReceiptRepository receiptRepository;
	
	@Autowired
	ReceiptConverter receiptConverter;
	
	@Override
	public ReceiptDTO insertReceipt(Receipt receipt) {
		return receiptConverter.toDTO(receiptRepository.save(receipt));
	}

	@Override
	public List<ReceiptDTO> findAll() {
		List<Receipt> receipts = receiptRepository.findAll();
		List<ReceiptDTO> receiptDTOs = new ArrayList<>();
		for (Receipt receipt : receipts) {
			receiptDTOs.add(receiptConverter.toDTO(receipt));
		}
		return receiptDTOs;
	}
}
