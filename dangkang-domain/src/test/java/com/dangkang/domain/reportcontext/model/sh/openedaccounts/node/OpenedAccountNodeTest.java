package com.dangkang.domain.reportcontext.model.sh.openedaccounts.node;

import com.dangkang.domain.reportcontext.model.sh.openedaccounts.field.EscrowAccountField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OpenedAccountNodeTest {

    @Test
    void format() {
    }
    @DisplayName("EscrowAccountField.format方法正确性单元测试")
   @Test
    public void shouldGetRightEscrowAccountField(){
        String expected="93                ";//长度为18
        assertEquals(expected,new EscrowAccountField("93").format());
        assertEquals(expected,new EscrowAccountField("93 ").format());
        assertEquals(expected,new EscrowAccountField(expected).format());

        String blank18Length="                  ";//长度为18
        assertEquals(blank18Length,new EscrowAccountField("").format());

        String str18Length="123456789012345678";
        assertEquals(str18Length,new EscrowAccountField(str18Length).format());

        String chinese18Length="中国                ";
        assertEquals(chinese18Length,new EscrowAccountField("中国").format());
    }
}