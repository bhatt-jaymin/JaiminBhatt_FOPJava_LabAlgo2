package com.greatlearning.iitr.dsa.labsession2;

import java.util.*;

/**
 * 
 * @author Jaimin Bhatt
 * @version 1.0
 * @since 2023-04-03
 */

/*
 * The program first prompts the user to enter the size of the currency
 * denominations, followed by the values of the denominations in random order.
 * It then prompts the user to enter the amount they want to pay.
 * 
 */

public class PaymentApproach {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of currency denominations: ");
		int n = sc.nextInt();
		int[] currencies = new int[n];
		System.out.println("Enter the currency denominations value:");
		for (int i = 0; i < n; i++) {
			currencies[i] = sc.nextInt();
		}
		Arrays.sort(currencies); // sort in ascending order
		System.out.print("Enter the amount you want to pay: ");
		int amount = sc.nextInt();

		/*
		 * The program then sorts the currency denominations in ascending order, which
		 * allows us to start from the highest denomination when making payment. It then
		 * uses a stack to keep track of the denominations used to make payment.
		 * 
		 */

		Stack<Integer> notes = new Stack<>();
		int remaining = amount;
		int i = n - 1; // start from highest denomination
		while (i >= 0 && remaining > 0) {
			int denom = currencies[i];
			if (denom <= remaining) {
				int count = remaining / denom;
				remaining %= denom;
				notes.push(denom);

				/*
				 * loop through the currency denominations in descending order (starting from
				 * the highest denomination), and for each denomination, we check if it is less
				 * than or equal to the remaining amount to be paid. If so, we calculate the
				 * number of notes of that denomination needed to pay the remaining amount,
				 * update the remaining amount, push the denomination onto the stack, and print
				 * the denomination and the count of notes used.
				 */

				System.out.println(denom + ":" + count); // Finally, the program prints the minimum number of notes used
															// to pay the net amount.

			}
			i--;
			sc.close();
		}
	}
}
