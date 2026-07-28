package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void testAddWithNegative() {
        assertEquals(-1, calc.add(2, -3));
    }

    @Test
    public void testSubtract() {
        assertEquals(7, calc.subtract(10, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(12, calc.multiply(4, 3));
    }

    @Test
    public void testNumberIsEven() {
        assertTrue(calc.isEven(4));
    }

    @Test
    public void testNumberIsNotEven() {
        assertFalse(calc.isEven(7));
    }

}
