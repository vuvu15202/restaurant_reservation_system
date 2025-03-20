package com.hcr.swd392g3.project.service;

import com.hcr.swd392g3.project.converter.ReceiptDetailConverter;
import com.hcr.swd392g3.project.dto.ReceiptDetailDTO;
import com.hcr.swd392g3.project.entity.ReceiptDetail;
import com.hcr.swd392g3.project.repository.ReceiptDetailRepository;
import com.hcr.swd392g3.project.repository.TableRepository;
import com.hcr.swd392g3.project.service.IService.IReceiptDetailService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptDetailServiceImpl implements IReceiptDetailService {

	@Autowired
    private ReceiptDetailRepository receiptDetailRepository;
	
	@Autowired
    private ReceiptDetailConverter receiptDetailConverter;

	@Override
	public List<ReceiptDetailDTO> insertReceipt(List<ReceiptDetail> receiptDetails) {
		List<ReceiptDetail> newList = receiptDetailRepository.saveAll(receiptDetails);
		List<ReceiptDetailDTO> newListDTO = new ArrayList<>();
		for (ReceiptDetail receiptDetail : newList) {
			newListDTO.add(receiptDetailConverter.toDTO(receiptDetail));
		}
		return newListDTO;		
	}
	
	
}
