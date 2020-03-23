package com.example.coronapp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LifeCycle {


    @BeforeAll
    static void beforeAll() {
      log.info("beforeAll");
    }

    @BeforeEach
    void beforEach() {
      log.info("beforeEach");
    }

    @AfterEach
    void afterEach() {
      log.info("afterEach");
    }

    @AfterAll
    static void afterAll() {
      log.info("afterAll");
    }

    @Test
    void test1() {
      log.info("test1");
      Assertions.assertTrue(true);
    }

    @Test
    void test2() {
      log.info("test2");
      Assertions.assertTrue(true);
    }

}
