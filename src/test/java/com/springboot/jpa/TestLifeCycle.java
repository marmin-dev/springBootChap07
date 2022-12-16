package com.springboot.jpa;


import org.junit.jupiter.api.*;

public class TestLifeCycle {
    @BeforeAll
    static void beforeAll(){
        System.out.println("##BeforeAll");
        System.out.println();
    }
    @AfterAll
    static void afterAll(){
        System.out.println("##AfterAll");
        System.out.println();
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("##BeforeEach");
        System.out.println();
    }
    @AfterEach
    void afterEach(){
        System.out.println("##AfterEach");
        System.out.println();
    }
    @Test
    void test1(){
        System.out.println("test1 start");
        System.out.println();
    }
    @Test
    void test2(){
        System.out.println("test2 start");
        System.out.println();
    }
    @Test
    @Disabled
    void test3(){
        System.out.println("Test3 start");
        System.out.println();
    }
}
