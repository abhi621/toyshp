package com.example.toyshop;

import com.example.toyshop.checker.ToyChecker;
import com.example.toyshop.controller.ToyController;
import com.example.toyshop.model.entity.ToyEntity;
import com.example.toyshop.model.enums.AgeGroup;
import com.example.toyshop.model.enums.ToyType;
import com.example.toyshop.service.ToyService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ToyShopControllerTest {

    private ToyService toyService = Mockito.mock(ToyService.class);
    private ToyChecker toyChecker = Mockito.mock(ToyChecker.class);

    @InjectMocks
    private ToyController toyController;

    @Before
    public void before() {
        RestAssuredMockMvc.standaloneSetup(toyController);
    }

    @Test
    public void getToysTest() {
        Optional<List<ToyEntity>> expectedToyList = Optional.of(Collections.singletonList(new ToyEntity(1l, "toy1", ToyType.ACTION, 150d, AgeGroup.TODDLER)));

        BDDMockito.given(toyService.getToyList(any(), any(), any()))
                .willReturn(expectedToyList);

        RestAssuredMockMvc.given()
                .queryParam("higherRange", "1000")
                .queryParam("lowerRange", "100")
                .queryParam("ageGroup", AgeGroup.TODDLER)
                .get("/api/v1/toy")
                .then()
                .status(HttpStatus.OK);
    }
}
