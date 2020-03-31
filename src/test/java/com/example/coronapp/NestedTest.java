package com.example.coronapp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class NestedTest {


    @BeforeEach
    void beforEach() {
        log.info("beforeEach");
    }

    @AfterEach
    void afterEach() {
        log.info("afterEach");
    }


    @Test
    void test1() {
        log.info("test1");
        Assertions.assertTrue(true);
    }

    @Nested
    class TestImbrique {
        @BeforeEach
        void beforEach() {
            log.info("before Each Test Imbrique");
        }

        @Test
        void testImbrique1() {
            log.info("testImbrique1");
            Assertions.assertTrue(true);
        }

        @Test
        void testImbrique2() {
            log.info("testImbrique2");
            Assertions.assertTrue(true);
        }

    }

}
