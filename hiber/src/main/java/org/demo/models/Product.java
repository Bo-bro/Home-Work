package org.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {
    @Id
  // private ProductPK productPK;
    @Column(name = "MFR_ID",columnDefinition="CHAR_ARRAY")

    private String mfr_id;
    @Id
    @Column(name = "PRODUCT_ID",columnDefinition="varchar")

    private String product_id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QTY_ON_HAND")
    private Integer qty_on_hand;

    @OneToMany(mappedBy = "PRODUCT")
    Set<Order> orders = new LinkedHashSet<Order>();


//    public String getProductPKMfr_id() {
//        return productPK.getMfr_id();
//    }
//    public String getProductPKProduct_id() {
//        return productPK.getProduct_id();
//    }
//
//    public ProductPK getProductPK() {
//        return productPK;
//    }
//
//    public void setProductPK(ProductPK productPK) {
//        this.productPK = productPK;
//    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//
//    public int getQty_on_hand() {
//        return qty_on_hand;
//    }
//
//    public void setQty_on_hand(int qty_on_hand) {
//        this.qty_on_hand = qty_on_hand;
//    }
//
//    public String getMfr_id() {
//        return mfr_id;
//    }
//
//    public void setMfr_id(String mfr_id) {
//        this.mfr_id = mfr_id;
//    }
//
//    public String getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(String product_id) {
//        this.product_id = product_id;
//    }
//
//    public Product(String description, Set<Order> orders, BigDecimal price, Integer qty_on_hand) {
//        this.description = description;
//        this.orders = orders;
//        this.price = price;
//       // setProductPK(productPK);
//        this.qty_on_hand = qty_on_hand;
//    }
//
//    public Product() {
//    }
}
