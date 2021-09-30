package com.example.toyshop.checker;

import com.example.toyshop.exception.ToyShopCustomException;
import com.example.toyshop.model.enums.AgeGroup;
import com.example.toyshop.model.pojo.Toy;
import org.springframework.stereotype.Component;

@Component
public class ToyChecker {

    public void checkForCreate(Toy toy) throws ToyShopCustomException {

        if (toy.getId() != null) {
            throw new ToyShopCustomException("Id attribute must be null");
        }
        if (toy.getName() == null) {
            throw new ToyShopCustomException("Name cannot be empty");
        }
        if (toy.getToyType() == null) {
            throw new ToyShopCustomException("Name cannot be empty");
        }
        if (toy.getPrice() == null) {
            throw new ToyShopCustomException("Name cannot be empty");
        }
        if (toy.getPrice() == null) {
            throw new ToyShopCustomException("Name cannot be empty");
        }
        if (toy.getAgeGroup() == null) {
            throw new ToyShopCustomException("AgeGroup cannot be empty");
        }
        if (toy.getAgeGroup() != AgeGroup.TODDLER && toy.getAgeGroup() != AgeGroup.PRESCHOOLER && toy.getAgeGroup() != AgeGroup.CHILD) {
            throw new ToyShopCustomException("Age group is from" + AgeGroup.TODDLER + ", " + AgeGroup.PRESCHOOLER + ", " + AgeGroup.CHILD + "this list only");
        }
    }

}
