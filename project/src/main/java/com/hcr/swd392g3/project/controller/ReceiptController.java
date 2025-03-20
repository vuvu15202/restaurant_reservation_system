package com.hcr.swd392g3.project.controller;

import com.hcr.swd392g3.project.converter.CustomerConverter;
import com.hcr.swd392g3.project.converter.MenuConverter;
import com.hcr.swd392g3.project.converter.ReceiptConverter;
import com.hcr.swd392g3.project.dto.CustomerDTO;
import com.hcr.swd392g3.project.dto.FeedbackDTO;
import com.hcr.swd392g3.project.dto.ReceiptDTO;
import com.hcr.swd392g3.project.dto.ReceiptDetailDTO;
import com.hcr.swd392g3.project.entity.Cart;
import com.hcr.swd392g3.project.entity.CartItem;
import com.hcr.swd392g3.project.entity.Receipt;
import com.hcr.swd392g3.project.entity.ReceiptDetail;
import com.hcr.swd392g3.project.service.IService.ICustomerService;
import com.hcr.swd392g3.project.service.IService.IReceiptDetailService;
import com.hcr.swd392g3.project.service.IService.IReceiptService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class ReceiptController {
    @Autowired
    IReceiptService receiptService;
    
    @Autowired
    IReceiptDetailService receiptDetailService;
    
    @Autowired
    ReceiptConverter receiptConverter;
    
    @Autowired
    CustomerConverter customerConverter;
    
    @Autowired
    MenuConverter menuConverter;
    
    @Autowired
    ICustomerService customerService;
    
    @Autowired
    HttpSession session;
    
    @GetMapping(value = "/receipts")
    public ResponseEntity<?> getAllFeedback() {
    	
      return new ResponseEntity<List<ReceiptDTO>>(receiptService.findAll(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody CustomerDTO user) throws Exception {
    	Cart cart = (Cart) session.getAttribute("cart");  System.out.println(user.getAddress());
    	user.setPersonID(user.getCustomerID());
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	 String currentTimeString = dateFormat.format(new Date());
    	 Date currentDate = null;
    	 try {
             currentDate = dateFormat.parse(currentTimeString);
         } catch (ParseException e) {
             e.printStackTrace();
         }
//        Date date = dateFormat.parse(LocalDate.now().toString());
       
    	Receipt newReceipt = receiptConverter.toEntity(new ReceiptDTO(currentDate, false, true, customerConverter.toEntity(user)));
    	ReceiptDTO newReceiptDTO = receiptService.insertReceipt(newReceipt);
//    	List<ReceiptDetailDTO> receiptDetailDTOs = new ArrayList<>();
//    	
//    	for (CartItem cartItem : cart.getItems()) {
//    		receiptDetailDTOs.add(new ReceiptDetailDTO(100000, 0.2f, cartItem.getQuantity(), menuConverter.toEntity(cartItem.getMenuDTO())));
//		}
    	
    	List<ReceiptDetail> receiptDetails = new ArrayList<>();
    	for (CartItem cartItem : cart.getItems()) {
    		ReceiptDetail receiptDetail = new ReceiptDetail();
    		receiptDetail.setReceipt(receiptConverter.toEntity(newReceiptDTO));
    		receiptDetail.setTax(100000);
    		receiptDetail.setDiscountPercentage(0.2f);
    		receiptDetail.setQuantity(cartItem.getQuantity());
    		receiptDetail.setMenu(menuConverter.toEntity(cartItem.getMenuDTO()));
    		receiptDetails.add(receiptDetail);
		}
    	
    	receiptDetailService.insertReceipt(receiptDetails);
        return ResponseEntity.ok(newReceiptDTO);
    }
}
