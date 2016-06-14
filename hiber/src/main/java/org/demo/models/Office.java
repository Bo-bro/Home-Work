//package org.demo.models;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigDecimal;
//
//@Data
//@Entity
//@Table(name = "OFFICES")
//public class Office implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "OFFICE")
//    @ManyToOne
//    @JoinColumn(name =("REP_OFFICE"))
//    private int id;
//    @Column(name = "CITY")
//    private String city;
//    @Column(name = "REGION")
//    private String region;
//    @OneToMany(mappedBy = "EMPL_NUM")
//    @Column(name = "MGR")
//    private Salesreps mgr;
//    @Column(name = "TARGET")
//    private BigDecimal target;
//    @Column(name = "SALES")
//    private BigDecimal sales;
//
////    public int getId() {
////        return id;
////    }
////
////    public void setId(int id) {
////        this.id = id;
////    }
////
////    public String getCity() {
////        return city;
////    }
////
////    public void setCity(String city) {
////        this.city = city;
////    }
////
////    public String getRegion() {
////        return region;
////    }
////
////    public void setRegion(String region) {
////        this.region = region;
////    }
////
////    public Manager getManager() {
////        return manager;
////    }
////
////    public void setManager(Manager manager) {
////        this.manager = manager;
////    }
////    public Office(String city, int id, String region, Manager manager) {
////        this.city = city;
////        this.id = id;
////        this.region = region;
////        this.manager= manager;
////    }
////
////    public Office() {
////    }
//}
