package com.example.catsservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * We can use data jpa test slice for testing data layer only from spring
 */
@DataJpaTest
class CatJpaTests {
    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    CatRepository catRepository;

    @Test
    void catCanBePersisted() {
        Assertions.assertThatNoException().isThrownBy(()->this.testEntityManager.persist(new Cats("Toby")));
    }

    @Test
    void findByNameReturnsCat() {
        this.catRepository.save(new Cats("Toby"));
        Assertions.assertThat(this.catRepository.findByName("Toby").getName())
        .isEqualTo("Toby");
    }
}
