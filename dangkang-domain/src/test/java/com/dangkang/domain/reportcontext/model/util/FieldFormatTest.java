package com.dangkang.domain.reportcontext.model.util;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class FieldFormatTest {
    @DisplayName("rightFormat方法正确性测试")
    @Test
    public void shouldRightFillFormat(){
        assertEquals("fang",FieldFormat.rightFillFormat("fang",4));
        assertEquals("fang ",FieldFormat.rightFillFormat("fang",5));
        assertEquals("fang  ",FieldFormat.rightFillFormat("fang",6));
        assertEquals("    ",FieldFormat.rightFillFormat("",4));
        assertEquals("",FieldFormat.rightFillFormat("",0));
        //assertEquals(" ",FieldFormat.rightFillFormat(" ",0));
    }

    @DisplayName("rightFormat方法异常测试")
    @Test
    public void shouldThrowExceptionRightFormat(){
        Assertions.assertThrows(AssertionError.class, () -> {
            FieldFormat.rightFillFormat("fang",3);
        });
        Assertions.assertThrows(AssertionError.class, () -> {
            FieldFormat.rightFillFormat(null,3);
        });
        Assertions.assertThrows(AssertionError.class, () -> {
            FieldFormat.rightFillFormat(" ",0);
        });
    }
    @DisplayName("Long类型的leftFillFormat方法正确性单元测试")
    @ParameterizedTest
    @CsvSource({
            "900, 3,900",
            "900 , 4,0900",
            "900 , 5, 00900",
            "0,5,00000",
            "90000,4,90000",
    })
    public void shouldLeftFillFormat(Long field, int requiredLength,String expected){
        assertEquals(expected,FieldFormat.leftFillFormat(field,requiredLength));
    }

   @DisplayName("Double类型的leftFillFormat方法正确性单元测试")
    @ParameterizedTest
    @CsvSource({
            "900.01, 5,90001,2",
            "900.01 , 7,0090001,2",
            "900.02 , 6, 090002,2",
            "900.02 , 6, 900020,3",
            "900.02 , 6, 9000200,4",
            "900,6,090000,2",
    })
    public void shouldLeftFillFormat(Double field, int requiredLength,String expected,int dotLength){
        assertEquals(expected,FieldFormat.leftFillFormat(field,requiredLength,dotLength));
    }
    @DisplayName("Double类型的leftFillFormat方法异常单元测试")
    @ParameterizedTest
    @CsvSource({
            "900.02 , 6, 900020,4",
    })
    public void shouldNotLeftFillFormat(Double field, int requiredLength,String expected,int dotLength){
       assertNotEquals(expected,FieldFormat.leftFillFormat(field,requiredLength,dotLength));
    }
}
