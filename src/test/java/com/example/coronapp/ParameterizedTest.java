package com.example.coronapp;

import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ParameterizedTest {

    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void testParametreAvecValueSource(int valeur) {
        assertThat(valeur + valeur).isEqualTo(valeur * 2);
    }
}
