//package org.demo.models;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.sql.Date;
//@Data
//@Entity
//@Table(name = "ORDERS")
//public class Order implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ORDER_NUM")
//    private int id;
//    @Column(name = "CUST")
////    @OneToMany(mappedBy = "CUST_NUM")
//    @ManyToOne
//    @JoinColumn(name = "CUST")
//    private Customer cust;
//    @Column(name = "REP")
//    @OneToMany(mappedBy = "EMPL_NUM")
//    private Salesreps rep;
//    @Column(name = "MFR")
//    @OneToOne(mappedBy = "MFR_ID")
//    private String mfr;
//    @Column(name = "PRODUCT")
//    @OneToOne(mappedBy = "PRODUCT_ID")
//    private String product;
//    @Column(name = "ORDER_DATE")
//    private Date order_date;
//    @Column(name = "QTY")
//    private int qty;
//    @Column(name = "AMOUNT")
//    private BigDecimal amount;
//}
////
////    public BigDecimal getAmount() {
////        return amount;
////    }
////
////    public void setAmount(BigDecimal amount) {
////        this.amount = amount;
////    }
////
////    public int getCust() {
////        return cust;
////    }
////
////    public void setCust(int cust) {
////        this.cust = cust;
////    }
////
////    public char getMfr() {
////        return mfr;
////    }
////
////    public void setMfr(char mfr) {
////        this.mfr = mfr;
////    }
////
////    public Date getOrder_date() {
////        return order_date;
////    }
////
////    public void setOrder_date(Date order_date) {
////        this.order_date = order_date;
////    }
////
////    public int getId() {
////        return id;
////    }
////
////    public void setId(int id) {
////        this.id = id;
////    }
////
////    public char getProduct() {
////        return product;
////    }
////
////    public void setProduct(char product) {
////        this.product = product;
////    }
////
////    public int getQty() {
////        return qty;
////    }
////
////    public void setQty(int qty) {
////        this.qty = qty;
////    }
////
////    public int getRep() {
////        return rep;
////    }
////
////    public void setRep(int rep) {
////        this.rep = rep;
////    }
////
////    public Order(BigDecimal amount, int cust, char mfr, Date order_date, int id, char product, int qty, int rep) {
////        this.amount = amount;
////        this.cust = cust;
////        this.mfr = mfr;
////        this.order_date = order_date;
////        this.id = id;
////        this.product = product;
////        this.qty = qty;
////        this.rep = rep;
////    }
////
////    public Order() {
////    }
////
////    @Override
////    public String toString() {
////        return "Order{" +
////                "amount=" + amount +
////                ", id=" + id +
////                ", cust=" + cust +
////                ", rep=" + rep +
////                ", mfr='" + mfr + '\'' +
////                ", product='" + product + '\'' +
////                ", order_date=" + order_date +
////                ", qty=" + qty +
////                '}';
////    }
////}
