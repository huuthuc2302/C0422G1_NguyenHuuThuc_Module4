package com.codegym.model.facility;

import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dich_vu")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu")
    private Integer facilityId;

    @Column(name = "ten_dich_vu")
    private String facilityName;

    @Column(name = "dien_tich")
    private Integer facilityArea;

    @Column(name = "chi_phi_thue")
    private Double facilityCost;

    @Column(name = "so_nguoi_toi_da ")
    private Integer facilityMaxPeople;

    @Column(name = "tieu_chuan_phong")
    private String standardRoom;

    @Column(name = "mo_ta_tien_nghi_khac")
    private String description;

    @Column(name = "dien_tich_ho_boi")
    private Double poolArea;

    @Column(name = "so_tang")
    private Integer numberOfFloor;

    @Column(name = "dich_vu_mien_phi_di_kem")
    private String facilityFree;

    @ManyToOne
    @JoinColumn(name = "ma_loai_dich_vu", referencedColumnName = "ma_loai_dich_vu")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "ma_kieu_thue", referencedColumnName = "ma_kieu_thue")
    private RentType rentType;

    @OneToMany(mappedBy = "facility")
    private List<Contract> contractList;

    public Facility() {
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Integer getFacilityArea() {
        return facilityArea;
    }

    public void setFacilityArea(Integer facilityArea) {
        this.facilityArea = facilityArea;
    }

    public Double getFacilityCost() {
        return facilityCost;
    }

    public void setFacilityCost(Double facilityCost) {
        this.facilityCost = facilityCost;
    }

    public Integer getFacilityMaxPeople() {
        return facilityMaxPeople;
    }

    public void setFacilityMaxPeople(Integer facilityMaxPeople) {
        this.facilityMaxPeople = facilityMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
