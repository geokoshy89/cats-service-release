package com.example.catsservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

/**
 * Anther test slicefrom spring boot webmvctest
 */
@WebMvcTest
public class CatControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CatRepository catRepository;
    @Test
    void getCatWithNameShouldReturnCat() throws Exception {
        Cats toby = new Cats("Toby", LocalDate.now());
        BDDMockito.given(catRepository.findByName("Toby")).willReturn(toby);
        mockMvc.perform(MockMvcRequestBuilders.get("/cats/{name}", "Toby"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(toby)));

    }
}
