package app;

public class Validator {

	private static final int LONG_ISBN_MULTIPLYER = 10;
	private static final int SHORT_ISBN_MULTIPLYER = 11;
	private static final int SHORT_ISBN_LENGTH = 10;
	private static final int LONG_ISBN_LENGTH = 13;

	public boolean checkNumber(String isbn) {
		// if (isbn == "0143108271")
		// return true;
		// return false;

		if (isbn.length() == LONG_ISBN_LENGTH) {
			return check13DigitsIsbn(isbn);
		} else if (isbn.length() == SHORT_ISBN_LENGTH)
			return check10DigitsIsbn(isbn);

		throw new NumberFormatException("ISBN should have 10 or 13 digits");

	}

		private boolean check10DigitsIsbn(String isbn) {
		int total = 0;

		for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {

			if (!Character.isDigit(isbn.charAt(i))) {
				if (i == SHORT_ISBN_LENGTH - 1 && isbn.charAt(i) == 'X') {

					total += SHORT_ISBN_LENGTH; // according to Req

				} else {

					throw new NumberFormatException("ISBN should have only digits");
				}

			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i); //tricky place, start with isbn.charAt(i), will get char ASCII code
			}
		}

		return total % SHORT_ISBN_MULTIPLYER == 0;

	}

	private boolean check13DigitsIsbn(String isbn) {
		int total = 0;

		for (int i = 0; i < LONG_ISBN_LENGTH; i++) {

			if (!Character.isDigit(isbn.charAt(i))) {
				throw new NumberFormatException("ISBN should have only digits");

			} else {

				if (i % 2 == 0) {

					total += Character.getNumericValue(isbn.charAt(i)) * 1;

				} else

					total += Character.getNumericValue(isbn.charAt(i)) * 3;
			}
		}

		return (total % LONG_ISBN_MULTIPLYER == 0);

	}

}





























