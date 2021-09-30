package com.example.toyshop.service;

import com.example.toyshop.exception.ToyShopCustomException;
import com.example.toyshop.mapper.ToyMapper;
import com.example.toyshop.model.entity.ToyEntity;
import com.example.toyshop.model.enums.AgeGroup;
import com.example.toyshop.model.pojo.Toy;
import com.example.toyshop.repository.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToyService {

    private final ToyRepository toyRepository;

    public Optional<List<ToyEntity>> getToyList(Optional<String> high, Optional<String> low, Optional<AgeGroup> ageGroup) {

        if ((high.isEmpty() || low.isEmpty()) && ageGroup.isEmpty()) {
            return Optional.ofNullable(toyRepository.findAll());
        } else if (high.isEmpty() || low.isEmpty()) {
            return toyRepository.findByAgeGroupOrderByPriceAsc(ageGroup.get());
        } else if (ageGroup.isEmpty()) {
            return toyRepository.findByPriceLessThanEqualAndPriceGreaterThanOrderByPriceAsc(Double.valueOf(low.get()), Double.valueOf(high.get()));
        } else {
            return toyRepository.findByAgeGroupAndPriceLessThanEqualAndPriceGreaterThanOrderByPriceAsc(ageGroup.get(), Double.valueOf(high.get()), Double.valueOf(low.get()));
        }
    }

    public Toy createToy(Toy toy) throws ToyShopCustomException {
        ToyEntity toyEntity = ToyMapper.mapToToyEntity(toy);
        toyEntity = toyRepository.save(toyEntity);
        return ToyMapper.mapToToyObject(toyEntity);
    }
}
