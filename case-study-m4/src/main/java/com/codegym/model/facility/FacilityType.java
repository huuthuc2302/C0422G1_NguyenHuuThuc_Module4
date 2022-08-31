package com.codegym.model.facility;

import javax.persistence.*;

@Entity
@Table(name = "loai_dich_vu")
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_dich_vu")
    private Integer facilityTypeId;
    @Column(name = "ten_loai_dich_vu")
    private String facilityTypeName;
}
