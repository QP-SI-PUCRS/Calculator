package com.bcopstein.ExpressionCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExpressionTest {

	@Test
	void simpleExpressionTest() {
        int rCalc = Expression.evaluate("3+5");
        assertEquals(8,rCalc);
	}
	
	@DisplayName("Testa diferentes expressões válidas")
	@ParameterizedTest
	@CsvSource({ "3,3","-3,-3","+3,3",
		         "3+4, 7", "-3+4, 1", "+3+4, 7",
		         "3+4+5, 12", "3-4-5, -6", "3+4-5, 2",
		         "100+543-43, 600", "-200+1576-300, 1076",
		         "-1000+500+2076-76-500+10987, 11987"
		       })
    void expressionTest(String expr,int rEsp) {
        int rCalc = Expression.evaluate(expr);
        assertEquals(rEsp,rCalc);		
	}
	
	@DisplayName("Testa diferentes expressões inválidas")
	@ParameterizedTest
	@CsvSource({ "''", "-", "+",
		         "3++3","A+2","2+A","3*2"
		       })
    void exceptionTesting(String expr) {
        assertThrows(InvalidExpressionException.class, () -> {
            Expression.evaluate(expr);
        });
    }
}
