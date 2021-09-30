package com.example.toyshop.repository;

import com.example.toyshop.model.entity.ToyEntity;
import com.example.toyshop.model.enums.AgeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToyRepository extends JpaRepository<ToyEntity, Long> {

    Optional<ToyEntity> findByIdOrderByIdDesc(Long id);

    Optional<List<ToyEntity>> findByAgeGroupOrderByPriceAsc(AgeGroup ageGroup);

    Optional<List<ToyEntity>> findByAgeGroupAndPriceLessThanEqualAndPriceGreaterThanOrderByPriceAsc(AgeGroup ageGroup, Double high, Double low);

    Optional<List<ToyEntity>> findByPriceLessThanEqualAndPriceGreaterThanOrderByPriceAsc(Double high, Double low);
}
