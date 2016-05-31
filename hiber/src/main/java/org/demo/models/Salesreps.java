package org.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
@Table(name = "SALESREPS")
public class Salesreps implements Serializable {
    @Id
    @Column(name ="EMPL_NUM")
    @ManyToOne
    @JoinColumn(name = "REP")
    private int empl_num;
    @Column(name ="REP_OFFICE")
    @OneToMany(mappedBy = "OFFICE")
    private Office rep_office;
    @Column(name ="MANAGER")
    @ManyToOne
    @JoinColumn(name = "EMPL_NUM")
    private Manager manager;
    @Column(name ="NAME")
    private String name;
    @Column(name ="TITLE")
    private String title;
    @Column(name ="AGE")
    private int age;
    @Column(name ="HIRE_DATE")
    private Date hire_date;
    @Column(name ="QUOTA")
    private BigDecimal quota;
    @Column(name ="SALES")
    private BigDecimal sales;

//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getEmpl_num() {
//        return empl_num;
//    }
//
//    public void setEmpl_num(int empl_num) {
//        this.empl_num = empl_num;
//    }
//
//    public Date getHire_date() {
//        return hire_date;
//    }
//
//    public void setHire_date(Date hire_date) {
//        this.hire_date = hire_date;
//    }
//
//    public int getManager() {
//        return manager;
//    }
//
//    public void setManager(int manager) {
//        this.manager = manager;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public BigDecimal getQuota() {
//        return quota;
//    }
//
//    public void setQuota(BigDecimal quota) {
//        this.quota = quota;
//    }
//
//    public int getRep_office() {
//        return rep_office;
//    }
//
//    public void setRep_office(int rep_office) {
//        this.rep_office = rep_office;
//    }
//
//    public BigDecimal getSales() {
//        return sales;
//    }
//
//    public void setSales(BigDecimal sales) {
//        this.sales = sales;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Salesreps(int age, int empl_num, Date hire_date, int manager, String name, BigDecimal quota, int rep_office, BigDecimal sales, String title) {
//
//        this.age = age;
//        this.empl_num = empl_num;
//        this.hire_date = hire_date;
//        this.manager = manager;
//        this.name = name;
//        this.quota = quota;
//        this.rep_office = rep_office;
//        this.sales = sales;
//        this.title = title;
//    }
//
//    public Salesreps() {
//    }
}

