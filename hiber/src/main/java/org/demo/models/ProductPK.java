//package org.demo.models;
//
//import javax.persistence.Column;
//import java.io.Serializable;
//
////неявные гетеры, сетеры , кнструтор  и прочее
////@Data
//public class ProductPK implements Serializable {
//
//
//    @Column(name = "MFR_ID",columnDefinition="char")
//    // @Nationalized
//    private String mfr_id = null;
//    @Column(name = "PRODUCT_ID",columnDefinition="char")
//    // @Nationalized
//    private String product_id;
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
//    public ProductPK() {
//    }
//
//    public ProductPK(String mfr_id, String product_id) {
//        this.mfr_id = mfr_id;
//        this.product_id = product_id;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        ProductPK productPK = (ProductPK) o;
//
//        if (!mfr_id.equals(productPK.mfr_id)) return false;
//        return product_id.equals(productPK.product_id);
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = mfr_id.hashCode();
//        result = 31 * result + product_id.hashCode();
//        return result;
//    }
//}
