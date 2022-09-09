package com.codegym.model.facility;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kieu_thue")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_kieu_thue")
    private Integer rentTypeId;
    @Column(name = "ten_kieu_thue")
    private String rentTypeName;

    @OneToMany(mappedBy = "rentType")
    private List<Facility> rentTypeList;

    public RentType() {
    }

    public RentType(Integer rentTypeId, String rentTypeName) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }
}
