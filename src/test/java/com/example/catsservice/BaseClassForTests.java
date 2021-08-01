package com.example.catsservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

@SpringBootTest
public class BaseClassForTests {
    @MockBean
    CatRepository catRepository;
    @BeforeEach
    void setUp(){
        Cats toby = new Cats("Toby", LocalDate.now().minusMonths(4));
        Mockito.when(catRepository.findByName("Toby"))
                .thenReturn(toby);
        RestAssuredMockMvc.standaloneSetup(new CatController(catRepository));
    }
}
