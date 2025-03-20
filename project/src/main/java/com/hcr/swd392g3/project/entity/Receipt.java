package com.hcr.swd392g3.project.entity;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Receipt")
public class Receipt {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receiptID;

    @ManyToOne
    @JoinColumn(name = "tableID")
    private com.hcr.swd392g3.project.entity.Table table;

    @Column(name = "BookingHour")
    private Date bookingHour;

    @ManyToOne
    @JoinColumn(name = "employeeID")
    private Employee employee;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "Demand")
    private boolean demand;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    private List<ReceiptDetail> receiptDetailList;

    public int getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public com.hcr.swd392g3.project.entity.Table getTable() {
        return table;
    }

    public void setTable(com.hcr.swd392g3.project.entity.Table table) {
        this.table = table;
    }

    public Date getBookingHour() {
        return bookingHour;
    }

    public void setBookingHour(Date bookingHour) {
        this.bookingHour = bookingHour;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDemand() {
        return demand;
    }

    public void setDemand(boolean demand) {
        this.demand = demand;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ReceiptDetail> getReceiptDetailList() {
        return receiptDetailList;
    }

    public void setReceiptDetailList(List<ReceiptDetail> receiptDetailList) {
        this.receiptDetailList = receiptDetailList;
    }
}
