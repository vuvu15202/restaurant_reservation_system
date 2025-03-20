package com.hcr.swd392g3.project.dto;

import java.util.List;

import com.hcr.swd392g3.project.entity.Receipt;
import com.hcr.swd392g3.project.entity.Waitlist;

public class TableDTO {

    private int tableID;

    private int chairNumber;

    private int floorNo;

    private String privacy;

    private int status;

//    private List<Receipt> receipts;


//    public List<Receipt> getReceipts() {
//		return receipts;
//	}
//
//	public void setReceipts(List<Receipt> receipts) {
//		this.receipts = receipts;
//	}


    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public int getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(int chairNumber) {
        this.chairNumber = chairNumber;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
