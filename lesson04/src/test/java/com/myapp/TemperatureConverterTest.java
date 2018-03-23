package com.myapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TemperatureConverterTest {

    @Parameterized.Parameter(0)
    public double far;

    @Parameterized.Parameter(1)
    public double cel;

    @Parameterized.Parameter(2)
    public double kel;

    TemperatureConverter tc = new TemperatureConverter();
    double prec = 0.1;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList( new Object[][] {
                { 32.0, 0.0, 273.2 },
                { 212, 100, 373.2 },
                { -459.76, -273.2, 0 }
        });
    }


    @Test
    public void convertFtoC() throws Exception {
        assertEquals(tc.convertFtoC(far), cel, prec);
    }

    @Test
    public void convertCtoF() throws Exception {
        assertEquals(tc.convertCtoF(cel), far, prec);
    }

    @Test
    public void convertCtoK() throws Exception {
        assertEquals(tc.convertCtoK(cel), kel, prec);
    }

    @Test
    public void convertKtoC() throws Exception {
        assertEquals(tc.convertKtoC(kel), cel, prec);
    }

    @Test
    public void convertFtoK() throws Exception {
        assertEquals(tc.convertFtoK(far), kel, prec);
    }

    @Test
    public void convertKtoF() throws Exception {
        assertEquals(tc.convertKtoF(kel), far, prec);
    }

}