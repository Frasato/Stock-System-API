package com.mege.stock_system.models;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers")
public class SupplierModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer cnpj;
    private Integer phoneNumber;
    private String address;
    private String city;
    private String state;
    private Integer cep;
    private String stateRegistration;
    private String supplierType;

    public SupplierModel(String id, Integer cnpj, Integer phoneNumber, String address, String city, String state, Integer cep, String stateRegistration, String supplierType) {
        this.id = id;
        this.cnpj = cnpj;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.cep = cep;
        this.stateRegistration = stateRegistration;
        this.supplierType = supplierType;
    }

    public SupplierModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }
}
