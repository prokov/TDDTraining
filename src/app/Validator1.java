package app;

public class Validator1 {

    int isbnLengthShort = 10;
    int checkNumber10 = 11;

    public boolean checkNumber(String number) {

        if (number.toCharArray().length != isbnLengthShort) {
            throw new NumberFormatException();
        }

        int total = 0;

        for (int i = 0; i < isbnLengthShort; i++) {


            if (!Character.isDigit(number.charAt(i))) {
                if ((i == isbnLengthShort - 1) && (number.charAt(i) == 'X')) {
                    total += 10;

                } else

                    throw new NumberFormatException();
            }


            total += Character.getNumericValue(number.charAt(i)) * (isbnLengthShort - i);

        }

        return total % checkNumber10 == 0;

    }
}
