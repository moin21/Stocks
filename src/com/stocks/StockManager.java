package com.stocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockManager {
	/*
	 * ArrayList for maintaining the stocks data
	 */
	List<StockPortfolio> stocks = new ArrayList<StockPortfolio>();
	StockPortfolio stock = new StockPortfolio();

	double total_value = 0;

	public void addStock() {
		/*
		 * checking if the total balance is less than account balance
		 */
		if (StockPortfolio.getTotal_value() < Account.getAmount() || Account.getAmount() > 1) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter total number of stocks to buy : ");
			int s = sc.nextInt();
			double value = 0;
			/*
			 * loop to ask user to add number of stocks
			 */
			for (int i = 0; i < s; i++) {
				/*
				 * creating the object of StockPortfolio
				 */
				StockPortfolio stock = new StockPortfolio();
				System.out.println("Please enter the name of the script: ");
				stock.setStockName(sc.next());
				System.out.println("Please enter the total number of shares you want to buy: ");
				stock.setQuantity(sc.nextInt());
				System.out.println("Please enter the price per share: ");
				stock.setPerSharePrice(sc.nextDouble());

				value = stock.getQuantity() * stock.getPerSharePrice();
				if (value < Account.getAmount()) {
					stock.setTotalSharePrice(value);
					Account.amount -= value;
					stocks.add(stock);
					total_value += value;
					StockPortfolio.setTotal_value(total_value);
				} else {
					System.out.println("Sorry!! Insufficient balance to add stock");
					break;
				}
			}
		} else {
			System.out.println("Unable to add share due to insufficient balance in account. Please credit amount!!");
		}
	}

	public void printStock() {
		/*
		 * for printing the stocks report
		 */
		for (StockPortfolio stocks : stocks) {
			System.out.println(stocks);
		}
		System.out.println(" \n Total value of stock in your trading account is: " + StockPortfolio.getTotal_value());

	}
}
