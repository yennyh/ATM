public class BankAccount {
	private String password;
	private double balance;
	private double withdrawalLimitA;
	private double withdrawalLimitB;
	private Card c;

	/**
	 * Constructs a BankAccount with a cash card, a password, and an initial balance.
	 * @param c the cash card
	 * @param password the entered password
	 * @param balance the initial balance entered by customer
	 */
	public BankAccount(Card c, String password, double balance) {
		this.c = c;
		this.password = password;
		this.balance = balance;
		withdrawalLimitA = ATM.WITHDRAWAL_LIMIT_A;
		withdrawalLimitB = ATM.WITHDRAWAL_LIMIT_B;
	}

	/**
	 * Gets the card number of the cash card via BankAccount.
	 * @return the number of the cash card via BankAccount
	 */
	public String getCardNum() {
		return c.getCardNumber();
	}

	/**
	 * Gets the expired month of the cash card via BankAccount.
	 * @return the expired month of the cash card via BankAccount
	 */
	public int getCardMonth() {
		return c.getMonth();
	}

	/**
	 * Gets the expired year of the cash card via BankAccount.
	 * @return the expired year of the cash card via BankAccount
	 */
	public int getCardYear() {
		return c.getYear();
	}

	/**
	 * Gets the name of the cash card via BankAccount.
	 * @return the name of the cash card via BankAccount
	 */
	public String getCardName() {
		return c.getName();
	}

	/**
	 * Gets the password of the cash card.
	 * @return the password of the cash card
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the balance of the cash card.
	 * @return the balance of the cash card
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Gets the withdrawal limit balance of bank accounts A.
	 * @return the withdrawal limit balance
	 */
	public double getWithdrawalLimitA(){
		return withdrawalLimitA;
	}
	
	/**
	 * Subtracts withdrawal limit of bank accounts A whenenver user withdraws.
	 */
	public void subtractWithdrawalLimitA(double moneyOut){
		if (moneyOut <= withdrawalLimitA && moneyOut <= getBalance()){
			withdrawalLimitA -= moneyOut;
		}
	}
	
	/**
	 * Gets the withdrawal limit balance of bank accounts B.
	 * @return the withdrawal limit balance
	 */
	public double getWithdrawalLimitB(){
		return withdrawalLimitB;
	}
	
	/**
	 * Subtracts withdrawal limit of bank accounts B whenenver user withdraws.
	 */
	public void subtractWithdrawalLimitB(double moneyOut){
		if (moneyOut <= withdrawalLimitB && moneyOut <= getBalance()){
			withdrawalLimitB -= moneyOut;
		}
	}
	
	/**
	 * Withdraws the money from bank account.
	 * @param moneyOut the money to be withdrew
	 */
	public void withdraw(double moneyOut) {
		if (moneyOut <= balance) {
			balance -= moneyOut;
		}
	}

	/**
	 * Writes string into a certain format.
	 * @return the string in format of customer, card#, exp date, password, balance and withdrawal limit
	 */
	public String toStringA() {
		return "Card-owner: " + getCardName().substring(0,1).toUpperCase() + getCardName().substring(1) + "\nCard Number: " + getCardNum() + "\nExpirate Date: " 
	+ getCardMonth() + "/" + getCardYear() + "\nPassword: " + getPassword() + "\nBalance: $" + balance +"\nWithdrawal Limit: "
	+ getWithdrawalLimitA() + "\n";
	}
	
	/**
	 * Writes string into a certain format.
	 * @return the string in format of customer, card#, exp date, password, balance and withdrawal limit
	 */
	public String toStringB() {
		return "Card-owner: " + getCardName().substring(0,1).toUpperCase() + getCardName().substring(1) + "\nCard Number: " + getCardNum() + "\nExpirate Date: " 
	+ getCardMonth() + "/" + getCardYear() + "\nPassword: " + getPassword() + "\nBalance: $" + balance +"\nWithdrawal Limit: "
	+ getWithdrawalLimitB() + "\n";
	}
}
