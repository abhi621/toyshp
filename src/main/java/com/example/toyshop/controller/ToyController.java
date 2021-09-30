package com.example.toyshop.controller;

import com.example.toyshop.checker.ToyChecker;
import com.example.toyshop.exception.ToyShopCustomException;
import com.example.toyshop.model.entity.ToyEntity;
import com.example.toyshop.model.enums.AgeGroup;
import com.example.toyshop.model.pojo.Toy;
import com.example.toyshop.service.ToyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/toy")
@RequiredArgsConstructor
public class ToyController {

    private final ToyService service;
    private final ToyChecker toyChecker;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Toy createToy(@RequestBody @Valid Toy toy) throws ToyShopCustomException {
        toyChecker.checkForCreate(toy);
        try {
            return service.createToy(toy);
        } catch (ToyShopCustomException ex) {
            throw new ToyShopCustomException(ex.getMessage(), ex.getErrorCode());
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ToyEntity> getToys(@RequestParam Optional<String> higherRange, @RequestParam Optional<String> lowerRange,
                                   @RequestParam Optional<AgeGroup> ageGroup) throws ToyShopCustomException {
        Optional<List<ToyEntity>> list = service.getToyList(higherRange, lowerRange, ageGroup);
        return list.orElseThrow(() -> new ToyShopCustomException("ToyList is Empty"));
    }
}
