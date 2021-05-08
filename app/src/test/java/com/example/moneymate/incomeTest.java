package com.example.moneymate;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class incomeTest {

    private income income;

    @Before
    public void setup(){
        income = new income();
    }

    @Test
    public void testCalcTotal() {

        float result = income.calcTotal((float)50.0,(float)20.0);

        assertEquals(30.0,result,0.001);
    }
}