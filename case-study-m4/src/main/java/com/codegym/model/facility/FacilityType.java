package com.codegym.model.facility;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_dich_vu")
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_dich_vu")
    private Integer facilityTypeId;
    @Column(name = "ten_loai_dich_vu")
    private String facilityTypeName;

    @OneToMany(mappedBy = "facilityType")
    private List<Facility> facilityTypeList;

    public FacilityType() {
    }

    public FacilityType(Integer facilityTypeId, String facilityTypeName, List<Facility> facilityTypeList) {
        this.facilityTypeId = facilityTypeId;
        this.facilityTypeName = facilityTypeName;
        this.facilityTypeList = facilityTypeList;
    }

    public Integer getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(Integer facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
        this.facilityTypeName = facilityTypeName;
    }

    public List<Facility> getFacilityTypeList() {
        return facilityTypeList;
    }

    public void setFacilityTypeList(List<Facility> facilityTypeList) {
        this.facilityTypeList = facilityTypeList;
    }

}
