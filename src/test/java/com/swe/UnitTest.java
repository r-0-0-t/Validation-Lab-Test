package com.swe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("This method was invoked before all.");
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("This method is invoked after Each method.");
    }

    @Test
    public void listTest() {
        List<String> list = Arrays.asList("16batch","16batch","16batch","16batch","16batch","16batch");

        for(int i=0;i<list.size();++i) {
            assertEquals("16batch",list.get(i));
        }
    }

    @ParameterizedTest(name = "Parameterized Test")
    @ValueSource(strings = {"a","A"} )
    public void parameterizedTest(String str) {
        assertEquals(str,str.toUpperCase());
    }

    @ParameterizedTest(name = "{0},{1} Test Case")
    @CsvSource(value = {"abc,ABC","def,DEF"})
    public void csvTest(String a,String b) {
        assertEquals(a,b.toLowerCase());
    }
}