package org.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "CUST")
    @Column(name = "CUST_NUM")
    private int id;
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "CUST_REP")
    @OneToMany(mappedBy ="EMPL_NUM")
    private Salesreps cust_rep;
    @Column(name = "CREDIT_LIMIT")
    private BigDecimal credit_limit;
//
//    public String getCompany() {
//        return company;
//    }
//
//    public void setCompany(String company) {
//        this.company = company;
//    }
//
//    public BigDecimal getCredit_limit() {
//        return credit_limit;
//    }
//
//    public void setCredit_limit(BigDecimal credit_limit) {
//        this.credit_limit = credit_limit;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
////    public int getCust_rep() {
////        return cust_rep;
////    }
//
////    public void setCust_rep(int cust_rep) {
////        this.cust_rep = cust_rep;
////    }
//
//    public Customer(String company, BigDecimal credit_limit, int cust_num/*, int cust_rep*/) {
//        this.company = company;
//        this.credit_limit = credit_limit;
//        this.id = cust_num;
//        //  this.cust_rep = cust_rep;
//    }
//
//    public Customer() {
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "company='" + company + '\'' +
//                ", id=" + id +
//                ", credit_limit=" + credit_limit +
//                '}';
//    }
}
