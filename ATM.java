/**
 * Models an ATM class to depict states of each bank.
 * @author yen_my_huynh 10/3/2017
 *
 */
public class ATM {
	public static final double WITHDRAWAL_LIMIT_A = 350;
	public static final double WITHDRAWAL_LIMIT_B = 300;
	
	
	/**
	 * Checks the id of Bank A.
	 * @param id the id
	 * @return true if id matches, if not, false
	 */
	public boolean isBankAID(String id){
		String first2Digits = id.substring(0, 2);
		if (first2Digits.equals("52")) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the withdrawal money exceed the limit.
	 * @param moneyOut the withdrawal money
	 * @return true if exceed withdrawal money, if not, false
	 */
	public boolean isExceedWithdrawalA(double moneyOut){
		if (moneyOut > 350){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks the id of Bank B.
	 * @param id the id
	 * @return true if id matches, if not, false
	 */
	public boolean isBankBID(String id){
		String first2Digits = id.substring(0, 2);
		if (first2Digits.equals("56")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the withdrawal money exceed the limit.
	 * @param moneyOut the withdrawal money
	 * @return true if exceed withdrawal money, if not, false
	 */
	public boolean isExceedWithdrawalB(double moneyOut){
		if (moneyOut > 300){
			return true;
		}
		return false;
	}
	
	/**
	 * Represents the states of 4 ATM's.
	 */
	public static void printATMStates() {
		System.out.println("ATM1_A: (ATM1 from Bank A)\n\tThe maximum amount of cash of a card withdraw per day: $350\n"
				+ "ATM2_A: (ATM2 from Bank A)\n\tThe maximum amount of cash of a card withdraw per day: $350\n"
				+"ATM3_B: (ATM3 from Bank B)\n\tThe maximum amount of cash of a card withdraw per day: $300\n"
				+"ATM4_B: (ATM4 from Bank B)\n\tThe maximum amount of cash of a card withdraw per day: $300\n");
	}
}



