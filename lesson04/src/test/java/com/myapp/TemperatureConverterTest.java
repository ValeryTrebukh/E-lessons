package com.myapp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemperatureConverterTest {

    TemperatureConverter tc = new TemperatureConverter();
    double prec = 0.0001;

    @Test
    public void convertFtoC() throws Exception {
        assertEquals(tc.convertFtoC(32), 0, prec);
    }

    @Test
    public void convertCtoF() throws Exception {
        assertEquals(tc.convertCtoF(0), 32.0, prec);
    }

    @Test
    public void convertCtoK() throws Exception {
        assertEquals(tc.convertCtoK(0), 273.2, prec);
    }

    @Test
    public void convertKtoC() throws Exception {
        assertEquals(tc.convertKtoC(273.2), 0, prec);
    }

    @Test
    public void convertFtoK() throws Exception {
        assertEquals(tc.convertFtoK(-459.7), 0, prec);
    }

    @Test
    public void convertKtoF() throws Exception {
        assertEquals(tc.convertKtoF(0), -459.7, prec);
    }

}