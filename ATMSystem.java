//import java.util.Scanner;
//
///**
// * Models a class that allows user to have up to two cash cards from two
// * different banks, and withdraw money using their cards.
// * 
// * @author yen_my_huynh 10/3/2017
// */
//
//public class ATMSystem {
//	/**
//	 * Main method to create cards and withdraw money -- also check balances & withdrawal limits.
//	 * @param args no args used, only Scanner inputs
//	 */
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		Bank a = new Bank();
//		Bank b = new Bank();
//		
//		// hardcode existing customers for Bank of A.
//		String cardNum = String.valueOf(5200000000000000L + (long) (Math.random() * 100000000000000L));
//		Card cardA1 = new Card("Nick", String.valueOf(5200000000000000L + (long) (Math.random() * 100000000000000L)),
//				randBetween(1, 12), randBetween(2017, 2022));
//		int accNumA1 = randBetween(1, 1000);
//		BankAccount bankA1 = new BankAccount(cardA1, "pwA1", 50);
//		Card cardA2 = new Card("Hulk", String.valueOf(5200000000000000L + (long) (Math.random() * 100000000000000L)),
//				randBetween(1, 12), randBetween(2017, 2022));
//		int accNumA2 = randBetween(1, 1000);
//		BankAccount bankA2 = new BankAccount(cardA2, "pwA2", 40);
//		a.addAccountToBankA(accNumA1, bankA1);
//		a.addAccountToBankA(accNumA2, bankA2);
//
//		// hardcode existing customers for Bank of B.
//		Card cardB1 = new Card("Black Widow",
//				String.valueOf(5600000000000000L + (long) (Math.random() * 100000000000000L)), randBetween(1, 12),
//				randBetween(2017, 2022));
//		int accNumB1 = randBetween(1, 1000);
//		BankAccount bankB1 = new BankAccount(cardB1, "pwB1", 500);
//		Card cardB2 = new Card("Iron Man",
//				String.valueOf(5600000000000000L + (long) (Math.random() * 100000000000000L)), randBetween(1, 12),
//				randBetween(2017, 2022));
//		int accNumB2 = randBetween(1, 1000);
//		BankAccount bankB2 = new BankAccount(cardB2, "pwB2", 3000);
//		Card cardB3 = new Card("Captain America",
//				String.valueOf(5600000000000000L + (long) (Math.random() * 100000000000000L)), randBetween(1, 12),
//				randBetween(2017, 2022));
//		int accNumB3 = randBetween(1, 1000);
//		BankAccount bankB3 = new BankAccount(cardB3, "pwB3", 2000);
//		b.addAccountToBankB(accNumB1, bankB1);
//		b.addAccountToBankB(accNumB2, bankB2);
//		b.addAccountToBankB(accNumB3, bankB3);
//
//		// prints states of banks and atm's
//		a.printAllBankAccountsOfA();
//		b.printAllBankAccountsOfB();
//		ATM.printATMStates();
//		boolean run = true;
//		while (run) {
//			sop("There are 4 ATM's. Press '1' or '2' for Bank A, or '3' or '4' for Bank B.");
//			sop("To quit, press 'Q'.");
//			String atm = in.next().toLowerCase();
//			while (true) {
//				String option;
//				String next = in.nextLine();
//				// ATM's access to BANK A.
//				if (atm.equals("1") || atm.equals("2")) {
//					ATM atmA = new ATM();
//					printMainMenu();
//					option = in.nextLine().toLowerCase();
//					// allows customers to create new bank accounts.
//					if (option.equals("c")) {
//						sop("Enter your full name: ");
//						String name = in.nextLine().toLowerCase();
//						// checks for existing accounts.
//						if (a.isCurrentCustomerA(name) == true) {
//							sop("Sorry, you already created an account with this bank.");
//							sop("Check with Bank B.");
//							sop("Press 'Enter' again for main menu: ");
//							// randomizes a new cash card for A customers.
//						} else {
//							long last14A = (long) (Math.random() * 100000000000000L);
//							String cardNumA = String.valueOf(5200000000000000L + last14A);
//							int month = randBetween(1, 12);
//							int year = randBetween(2017, 2022);
//							Card cardA = new Card(name, cardNumA, month, year);
//							int accNumA = randBetween(1, 1000);
//							sop("Enter a password for your bank's account: ");
//							String password = in.nextLine();
//							sop("Enter deposited amount to start with: ");
//							double startingBalance = in.nextDouble();
//							BankAccount bankA = new BankAccount(cardA, password, startingBalance);
//							sop("Your cash card will be: " + cardNum + ".");
//							sop("You cash card's expiration date: " + cardA.getMonth() + "/" + cardA.getYear());
//							sop("Your account number will be: " + accNumA + ".");
//							sop("Press 'Enter' again for main menu: \n");
//							a.addAccountToBankA(accNumA, bankA);
//						}
//						// allows A customers to insert their cards for withdrawal.
//					} else if (option.equals("i")) {
//						sop("Enter you cash card: ");
//						String cardNumIn = in.nextLine();
//						String first2Digits = cardNumIn.substring(0, 2);
//						String password;
//						double withdrawal;
//						int accountNum;
//						boolean keepWithdrawA = true;
//						if ((atmA.isBankAID(first2Digits)) == true) {
//							sop("This card associates with Bank A.");
//							// checks for expiration dates.
//							if (a.isExpDateA(cardNumIn) == true) {
//								sop("Your card has expired.");
//								sop("Press 'Enter' again for main menu: \n");
//							} else {
//								sop("Your card is valid.");
//								sop("Enter your account number: ");
//								accountNum = in.nextInt();
//								// when account number of A matches.
//								if (a.isAccNumA(accountNum) == true) {
//									sop("Please enter your password: ");
//									next = in.nextLine();
//									password = in.next();
//									while (keepWithdrawA) {
//										// when password of A matches.
//										if (a.isPasswordA(password, accountNum) == true) {
//											sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
//											next = in.next().toLowerCase();
//											if (next.equals("q")) {
//												keepWithdrawA = false;
//												break;
//												// either pass or no pass with withdrawal check.
//											} else {
//												withdrawal = Double.parseDouble(next);
//												if (atmA.isExceedWithdrawalA(withdrawal)) {
//													sop("Entered amount exceeded transaction limit.");
//												} else if (withdrawal <= 350
//														&& a.isWithinWithdrawalLimitA(withdrawal, accountNum)) {
//													a.withdrawalRequestA(accountNum, withdrawal);
//												}
//											}
//											// when password of A doesn't match.
//										} else {
//											sop("Entered password doesn't match the cash card. Please re-enter your password: ");
//											password = in.next();
//											if (a.isPasswordA(password, accountNum) == true) {
//												sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
//												next = in.next().toLowerCase();
//												if (next.equals("q")) {
//													keepWithdrawA = false;
//													sop("Press 'Enter' again for main menu: ");
//													break;
//													// either pass or no pass with withdrawal check.
//												} else {
//													withdrawal = Double.parseDouble(next);
//													if (atmA.isExceedWithdrawalA(withdrawal)) {
//														sop("Entered amount exceeded transaction limit.");
//													} else if (withdrawal <= 350
//															&& a.isWithinWithdrawalLimitA(withdrawal, accountNum)) {
//														a.withdrawalRequestA(accountNum, withdrawal);
//													}
//												}
//											}
//										}
//									}
//									// when account number of A doesn't match.
//								} else {
//									sop("Entered account number doesn't match. Re-enter your account number: ");
//									accountNum = in.nextInt();
//									sop("Please enter your password: ");
//									password = in.next();
//									while (keepWithdrawA) {
//										// when password of A matches.
//										if (a.isPasswordA(password, accountNum) == true) {
//											sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
//											next = in.next().toLowerCase();
//											if (next.equals("q")) {
//												keepWithdrawA = false;
//												break;
//												// either pass or no pass with withdrawal check.
//											} else {
//												withdrawal = Double.parseDouble(next);
//												if (atmA.isExceedWithdrawalA(withdrawal)) {
//													sop("Entered amount exceeded transaction limit. ");
//												} else if (withdrawal <= 350
//														&& a.isWithinWithdrawalLimitA(withdrawal, accountNum)) {
//													a.withdrawalRequestA(accountNum, withdrawal);
//												}
//											}
//											// when password of A doesn't match.
//										} else {
//											sop("Entered password doesn't match the cash card. Please re-enter your password: ");
//											password = in.next();
//											if (a.isPasswordA(password, accountNum) == true) {
//												sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
//												next = in.next().toLowerCase();
//												if (next.equals("q")) {
//													keepWithdrawA = false;
//													sop("Press 'Enter' again for main menu: ");
//													break;
//													// either pass or no pass with withdrawal check.
//												} else {
//													withdrawal = Double.parseDouble(next);
//													if (atmA.isExceedWithdrawalA(withdrawal)) {
//														sop("Entered amount exceeded transaction limit.");
//													} else if (withdrawal <= 350
//															&& a.isWithinWithdrawalLimitA(withdrawal, accountNum)) {
//														a.withdrawalRequestA(accountNum, withdrawal);
//													}
//												}
//											}
//										}
//									}
//								}
//							}
//						}
//						else if ((atmA.isBankBID(first2Digits)) == true){
//							System.out.println("This card associates with Bank B and is not supported by this ATM.");
//							sop("Press 'Enter' again for main menu: ");
//						}
//						// allows to view all existing accounts in Bank A. [to check if all A accounts are in]
//					} else if (option.equals("v")) {
//						a.printAccListA();
//						sop("Press 'Enter' again for main menu: ");
//						// allows customers to get their cards back.
//					} else if (option.equals("w")) {
//						sop("Your cash card has been dispensed from Bank A.");
//						sop("");
//						break;
//					}
//					// ATM's access to BANK B.
//				} else if (atm.equals("3") || atm.equals("4")) {
//					ATM atmB = new ATM();
//					printMainMenu();
//					option = in.nextLine().toLowerCase();
//					// allows customers to create new bank accounts.
//					if (option.equals("c")) {
//						sop("Enter your full name: ");
//						String name = in.nextLine().toLowerCase();
//						// checks for existing accounts.
//						if (b.isCurrentCustomerB(name) == true) {
//							sop("Sorry, you already created an account with this bank.");
//							sop("Check with Bank A.");
//							sop("Press 'Enter' again for main menu: ");
//							// randomizes a new cash card for B customers.
//						} else {
//							long last14B = (long) (Math.random() * 100000000000000L);
//							String cardNumB = String.valueOf(56000000000000000L + last14B);
//							int month = randBetween(1, 12);
//							int year = randBetween(2017, 2022);
//							Card cardB = new Card(name, cardNumB, month, year);
//							int accNumB = randBetween(1, 1000);
//							sop("Enter a password for your bank's account: ");
//							String password = in.nextLine();
//							sop("Enter deposited amount to start with: ");
//							double startingBalance = in.nextDouble();
//							BankAccount bankB = new BankAccount(cardB, password, startingBalance);
//							sop("Your cash card will be: " + cardNum + ".");
//							sop("You cash card's expiration date: " + cardB.getMonth() + "/" + cardB.getYear());
//							sop("Your account number will be: " + accNumB + ".");
//							sop("Press 'Enter' again for main menu: \n");
//							b.addAccountToBankB(accNumB, bankB);
//						}
//						// allows B customers to insert their cards for
//						// withdrawal.
//					} else if (option.equals("i")) {
//						sop("Enter you cash card: ");
//						String cardNumIn = in.nextLine();
//						String first2Digits = cardNumIn.substring(0, 2);
//						String password;
//						double withdrawal;
//						int accountNum;
//						boolean keepWithdrawB = true;
//						if ((atmB.isBankBID(first2Digits)) == true) {
//							sop("This card associates with Bank B.");
//							// checks for expiration dates.
//							if (b.isExpDateB(cardNumIn) == true) {
//								sop("Your card has expired.");
//								sop("Press 'Enter' again for main menu: \n");
//							} else {
//								sop("Your card is valid.");
//								sop("Enter your account number: ");
//								accountNum = in.nextInt();
//								// when account number of B matches.
//								if (b.isAccNumB(accountNum) == true) {
//									sop("Please enter your password: ");
//									next = in.nextLine();
//									password = in.next();
//									while (keepWithdrawB) {
//										// when password of B matches.
//										if (b.isPasswordB(password, accountNum) == true) {
//											sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
//											next = in.next().toLowerCase();
//											if (next.equals("q")) {
//												keepWithdrawB = false;
//												break;
//												// either pass or no pass with withdrawal check.
//											} else {
//												withdrawal = Double.parseDouble(next);
//												if (atmB.isExceedWithdrawalB(withdrawal)) {
//													sop("Entered amount exceeded transaction limit.");
//												} else if (withdrawal <= 350
//														&& b.isWithinWithdrawalLimitB(withdrawal, accountNum)) {
//													b.withdrawalRequestB(accountNum, withdrawal);
//												}
//											}
//											// when password of B doesn't match.
//										} else {
//											sop("Entered password doesn't match the cash card. Please re-enter your password: ");
//											password = in.next();
//											if (b.isPasswordB(password, accountNum) == true) {
//												sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
//												next = in.next().toLowerCase();
//												if (next.equals("q")) {
//													keepWithdrawB = false;
//													sop("Press 'Enter' again for main menu: ");
//													break;
//													// either pass or no pass with withdrawal check.
//												} else {
//													withdrawal = Double.parseDouble(next);
//													if (atmB.isExceedWithdrawalB(withdrawal)) {
//														sop("Entered amount exceeded transaction limit.");
//													} else if (withdrawal <= 350
//															&& b.isWithinWithdrawalLimitB(withdrawal, accountNum)) {
//														b.withdrawalRequestB(accountNum, withdrawal);
//													}
//												}
//											}
//										}
//									}
//									// when account number of B doesn't match.
//								} else {
//									sop("Entered account number doesn't match. Re-enter your account number: ");
//									accountNum = in.nextInt();
//									sop("Please enter your password: ");
//									password = in.next();
//									while (keepWithdrawB) {
//										// when password of B matches.
//										if (b.isPasswordB(password, accountNum) == true) {
//											sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
//											next = in.next().toLowerCase();
//											if (next.equals("q")) {
//												keepWithdrawB = false;
//												break;
//												// either pass or no pass with withdrawal check.
//											} else {
//												withdrawal = Double.parseDouble(next);
//												if (atmB.isExceedWithdrawalB(withdrawal)) {
//													sop("Entered amount exceeded transaction limit.");
//												} else if (withdrawal <= 350
//														&& b.isWithinWithdrawalLimitB(withdrawal, accountNum)) {
//													b.withdrawalRequestB(accountNum, withdrawal);
//												}
//											}
//											// when password of B doesn't match.
//										} else {
//											sop("Entered password doesn't match the cash card. Please re-enter your password: ");
//											password = in.next();
//											if (b.isPasswordB(password, accountNum) == true) {
//												sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
//												next = in.next().toLowerCase();
//												if (next.equals("q")) {
//													keepWithdrawB = false;
//													sop("Press 'Enter' again for main menu: ");
//													break;
//													// either pass or no pass with withdrawal check.
//												} else {
//													withdrawal = Double.parseDouble(next);
//													if (atmB.isExceedWithdrawalB(withdrawal)) {
//														sop("Entered amount exceeded transaction limit.");
//													} else if (withdrawal <= 350
//															&& b.isWithinWithdrawalLimitB(withdrawal, accountNum)) {
//														b.withdrawalRequestB(accountNum, withdrawal);
//													}
//												}
//											}
//										}
//									}
//								}
//							}			
//						}
//						else if ((atmB.isBankAID(first2Digits)) == true){
//							System.out.println("This card associates with Bank A and is not supported by this ATM.");
//							sop("Press 'Enter' again for main menu: ");
//						}
//						// allows to view all existing accounts in Bank B. [to check if all B accounts are in]
//					} else if (option.equals("v")) {
//						b.printAccListB();
//						sop("Press 'Enter' again for main menu: ");
//						// allows customers to get their cards back.
//					} else if (option.equals("w")) {
//						sop("Your cash card has been dispensed from Bank B.");
//						sop("");
//						break;
//					}
//					// quits overall program.
//				} else if (atm.equals("q")) {
//					run = false;
//					break;
//					// return to main options of choosing ATMS.
//				} else {
//					sop("Please re-enter '1' or '2' for Bank A, '3' or '4' for Bank B.");
//					atm = in.next();
//				}
//			}
//		}
//		// closes Scanner.
//		in.close();
//	}
//
//	/**
//	 * Shortcut method to print prompts. 
//	 * @param str the text to print
//	 */
//	public static void sop(String str) {
//		System.out.println(str);
//	}
//
//	/**
//	 * Randomizes a number between the starting time and the ending time.
//	 * @param start any time after the stated start number
//	 * @param end any time before the stated end number
//	 * @return the random number
//	 */
//	public static int randBetween(int start, int end) {
//		return start + (int) Math.round(Math.random() * (end - start));
//	}
//
//	/**
//	 * Prints the main menu with several options.
//	 */
//	public static void printMainMenu() {
//		sop("Select one of the following options: ");
//		sop("[C]reate a bank account\t  [I]nsert a cash card\t [V]iew all accounts of this bank \t[W]ithdraw cash card");
//	}
//}
import java.util.Scanner;

/**
 * Models a class that allows user to have up to two cash cards from two
 * different banks, and withdraw money using their cards.
 * 
 * @author yen_my_huynh 10/3/2017
 */

public class ATMSystem {
	/**
	 * Main method to create cards and withdraw money -- also check balances & withdrawal limits.
	 * @param args no args used, only Scanner inputs
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Bank a = new Bank();
		Bank b = new Bank();
		
		// hardcode existing customers for Bank of A.
		String cardNum = String.valueOf(5200000000000000L + (long) (Math.random() * 100000000000000L));
		Card cardA1 = new Card("Nick", String.valueOf(5200000000000000L + (long) (Math.random() * 100000000000000L)),
				randBetween(1, 12), randBetween(2017, 2022));
		int accNumA1 = randBetween(1, 1000);
		BankAccount bankA1 = new BankAccount(cardA1, "pwA1", 50);
		Card cardA2 = new Card("Hulk", String.valueOf(5200000000000000L + (long) (Math.random() * 100000000000000L)),
				randBetween(1, 12), randBetween(2017, 2022));
		int accNumA2 = randBetween(1, 1000);
		BankAccount bankA2 = new BankAccount(cardA2, "pwA2", 40);
		a.addAccountToBankA(accNumA1, bankA1);
		a.addAccountToBankA(accNumA2, bankA2);

		// hardcode existing customers for Bank of B.
		Card cardB1 = new Card("Black Widow",
				String.valueOf(5600000000000000L + (long) (Math.random() * 100000000000000L)), randBetween(1, 12),
				randBetween(2017, 2022));
		int accNumB1 = randBetween(1, 1000);
		BankAccount bankB1 = new BankAccount(cardB1, "pwB1", 500);
		Card cardB2 = new Card("Iron Man",
				String.valueOf(5600000000000000L + (long) (Math.random() * 100000000000000L)), randBetween(1, 12),
				randBetween(2017, 2022));
		int accNumB2 = randBetween(1, 1000);
		BankAccount bankB2 = new BankAccount(cardB2, "pwB2", 3000);
		Card cardB3 = new Card("Captain America",
				String.valueOf(5600000000000000L + (long) (Math.random() * 100000000000000L)), randBetween(1, 12),
				randBetween(2017, 2022));
		int accNumB3 = randBetween(1, 1000);
		BankAccount bankB3 = new BankAccount(cardB3, "pwB3", 2000);
		b.addAccountToBankB(accNumB1, bankB1);
		b.addAccountToBankB(accNumB2, bankB2);
		b.addAccountToBankB(accNumB3, bankB3);

		// prints states of banks and atm's
		a.printAllBankAccountsOfA();
		b.printAllBankAccountsOfB();
		ATM.printATMStates();
		boolean run = true;
		while (run) {
			sop("There are 4 ATM's. Press '1' or '2' for Bank A, or '3' or '4' for Bank B.");
			sop("To quit, press 'Q'.");
			String atm = in.next().toLowerCase();
			while (true) {
				String option;
				String next = in.nextLine();
				// ATM's access to BANK A.
				if (atm.equals("1") || atm.equals("2")) {
					ATM atmA = new ATM();
					printMainMenu();
					option = in.nextLine().toLowerCase();
					// allows customers to create new bank accounts.
					if (option.equals("c")) {
						sop("Enter your full name: ");
						String name = in.nextLine().toLowerCase();
						// checks for existing accounts.
						if (a.isCurrentCustomerA(name) == true) {
							sop("Sorry, you already created an account with this bank.");
							sop("Check with Bank B.");
							sop("Press 'Enter' again for main menu: ");
							// randomizes a new cash card for A customers.
						} else {
							long last14A = (long) (Math.random() * 100000000000000L);
							String cardNumA = String.valueOf(5200000000000000L + last14A);
							int month = randBetween(1, 12);
							int year = randBetween(2017, 2022);
							Card cardA = new Card(name, cardNumA, month, year);
							int accNumA = randBetween(1, 1000);
							sop("Enter a password for your bank's account: ");
							String password = in.nextLine();
							sop("Enter deposited amount to start with: ");
							double startingBalance = in.nextDouble();
							BankAccount bankA = new BankAccount(cardA, password, startingBalance);
							sop("Your cash card will be: " + cardNum + ".");
							sop("You cash card's expiration date: " + cardA.getMonth() + "/" + cardA.getYear());
							sop("Your account number will be: " + accNumA + ".");
							sop("Press 'Enter' again for main menu: \n");
							a.addAccountToBankA(accNumA, bankA);
						}
						// allows A customers to insert their cards for withdrawal.
					} else if (option.equals("i")) {
						sop("Enter you cash card: ");
						String cardNumIn = in.nextLine();
						String first2Digits = cardNumIn.substring(0, 2);
						String password;
						double withdrawal;
						int accountNum;
						boolean keepWithdrawA = true;
						if ((atmA.isBankAID(first2Digits)) == true) {
							sop("This card associates with Bank A.");
							// checks for expiration dates.
							if (a.isExpDateA(cardNumIn) == true) {
								sop("Your card has expired.");
								sop("Press 'Enter' again for main menu: \n");
							} else {
								sop("Your card is valid.");
								sop("Enter your account number: ");
								accountNum = in.nextInt();
								// when account number of A matches.
								if (a.isAccNumA(accountNum) == true) {
									sop("Please enter your password: ");
									next = in.nextLine();
									password = in.next();
									while (keepWithdrawA) {
										// when password of A matches.
										if (a.isPasswordA(password, accountNum) == true) {
											sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
											next = in.next().toLowerCase();
											if (next.equals("q")) {
												keepWithdrawA = false;
												break;
												// either pass or no pass with withdrawal check.
											} else {
												withdrawal = Double.parseDouble(next);
												if (atmA.isExceedWithdrawalA(withdrawal)) {
													sop("Entered amount exceeded transaction limit.");
												} else if (withdrawal <= 350
														&& a.isWithinWithdrawalLimitA(withdrawal, accountNum)) {
													a.withdrawalRequestA(accountNum, withdrawal);
												}
											}
											// when password of A doesn't match.
										} else {
											sop("Entered password doesn't match the cash card. Please re-enter your password: ");
											password = in.next();
											if (a.isPasswordA(password, accountNum) == true) {
												sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
												next = in.next().toLowerCase();
												if (next.equals("q")) {
													keepWithdrawA = false;
													sop("Press 'Enter' again for main menu: ");
													break;
													// either pass or no pass with withdrawal check.
												} else {
													withdrawal = Double.parseDouble(next);
													if (atmA.isExceedWithdrawalA(withdrawal)) {
														sop("Entered amount exceeded transaction limit.");
													} else if (withdrawal <= 350
															&& a.isWithinWithdrawalLimitA(withdrawal, accountNum)) {
														a.withdrawalRequestA(accountNum, withdrawal);
													}
												}
											}
										}
									}
									// when account number of A doesn't match.
								} else {
									sop("Entered account number doesn't match. Re-enter your account number: ");
									accountNum = in.nextInt();
									sop("Please enter your password: ");
									password = in.next();
									while (keepWithdrawA) {
										// when password of A matches.
										if (a.isPasswordA(password, accountNum) == true) {
											sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
											next = in.next().toLowerCase();
											if (next.equals("q")) {
												keepWithdrawA = false;
												break;
												// either pass or no pass with withdrawal check.
											} else {
												withdrawal = Double.parseDouble(next);
												if (atmA.isExceedWithdrawalA(withdrawal)) {
													sop("Entered amount exceeded transaction limit. ");
												} else if (withdrawal <= 350
														&& a.isWithinWithdrawalLimitA(withdrawal, accountNum)) {
													a.withdrawalRequestA(accountNum, withdrawal);
												}
											}
											// when password of A doesn't match.
										} else {
											sop("Entered password doesn't match the cash card. Please re-enter your password: ");
											password = in.next();
											if (a.isPasswordA(password, accountNum) == true) {
												sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
												next = in.next().toLowerCase();
												if (next.equals("q")) {
													keepWithdrawA = false;
													sop("Press 'Enter' again for main menu: ");
													break;
													// either pass or no pass with withdrawal check.
												} else {
													withdrawal = Double.parseDouble(next);
													if (atmA.isExceedWithdrawalA(withdrawal)) {
														sop("Entered amount exceeded transaction limit.");
													} else if (withdrawal <= 350
															&& a.isWithinWithdrawalLimitA(withdrawal, accountNum)) {
														a.withdrawalRequestA(accountNum, withdrawal);
													}
												}
											}
										}
									}
								}
							}
						}
						else if ((atmA.isBankBID(first2Digits)) == true){
							System.out.println("This card associates with Bank B and is not supported by this ATM.");
							sop("Press 'Enter' again for main menu: ");
						}
						// allows to view all existing accounts in Bank A. [to check if all A accounts are in]
					} else if (option.equals("v")) {
						a.printAccListA();
						sop("Press 'Enter' again for main menu: ");
						// allows customers to get their cards back.
					} else if (option.equals("w")) {
						sop("Your cash card has been dispensed from Bank A.");
						sop("");
						break;
					}
					// ATM's access to BANK B.
				} else if (atm.equals("3") || atm.equals("4")) {
					ATM atmB = new ATM();
					printMainMenu();
					option = in.nextLine().toLowerCase();
					// allows customers to create new bank accounts.
					if (option.equals("c")) {
						sop("Enter your full name: ");
						String name = in.nextLine().toLowerCase();
						// checks for existing accounts.
						if (b.isCurrentCustomerB(name) == true) {
							sop("Sorry, you already created an account with this bank.");
							sop("Check with Bank A.");
							sop("Press 'Enter' again for main menu: ");
							// randomizes a new cash card for B customers.
						} else {
							long last14B = (long) (Math.random() * 100000000000000L);
							String cardNumB = String.valueOf(56000000000000000L + last14B);
							int month = randBetween(1, 12);
							int year = randBetween(2017, 2022);
							Card cardB = new Card(name, cardNumB, month, year);
							int accNumB = randBetween(1, 1000);
							sop("Enter a password for your bank's account: ");
							String password = in.nextLine();
							sop("Enter deposited amount to start with: ");
							double startingBalance = in.nextDouble();
							BankAccount bankB = new BankAccount(cardB, password, startingBalance);
							sop("Your cash card will be: " + cardNum + ".");
							sop("You cash card's expiration date: " + cardB.getMonth() + "/" + cardB.getYear());
							sop("Your account number will be: " + accNumB + ".");
							sop("Press 'Enter' again for main menu: \n");
							b.addAccountToBankB(accNumB, bankB);
						}
						// allows B customers to insert their cards for
						// withdrawal.
					} else if (option.equals("i")) {
						sop("Enter you cash card: ");
						String cardNumIn = in.nextLine();
						String first2Digits = cardNumIn.substring(0, 2);
						String password;
						double withdrawal;
						int accountNum;
						boolean keepWithdrawB = true;
						if ((atmB.isBankBID(first2Digits)) == true) {
							sop("This card associates with Bank B.");
							// checks for expiration dates.
							if (b.isExpDateB(cardNumIn) == true) {
								sop("Your card has expired.");
								sop("Press 'Enter' again for main menu: \n");
							} else {
								sop("Your card is valid.");
								sop("Enter your account number: ");
								accountNum = in.nextInt();
								// when account number of B matches.
								if (b.isAccNumB(accountNum) == true) {
									sop("Please enter your password: ");
									next = in.nextLine();
									password = in.next();
									while (keepWithdrawB) {
										// when password of B matches.
										if (b.isPasswordB(password, accountNum) == true) {
											sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
											next = in.next().toLowerCase();
											if (next.equals("q")) {
												keepWithdrawB = false;
												break;
												// either pass or no pass with withdrawal check.
											} else {
												withdrawal = Double.parseDouble(next);
												if (atmB.isExceedWithdrawalB(withdrawal)) {
													sop("Entered amount exceeded transaction limit.");
												} else if (withdrawal <= 300
														&& b.isWithinWithdrawalLimitB(withdrawal, accountNum)) {
													b.withdrawalRequestB(accountNum, withdrawal);
												}
											}
											// when password of B doesn't match.
										} else {
											sop("Entered password doesn't match the cash card. Please re-enter your password: ");
											password = in.next();
											if (b.isPasswordB(password, accountNum) == true) {
												sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
												next = in.next().toLowerCase();
												if (next.equals("q")) {
													keepWithdrawB = false;
													sop("Press 'Enter' again for main menu: ");
													break;
													// either pass or no pass with withdrawal check.
												} else {
													withdrawal = Double.parseDouble(next);
													if (atmB.isExceedWithdrawalB(withdrawal)) {
														sop("Entered amount exceeded transaction limit.");
													} else if (withdrawal <= 300
															&& b.isWithinWithdrawalLimitB(withdrawal, accountNum)) {
														b.withdrawalRequestB(accountNum, withdrawal);
													}
												}
											}
										}
									}
									// when account number of B doesn't match.
								} else {
									sop("Entered account number doesn't match. Re-enter your account number: ");
									accountNum = in.nextInt();
									sop("Please enter your password: ");
									password = in.next();
									while (keepWithdrawB) {
										// when password of B matches.
										if (b.isPasswordB(password, accountNum) == true) {
											sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
											next = in.next().toLowerCase();
											if (next.equals("q")) {
												keepWithdrawB = false;
												break;
												// either pass or no pass with withdrawal check.
											} else {
												withdrawal = Double.parseDouble(next);
												if (atmB.isExceedWithdrawalB(withdrawal)) {
													sop("Entered amount exceeded transaction limit.");
												} else if (withdrawal <= 300
														&& b.isWithinWithdrawalLimitB(withdrawal, accountNum)) {
													b.withdrawalRequestB(accountNum, withdrawal);
												}
											}
											// when password of B doesn't match.
										} else {
											sop("Entered password doesn't match the cash card. Please re-enter your password: ");
											password = in.next();
											if (b.isPasswordB(password, accountNum) == true) {
												sop("[Authorization-Accepted] Please enter the amount to withdraw or [Q]uit");
												next = in.next().toLowerCase();
												if (next.equals("q")) {
													keepWithdrawB = false;
													sop("Press 'Enter' again for main menu: ");
													break;
													// either pass or no pass with withdrawal check.
												} else {
													withdrawal = Double.parseDouble(next);
													if (atmB.isExceedWithdrawalB(withdrawal)) {
														sop("Entered amount exceeded transaction limit.");
													} else if (withdrawal <= 300
															&& b.isWithinWithdrawalLimitB(withdrawal, accountNum)) {
														b.withdrawalRequestB(accountNum, withdrawal);
													}
												}
											}
										}
									}
								}
							}			
						}
						else if ((atmB.isBankAID(first2Digits)) == true){
							System.out.println("This card associates with Bank A and is not supported by this ATM.");
							sop("Press 'Enter' again for main menu: ");
						}
						// allows to view all existing accounts in Bank B. [to check if all B accounts are in]
					} else if (option.equals("v")) {
						b.printAccListB();
						sop("Press 'Enter' again for main menu: ");
						// allows customers to get their cards back.
					} else if (option.equals("w")) {
						sop("Your cash card has been dispensed from Bank B.");
						sop("");
						break;
					}
					// quits overall program.
				} else if (atm.equals("q")) {
					run = false;
					break;
					// return to main options of choosing ATMS.
				} else {
					sop("Please re-enter '1' or '2' for Bank A, '3' or '4' for Bank B.");
					atm = in.next();
				}
			}
		}
		// closes Scanner.
		in.close();
	}

	/**
	 * Shortcut method to print prompts. 
	 * @param str the text to print
	 */
	public static void sop(String str) {
		System.out.println(str);
	}

	/**
	 * Randomizes a number between the starting time and the ending time.
	 * @param start any time after the stated start number
	 * @param end any time before the stated end number
	 * @return the random number
	 */
	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	/**
	 * Prints the main menu with several options.
	 */
	public static void printMainMenu() {
		sop("Select one of the following options: ");
		sop("[C]reate a bank account\t  [I]nsert a cash card\t [V]iew all accounts of this bank \t[W]ithdraw cash card");
	}
}
