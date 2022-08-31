package com.codegym.model.facility;

import javax.persistence.*;

@Entity
@Table(name = "kieu_thue")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_kieu_thue")
    private Integer rentTypeId;
    @Column(name = "ten_kieu_thue")
    private String rentTypeName;
    
}
