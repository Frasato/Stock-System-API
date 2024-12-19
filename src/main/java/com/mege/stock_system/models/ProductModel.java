package com.mege.stock_system.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer barCode;
    private String name;
    private String mark;
    private int quantity;
    private LocalDateTime entryDate;
    private LocalDateTime additionDate;
    private String type;

    public ProductModel(String id, Integer barCode, String name, String mark, int quantity, LocalDateTime entryDate, LocalDateTime additionDate, String type) {
        this.id = id;
        this.barCode = barCode;
        this.name = name;
        this.mark = mark;
        this.quantity = quantity;
        this.entryDate = entryDate;
        this.additionDate = additionDate;
        this.type = type;
    }

    public ProductModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBarCode() {
        return barCode;
    }

    public void setBarCode(Integer barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getAdditionDate() {
        return additionDate;
    }

    public void setAdditionDate(LocalDateTime additionDate) {
        this.additionDate = additionDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
