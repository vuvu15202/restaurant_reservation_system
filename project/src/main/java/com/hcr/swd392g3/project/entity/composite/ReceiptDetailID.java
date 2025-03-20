package com.hcr.swd392g3.project.entity.composite;


import com.hcr.swd392g3.project.entity.Menu;
import com.hcr.swd392g3.project.entity.Receipt;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReceiptDetailID implements Serializable {
    private int menuID;
    private int receiptID;

    public ReceiptDetailID(int menu, int receipt) {
        this.menuID = menu;
        this.receiptID = receipt;
    }


}
