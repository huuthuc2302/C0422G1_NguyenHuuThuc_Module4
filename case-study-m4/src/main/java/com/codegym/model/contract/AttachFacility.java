package com.codegym.model.contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dich_vu_di_kem")
public class AttachFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu_di_kem")
    private Integer attachFacilityId;

    @Column(name = "ten_dich_vu_di_kem")
    private String attachFacilityName;

    @Column(name = "gia")
    private Double cost;

    @Column(name = "don_vi")
    private String unit;

    @Column(name = "trang_thai")
    private String status;

    @OneToMany(mappedBy = "attachFacility")
    private List<ContractDetail> contractDetailList;

    public AttachFacility() {
    }

    public Integer getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(Integer attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }

    public String getAttachFacilityName() {
        return attachFacilityName;
    }

    public void setAttachFacilityName(String attachFacilityName) {
        this.attachFacilityName = attachFacilityName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
