package com.codegym.dto;

import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {


    private Integer facilityId;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^([0-9A-Z][\\w]*)+( [0-9A-Z][\\w]*)*$",
            message = "Tên dịch vụ được phép chứa số.Và các kí tự đầu tiên của mỗi từ phải viết hoa")
    private String facilityName;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Diện tích phải là số dương")
    private Integer facilityArea;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Giá phải là số dương")
    private Double facilityCost;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Số người phải là số dương")
    private Integer facilityMaxPeople;

    @NotNull(message = "Không được để trống")
    private String standardRoom;

    private String description;

    @Min(value = 0, message = "Diện tích phải là số dương")
    private Double poolArea;

    @Min(value = 0, message = "Số tầng phải là số dương")
    private Integer numberOfFloor;

    private String facilityFree;

    private FacilityType facilityType;

    private RentType rentType;

    public FacilityDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
