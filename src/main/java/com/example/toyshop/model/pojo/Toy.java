package com.example.toyshop.model.pojo;

import com.example.toyshop.model.enums.AgeGroup;
import com.example.toyshop.model.enums.ToyType;

import javax.validation.constraints.NotBlank;

public class Toy {

    private Long id;

    @NotBlank(message = "Name cannot be null/empty")
    private String name;

    @NotBlank(message = "ToyType can not be null/empty")
    private ToyType toyType;

    private Double price;

    private AgeGroup ageGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToyType getToyType() {
        return toyType;
    }

    public void setToyType(ToyType toyType) {
        this.toyType = toyType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }
}
