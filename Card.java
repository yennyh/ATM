public class Card {
	private String name;
	private String cardNumber;
	private int month;
	private int year;

	/**
	 * Constructs a cash card with a name, a card number, and an expiration date.
	 * @param name the entered name
	 * @param cardNumber the generated card number when a customer creates a cash card
	 * @param month the generated month
	 * @param year the generated year
	 */
	public Card(String name, String cardNumber, int month, int year) {
		this.name = name;
		this.month = month;
		this.year = year;
		this.cardNumber = cardNumber;
		
	}
	
	/**
	 * Gets the name on the cash card.
	 * @return the name on the cash card
	 */
	public String getName(){
		return name;
	}

	/**
	 * Gets the cash card number.
	 * @return the cash card number
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Gets the month on the cash card.
	 * @return the month on the cash card
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Gets the year on the cash card.
	 * @return the year on the cash card
	 */
	public int getYear() {
		return year;
	}
}

