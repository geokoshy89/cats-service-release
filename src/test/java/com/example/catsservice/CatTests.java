package com.example.catsservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CatTests {
    @Test
    void catWithLowerCaseNameShouldThrowException(){
        Assertions.assertThatIllegalArgumentException().isThrownBy(()->new Cats("tom"));
    }

    @Test
    void getAgeInMonths() {
        Cats paprika=new Cats("Paprika", LocalDate.now().minusMonths(9));
        Assertions.assertThat(paprika.getAgeInMonths()).isEqualTo(9);

    }
}
