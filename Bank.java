import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeMap;

/**
 * Models a bank class to process ATM's requests.
 * @author yen_my_huynh 10/3/2017
 */
public class Bank {
	private TreeMap<Integer, BankAccount> bankListA;
	private TreeMap<Integer, BankAccount> bankListB;
	private double withdrawalLimitA;
	private double withdrawalLimitB;

	/**
	 * Constructs 2 empty maps to store cards with associated account numbers
	 * for Bank A and Bank B.
	 */
	public Bank() {
		this.bankListA = new TreeMap<>();
		this.bankListB = new TreeMap<>();
	}

	/**
	 * Checks if this customer already makes an account in Bank A.
	 * @param name the name to check
	 * @return true if the name matches with the system's info, if not, then
	 * return false
	 */
	public boolean isCurrentCustomerA(String name) {
		for (Integer acc : bankListA.keySet()) {
			if (name.equals(bankListA.get(acc).getCardName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a new account to Bank A.
	 * @param accNum random account number generated when open 
	 * an account with Bank A
	 * @param bA bank account of Bank A
	 */
	public void addAccountToBankA(int accNum, BankAccount bA) {
		this.bankListA.put(accNum, bA);
	}

	/**
	 * Checks if the inserted cash card for Bank A has expired or not.
	 * @param cardNum the cash card number
	 * @return true if the cash card has expired, if not, then return false
	 */
	public boolean isExpDateA(String cardNum) {
		Calendar gc = new GregorianCalendar();
		int month = gc.get(Calendar.MONTH);
		month++;
		for (Integer acc : bankListA.keySet()) {
			if (cardNum.equals(bankListA.get(acc).getCardNum())) {
				if (bankListA.get(acc).getCardYear() <= gc.get(Calendar.YEAR)) {
					
					if (bankListA.get(acc).getCardMonth() < (month)){
						return true;
					}
				}
				else {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if the entered account number matches with the one in Bank A's system.
	 * @param accNum the entered account number
	 * @return true if account numbers match, if not, then return false
	 */
	public boolean isAccNumA(int accNum) {
		for (Integer acc : bankListA.keySet()) {
			if (accNum == acc) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the entered password matches with Bank A's system.
	 * @param password the entered password
	 * @param accNum the account number
	 * @return true if both passwords matched, if not, then return false
	 */
	public boolean isPasswordA(String password, int accNum) {
		if (password.equals(bankListA.get(accNum).getPassword())) {
			return true;
			
		}
		return false;
	}
	
	/**
	 * Withdraws money from an account of Bank A.
	 * @param accNum the entered account number
	 * @param moneyOut the money to withdraw
	 */
	public void withdrawalRequestA(int accNum, double moneyOut) {
		withdrawalLimitA = bankListA.get(accNum).getWithdrawalLimitA();
		if (moneyOut <= bankListA.get(accNum).getBalance()) {
			bankListA.get(accNum).withdraw(moneyOut);
			System.out.println("You withdrew, $" + moneyOut + " successfully.");
			System.out.println("Your balance is now: $" + bankListA.get(accNum).getBalance() + ".");
			System.out.println("Your remaining withdrawal balance for the day: $" + withdrawalLimitA);
		} else {
			System.out.println("You don't have enough balance to withdraw, $" + moneyOut + ".");
			System.out.println("Please select less amount of money to withdraw.");
		}
	}
	
	/**
	 * Checks if user has withdrawn daily limit from Bank A.
	 * @param moneyOut the withdrawal money
	 * @param accNum the account number
	 * @return true if user withdraws daily limit, if not, false
	 */
	public boolean isWithinWithdrawalLimitA(double moneyOut, int accNum){	
		double wLimitA = bankListA.get(accNum).getWithdrawalLimitA();
		if (wLimitA > 0.0 && moneyOut <= wLimitA){
			bankListA.get(accNum).subtractWithdrawalLimitA(moneyOut);
			return true;
		} else if (wLimitA == 0){
			bankListA.get(accNum).subtractWithdrawalLimitA(moneyOut);
			System.out.println("You have withdrawn you daily transaction limit of $350."); 
		} else if (moneyOut > wLimitA){
			bankListA.get(accNum).subtractWithdrawalLimitA(moneyOut);
			System.out.println("The amount of $" + moneyOut + " exceeds daily transaction limit.");				
			System.out.println("Please select less amount of money to withdraw.");
		}	
		return false;
	}
		
	/**
	 * Prints out the list of all accounts in Bank A.
	 */
	public void printAccListA() {
		for (Integer acc : bankListA.keySet()) {
			System.out.println("Bank A id: 52");
			System.out.println("Account Number: " + acc);
			System.out.println(bankListA.get(acc).toStringA());
		}
	}

	/**
	 * Checks if this customer already makes an account in Bank B.
	 * @param name the name to check
	 * @return true if the name matches with the system's info, if not, then
	 * return false
	 */
	public boolean isCurrentCustomerB(String name) {
		for (Integer acc : bankListB.keySet()) {
			if (name.equals(bankListB.get(acc).getCardName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a new account to Bank B.
	 * @param accNum random account number generated when open an 
	 * account with Bank B
	 * @param bB bank account of Bank B
	 */
	public void addAccountToBankB(int accNum, BankAccount bB) {
		this.bankListB.put(accNum, bB);
	}

	/**
	 * Checks if the inserted cash card for Bank B has expired or not.
	 * @param cardNum the cash card number
	 * @return true if the cash card has expired, if not, then return false
	 */
	public boolean isExpDateB(String cardNum) {
		Calendar gc = new GregorianCalendar();
		int month = gc.get(Calendar.MONTH);
		month++;
		for (Integer acc : bankListB.keySet()) {
			if (cardNum.equals(bankListB.get(acc).getCardNum())) {
				if (bankListB.get(acc).getCardYear() <= gc.get(Calendar.YEAR)) {
					if (bankListB.get(acc).getCardMonth() < (month)){
						return true;
					}
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if the entered account number matches with the one in Bank B' system.
	 * @param accNum the entered account number
	 * @return true if account numbers match, if not, then return false
	 */
	public boolean isAccNumB(int accNum) {
		for (Integer acc : bankListB.keySet()) {
			if (accNum == acc) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if the entered password matches with Bank A's system.
	 * @param password the entered password
	 * @param accNum the account number
	 * @return true if both passwords matched, if not, then return false
	 */
	public boolean isPasswordB(String password, int accNum) {
		if (password.equals(bankListB.get(accNum).getPassword())) {
			return true;
			
		}
		return false;
	}

	/**
	 * Withdraws money from an account of Bank B.
	 * @param accNum the entered account number
	 * @param moneyOut the money to withdraw
	 */
	public void withdrawalRequestB(int accNum, double moneyOut) {
		withdrawalLimitB = bankListB.get(accNum).getWithdrawalLimitB();
		if (moneyOut <= bankListB.get(accNum).getBalance()) {
			bankListB.get(accNum).withdraw(moneyOut);
			System.out.println("You withdrew, $" + moneyOut + " successfully.");
			System.out.println("Your balance is now: $" + bankListB.get(accNum).getBalance() + ".");
			System.out.println("Your remaining withdrawal balance for the day: $" + withdrawalLimitB);
		} else {
			System.out.println("You don't have enough balance to withdraw, $" + moneyOut + ".");
			System.out.println("Please select less amount of money to withdraw.");
		}
	}
	
	/**
	 * Checks if user has withdrawn daily limit from Bank B.
	 * @param moneyOut the withdrawal money
	 * @param accNum the account number
	 * @return true if user withdraws daily limit, if not, false
	 */
	public boolean isWithinWithdrawalLimitB(double moneyOut, int accNum){	
		double wLimitB = bankListB.get(accNum).getWithdrawalLimitB();
		if (wLimitB > 0.0 && moneyOut <= wLimitB){
			bankListB.get(accNum).subtractWithdrawalLimitB(moneyOut);
			return true;
		} else if (wLimitB == 0){
			bankListB.get(accNum).subtractWithdrawalLimitB(moneyOut);
			System.out.println("You have withdrawn you daily transaction limit of $350."); 
		} else if (moneyOut > wLimitB && wLimitB > 0.0){
			bankListB.get(accNum).subtractWithdrawalLimitB(moneyOut);
			System.out.println("The amount of $" + moneyOut + " exceeds daily transaction limit.");				
			System.out.println("Please select less amount of money to withdraw.");
		}	
		return false;
	}
	
	/**
	 * Prints out the list of all accounts in Bank B.
	 */
	public void printAccListB() {
		for (Integer acc : bankListB.keySet()) {
			System.out.println("Bank B id: 56");
			System.out.println("Account Number: " + acc);
			System.out.println(bankListB.get(acc).toStringB());
		}
	}
	
	/**
	 * Prints out the state of Bank A.
	 */
	public void printAllBankAccountsOfA(){
		System.out.println("Bank of A (" + String.valueOf(bankListA.size()) + " customers)");
		for (Integer acc: bankListA.keySet()){
			System.out.println("Card-owner: " + bankListA.get(acc).getCardName() + " - Cash Card (bankid: 52, Account Number: " + acc +  ", Card Number: " +  bankListA.get(acc).getCardNum() + ", Expirate Date: " 
					+  bankListA.get(acc).getCardMonth() + "/" +  bankListA.get(acc).getCardYear() + ", Password: " +  bankListA.get(acc).getPassword() + 
					", Balance: $" +  bankListA.get(acc).getBalance() +", Withdrawal Limit: "
					+  bankListA.get(acc).getWithdrawalLimitA() + "\n");
		}
	}
	
	/**
	 * Prints out the state of Bank B.
	 */
	public void printAllBankAccountsOfB(){
		System.out.println("Bank of B (" + String.valueOf(bankListB.size()) + " customers)");
		for (Integer acc: bankListB.keySet()){
			System.out.println("Card-owner: " + bankListB.get(acc).getCardName() + " - Cash Card (bankid: 56, Account Number: " + acc +  ", Card Number: " +  bankListB.get(acc).getCardNum() + ", Expirate Date: " 
					+  bankListB.get(acc).getCardMonth() + "/" +  bankListB.get(acc).getCardYear() + ", Password: " +  bankListB.get(acc).getPassword() + 
					", Balance: $" +  bankListB.get(acc).getBalance() +", Withdrawal Limit: "
					+  bankListB.get(acc).getWithdrawalLimitB() + "\n");
		}
	}
}

