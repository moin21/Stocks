package com.stocks;

import java.util.Scanner;

public class Account {
	static int amount = 0;

	Scanner scan = new Scanner(System.in);
	StockManager sp = new StockManager();
	/*
	 * creating object
	 */

	public static int getAmount() {
		return amount;
	}

	public static void setAmount(int amount) {
		Account.amount = amount;
	}

	/*
	 * method to credit account
	 */
	public void credit() {
		System.out.print(" Please enter the amount to credit: ");
		double credit_value = scan.nextDouble();
		/*
		 * add credit amount to account
		 */
		amount += credit_value;
		System.out.println(" The current balance is : " + amount);
	}

	/*
	 * method to debit account
	 */
	public void debit() {
		System.out.print(" Please enter the amount to debit: ");
		double debit_value = scan.nextDouble();
		/*
		 * checking if the account balance is less than 0 after debit
		 */
		if (amount - debit_value < 0) {
			System.out.println(" Insufficient funds ");
			return;
		}
		/*
		 * debit the amount from account
		 */
		amount -= debit_value; //
		System.out.println(" The current balance is : " + amount);

	}

	/*
	 * checking account balance
	 */
	public void amountUpdate() {
		System.out.println(" The Account balance is : " + amount);
	}
}
