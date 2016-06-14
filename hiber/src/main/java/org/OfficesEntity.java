package org;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offices", schema = "testdb", catalog = "")
public class OfficesEntity {
    private int office;
    private String city;
    private String region;
    private BigDecimal target;
    private BigDecimal sales;

    @Id
    @Column(name = "OFFICE")
    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "REGION")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "TARGET")
    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    @Basic
    @Column(name = "SALES")
    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfficesEntity that = (OfficesEntity) o;

        if (office != that.office) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;
        if (sales != null ? !sales.equals(that.sales) : that.sales != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = office;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (sales != null ? sales.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OfficesEntity{" +
                "office=" + office +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", target=" + target +
                ", sales=" + sales +
                '}';
    }
}
