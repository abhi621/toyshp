package com.example.toyshop.mapper;

import com.example.toyshop.model.entity.ToyEntity;
import com.example.toyshop.model.pojo.Toy;

public class ToyMapper {

    public static ToyEntity mapToToyEntity(Toy toy) {
        ToyEntity toyEntity = new ToyEntity();
        toyEntity.setId(toy.getId());
        toyEntity.setName(toy.getName());
        toyEntity.setToyType(toy.getToyType());
        toyEntity.setPrice(toy.getPrice());
        toyEntity.setAgeGroup(toy.getAgeGroup());
        return toyEntity;
    }

    public static Toy mapToToyObject(ToyEntity toyEntity) {
        Toy toy = new Toy();
        toy.setId(toyEntity.getId());
        toy.setName(toyEntity.getName());
        toy.setToyType(toyEntity.getToyType());
        toy.setPrice(toyEntity.getPrice());
        toy.setAgeGroup(toyEntity.getAgeGroup());
        return toy;
    }
}