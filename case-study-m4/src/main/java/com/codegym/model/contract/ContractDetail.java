package com.codegym.model.contract;

import javax.persistence.*;

@Entity
@Table(name = "hop_dong_chi_tiet")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong_chi_tiet")
    private Integer contractDetailId;

    @Column(name = "so_luong")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "ma_hop_dong", referencedColumnName = "ma_hop_dong")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu_di_kem", referencedColumnName = "ma_dich_vu_di_kem")
    private AttachFacility attachFacility;

    public ContractDetail() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

}
