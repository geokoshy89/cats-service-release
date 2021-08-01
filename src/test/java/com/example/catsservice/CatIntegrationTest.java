package com.example.catsservice;

import org.assertj.core.api.Assertions;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(properties="spring.sql.init.mode=always",webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class CatIntegrationTest {
    @Container
    static PostgreSQLContainer db=new PostgreSQLContainer("postgres");

    @Autowired
    TestRestTemplate testRestTemplate;
    @DynamicPropertySource
    static void dynamicPropertyRegistry(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url",()->db.getJdbcUrl());
        registry.add("spring.datasource.username",()->db.getUsername());
        registry.add("spring.datasource.password",()->db.getPassword());
        registry.add("spring.jpa.database-platform", PostgreSQL9Dialect.class::getName);
    }

    @Test
    void getCatByName() {
        Cats toby = testRestTemplate.getForObject("/cats/{name}", Cats.class, "Toby");
        Assertions.assertThat(toby.getName().equals("toby"));
    }
}
