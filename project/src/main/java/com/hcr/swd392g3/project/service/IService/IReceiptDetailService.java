package com.hcr.swd392g3.project.service.IService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcr.swd392g3.project.dto.ReceiptDetailDTO;
import com.hcr.swd392g3.project.entity.ReceiptDetail;


public interface IReceiptDetailService {
	List<ReceiptDetailDTO> insertReceipt(List<ReceiptDetail> receiptDetail);
}
