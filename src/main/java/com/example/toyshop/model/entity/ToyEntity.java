package com.example.toyshop.model.entity;


import com.example.toyshop.model.enums.AgeGroup;
import com.example.toyshop.model.enums.ToyType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "toy")
@NoArgsConstructor
@AllArgsConstructor
public class ToyEntity {

    @Id
    @Column(name = "toy_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "toy_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "toyType")
    private ToyType toyType;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_range")
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

    @Override
    public String toString() {
        return "ToyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", toyType='" + toyType + '\'' +
                ", price='" + price + '\'' +
                ", ageRange='" + ageGroup + '\'' +
                '}';
    }
}
