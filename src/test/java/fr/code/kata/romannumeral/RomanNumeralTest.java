package fr.code.kata.romannumeral;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ayr on 04/05/2016.
 */

public class RomanNumeralTest {

    private RomanNumeral romanNumeral;

    @Before
    public void init() {
        romanNumeral = new RomanNumeral();
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertToRoaminMin() {
        romanNumeral.convertArabicNumberToRoaminNumber(0);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertToRoaminMax() {
        romanNumeral.convertArabicNumberToRoaminNumber(4000);
    }

    @Test
    public void testConvertToRoaminI() {
        assertEquals(romanNumeral.convertArabicNumberToRoaminNumber(1), "I");
    }

    @Test
    public void testConvertToRoaminMMDCCLI() {
        assertEquals(romanNumeral.convertArabicNumberToRoaminNumber(2751), "MMDCCLI");
    }


    @Test(expected = NumberFormatException.class)
    public void testValidateRomainStringEmpty() {
        romanNumeral.convertRomainNumberToArabicNumber("");
    }

    @Test(expected = NumberFormatException.class)
    public void testValidateRomainStringNull() {
        romanNumeral.convertRomainNumberToArabicNumber(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testValidateRomainStringNotValid() {
        romanNumeral.convertRomainNumberToArabicNumber("MMDaCC");
    }

    @Test
    public void testValidateRomainStringValiderMinscule() {
        assertEquals(romanNumeral.convertRomainNumberToArabicNumber("mmdccli"), 2751);
    }

    @Test
    public void testValidateRomainStringValiderMajiscule() {
        assertEquals(romanNumeral.convertRomainNumberToArabicNumber("MMDCCLI"), 2751);
    }

    @Test
    public void testValidateRomainStringValider() {
        assertEquals(romanNumeral.convertRomainNumberToArabicNumber("CCCLXIX"), 369);
    }

}
