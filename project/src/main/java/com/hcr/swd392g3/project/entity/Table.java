package com.hcr.swd392g3.project.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@javax.persistence.Table(name = "Tablee")
public class Table {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableID;

    @NotNull(message = "Please enter chairNumber")
    @Column(name = "ChairNumber")
    private int chairNumber;

    @NotNull(message = "Please enter floorNo")
    @Column(name = "FloorNo")
    private int floorNo;

    @NotNull(message = "Please enter privacy")
    @Column(name = "Privacy")
    private String privacy;

    @Column(name = "Status")
    private int status;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL)
    private List<Receipt> receipts;


    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

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
