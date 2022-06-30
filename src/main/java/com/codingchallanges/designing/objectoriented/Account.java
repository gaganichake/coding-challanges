package com.codingchallanges.designing.objectoriented;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * CreditKarma coding challenge - Nov 8, 2021
 * 
 * Expected output (any order):
 * Citibank: deleted
 * Chase Freedome: -1000
 * American Express: added
 */

public class Account {

	//Code provided in the problem: start
	enum CardType {
		CREDIT_CARD, SAVING, CHECKING
	}

	private double balance;
	private String name;
	private CardType cardType;
	private long accountOpened;

	public Account(double balance, String name, CardType cardType, long accountOpened) {
		super();
		this.balance = balance;
		this.name = name;
		this.cardType = cardType;
		this.accountOpened = accountOpened;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public long getAccountOpened() {
		return accountOpened;
	}

	public void setAccountOpened(long accountOpened) {
		this.accountOpened = accountOpened;
	}

	public static void main(String[] args) {

		List<Account> previousAccounts = Arrays.asList(
				new Account(2000.00, "Chase Freedome", CardType.CREDIT_CARD, 55555555),
				new Account(100.00, "Citibank", CardType.CREDIT_CARD, 888888888));

		List<Account> currentAccounts = Arrays.asList(
				new Account(1000.00, "Chase Freedome", CardType.CREDIT_CARD, 55555555),
				new Account(500.00, "American Express", CardType.CREDIT_CARD, 22222222));
//Code provided in the problem: end

		// Method implemented by me during the interview
		compareAndPrint(previousAccounts, currentAccounts);

		// Alternative (improved) method implemented by me after the interview
		compareAndPrint2(previousAccounts, currentAccounts);
	}

	// Method implemented by me during the interview
	private static void compareAndPrint(List<Account> previousAccounts, List<Account> currentAccounts) {

		Map<String, Account> prevMap = createMap(previousAccounts);
		Map<String, Account> currMap = createMap(currentAccounts);

		for (String key : prevMap.keySet()) {

			if (currMap.containsKey(key)) {
				System.out.println(prevMap.get(key).getName() + ": "
						+ (currMap.get(key).getBalance() - prevMap.get(key).getBalance()));
			} else {
				System.out.println(prevMap.get(key).getName() + ": deleted");
			}

		}

		for (String key : currMap.keySet()) {

			if (!prevMap.containsKey(key)) {
				System.out.println(currMap.get(key).getName() + ": added");
			}
		}

	}

	private static Map<String, Account> createMap(List<Account> currentAccounts) {

		Map<String, Account> map = new HashMap<>();

		for (Account account : currentAccounts) {

			String key = account.getName() + account.getCardType() + account.getAccountOpened();

			map.put(key, account);
		}

		return map;
	}

	// Alternative (improved) method implemented by me after the interview
	private static void compareAndPrint2(List<Account> previousAccounts, List<Account> currentAccounts) {
		Map<String, Account> currentAccountsMap = createMap(currentAccounts);

		for (Account prevAccount : previousAccounts) {

			if (currentAccounts.contains(prevAccount)) {
				String key = prevAccount.getName() + prevAccount.getCardType() + prevAccount.getAccountOpened();
				System.out.println(prevAccount.getName() + ": "
						+ (int) (currentAccountsMap.get(key).getBalance() - prevAccount.getBalance()));
			} else {
				System.out.println(prevAccount.getName() + ": deleted");
			}
		}

		for (Account currAccount : currentAccounts) {

			if (!previousAccounts.contains(currAccount)) {
				System.out.println(currAccount.getName() + ": added");
			}
		}
	}

	// Alternative code implemented by me after the interview
	@Override
	public boolean equals(Object obj) {

		Account account = obj instanceof Account ? ((Account) obj) : null;

		return account != null
				&& this.name.equals(account.getName())
				&& this.cardType.equals(account.getCardType())
				&& this.accountOpened == account.getAccountOpened();
	}

}
