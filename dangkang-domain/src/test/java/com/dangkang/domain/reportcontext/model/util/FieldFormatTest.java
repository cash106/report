package com.dangkang.domain.reportcontext.model.util;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class FieldFormatTest {

    @Test
    public void shouldRightFillFormat(){
        assertEquals("fang",FieldFormat.rightFillFormat("fang",4));
        assertEquals("fang ",FieldFormat.rightFillFormat("fang",5));
        assertEquals("fang  ",FieldFormat.rightFillFormat("fang",6));
    }

    @Test
    public void shouldThrowExceptionRightFormat(){
        Assertions.assertThrows(AssertionError.class, () -> {
            FieldFormat.rightFillFormat("fang",3);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "900, 3,900",
            "900 , 4,0900",
            "900 , 5, 00900"
    })
    public void shouldLeftFillFormat(Long field, int requiredLength,String expected){
        assertEquals(expected,FieldFormat.leftFillFormat(field,requiredLength));
    }

    @ParameterizedTest
    @CsvSource({
            "900.01, 5,90001,2",
            "900.01 , 7,0090001,2",
            "900.02 , 6, 090002,2",
            "900.02 , 6, 900020,3",
            "900.02 , 6, 900020,4",
    })
    public void shouldLeftFillFormat(Double field, int requiredLength,String expected,int dotLength){
        assertEquals(expected,FieldFormat.leftFillFormat(field,requiredLength,dotLength));
    }
}
