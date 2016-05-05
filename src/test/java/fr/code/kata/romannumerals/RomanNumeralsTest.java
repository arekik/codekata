package fr.code.kata.romannumerals;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ayr on 04/05/2016.
 */

public class RomanNumeralsTest {

    private RomanNumerals romanNumerals;

    @Before
    public void init() {
        romanNumerals = new RomanNumerals();
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertToRoaminMin() {
        romanNumerals.convertArabicNumberToRoaminNumber(0);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertToRoaminMax() {
        romanNumerals.convertArabicNumberToRoaminNumber(4000);
    }

    @Test
    public void testConvertToRoaminI() {
        assertEquals(romanNumerals.convertArabicNumberToRoaminNumber(1), "I");
    }

    @Test
    public void testConvertToRoaminMMDCCLI() {
        assertEquals(romanNumerals.convertArabicNumberToRoaminNumber(2751), "MMDCCLI");
    }


    @Test(expected = NumberFormatException.class)
    public void testValidateRomainStringEmpty() {
        romanNumerals.convertRomainNumberToArabicNumber("");
    }

    @Test(expected = NumberFormatException.class)
    public void testValidateRomainStringNull() {
        romanNumerals.convertRomainNumberToArabicNumber(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testValidateRomainStringNotValid() {
        romanNumerals.convertRomainNumberToArabicNumber("MMDaCC");
    }

    @Test
    public void testValidateRomainStringValiderMinscule() {
        assertEquals(romanNumerals.convertRomainNumberToArabicNumber("mmdccli"), 2751);
    }

    @Test
    public void testValidateRomainStringValiderMajiscule() {
        assertEquals(romanNumerals.convertRomainNumberToArabicNumber("MMDCCLI"), 2751);
    }

    @Test
    public void testValidateRomainStringValider() {
        assertEquals(romanNumerals.convertRomainNumberToArabicNumber("CCCLXIX"), 369);
    }

}
