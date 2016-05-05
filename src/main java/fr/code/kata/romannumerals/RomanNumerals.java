package fr.code.kata.romannumerals;

import org.apache.log4j.Logger;

/**
 * Convertir un chiffre romain vers un nombre arabic et inversement
 * La conversion se fait en se basant sur la correspondance définie dans l'enum RomunNumeralEnum
 * Un nombre romain doit être compris entre 0 et 3999
 */
public class RomanNumerals {

    public static final int ROMANNUMERAL_MAX = 3999;
    public static final int ROMANNUMERAL_MIN = 0;
    private final static Logger logger = Logger.getLogger(RomanNumerals.class);

    /**
     * Convertir un arabic number à en un chiffre romain
     *
     * @param arabicNumber
     * @return chiffre romain
     */
    public String convertArabicNumberToRoaminNumber(int arabicNumber) {

        if (arabicNumber <= ROMANNUMERAL_MIN || arabicNumber > ROMANNUMERAL_MAX) {
            logger.error("Nombre non valide : " + arabicNumber);
            throw new NumberFormatException();
        }

        StringBuilder romannumeralBuilder = new StringBuilder();
        for (RomanNumeralEnum romannnumeral : RomanNumeralEnum.values()) {
            while (arabicNumber - romannnumeral.getValue() >= 0) {
                arabicNumber -= romannnumeral.getValue();
                romannumeralBuilder.append(romannnumeral);
            }
        }
        return romannumeralBuilder.toString();
    }


    /**
     * Convertir un chiffre romain en arabic number
     *
     * @param romainNumber
     * @return entier
     */
    public int convertRomainNumberToArabicNumber(String romainNumber) {

        if (romainNumber == null || romainNumber.isEmpty()) {
            logger.error("Format du nombre non valide : " + romainNumber);
            throw new NumberFormatException();
        }

        //Pour pouvoir faire la correspondance entre les chiffres et les lettres dans l'enum RomanNumeralEnum
        romainNumber = romainNumber.toUpperCase();
        validateRomanNumber(romainNumber);

        //Pour pouvoir detecter les cas particulier IV et IX
        romainNumber = new StringBuilder(romainNumber).reverse().toString();

        int total = 0;
        RomanNumeralEnum previous = RomanNumeralEnum.I;
        RomanNumeralEnum current;

        for (Character c : romainNumber.toCharArray()) {
            current = RomanNumeralEnum.valueOf(c.toString());
            total = current.getValue() < previous.getValue() ? total - current.getValue() : total + current.getValue();
            previous = current;
        }
        return total;
    }


    /**
     * Valider si une chaine de carctère correspond à un chiffre romain
     * Renvoi une exception si le chiffre n'est pas valide
     *
     * @param romainNumber
     */
    private void validateRomanNumber(String romainNumber) {

        //Verifier la validité des lettres
        for (Character c : romainNumber.toCharArray()) {
            try {
                RomanNumeralEnum.valueOf(c.toString());
            } catch (IllegalArgumentException ex) {
                logger.error("Format du nombre non valide caractère non connu : " + c);
                throw new NumberFormatException();
            }
        }
    }
}