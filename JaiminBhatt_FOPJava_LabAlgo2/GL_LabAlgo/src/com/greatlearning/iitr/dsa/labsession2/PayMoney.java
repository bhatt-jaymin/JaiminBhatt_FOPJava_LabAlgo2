package com.greatlearning.iitr.dsa.labsession2;

import java.util.*;

/**
 * 
 * @author Jaimin Bhatt
 * @version 1.0
 * @since 2023-04-03
 */

/*
 * node class represents a node in the doubly linked list. It contains the data
 * and references to the before and next nodes.
 */

class Node {
	int datalist;
	Node before;
	Node come;

	Node(int data) {
		this.datalist = data;
		before = null;
		come = null;
	}
}

/*
 * The PayMoney class represents the doubly linked list. It contains
 * the head and tail nodes, the size of the list, and the transaction array and
 * target values that are passed as inputs.
 */
public class PayMoney {
	Node hd, tl; // here hd means Head and tl means Tail
	int size;
	int[] tranarry;
	int trgt;

	PayMoney(int[] tranarry, int trgt) {
		this.tranarry = tranarry;
		this.trgt = trgt;
		generatedoublylinkedlist();
	}

	/*
	 * The generatedoublylinkedlist() method creates the doubly linked list by
	 * iterating through the transaction array and adding nodes to the list.
	 */
	void generatedoublylinkedlist() {
		for (int element : tranarry) {
			Node node = new Node(element);
			if (hd == null) {
				hd = tl = node;
			} else {
				tl.come = node;
				node.before = tl;
				tl = node;
			}
			size++;
		}
	}

	/*
	 * The findTargetTransactions() method iterates through the nodes in the list,
	 * calculates the sum of the transactions, and counts the number of
	 * transactions. If the sum is greater than or equal to the target, it prints
	 * the number of transactions it took to achieve the target. Otherwise, it
	 * prints that the target was not achieved.
	 */
	void findtargettTransactions() {
		int add = 0;
		int count = 0;
		Node cur = hd;
		while (cur != null) {
			add += cur.datalist;
			count++;
			if (add >= trgt) {
				System.out.println("Target achieved after " + count + " transactions");
				return;
			}
			cur = cur.come;
		}
		System.out.println("Given target is not achieved");
	}

	/*
	 * In the main() method, the program prompts the user to enter the size of the
	 * transaction array, the values of the array, and the number of targets to
	 * achieve. For each target, it prompts the user to enter the target value,
	 * creates a new instance of DoublyLinkedList, and calls the
	 * findTargetTransactions() method to find the number of transactions it took to
	 * achieve the target.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the size of transaction array");
		int size = scanner.nextInt();

		int[] tranarry = new int[size];
		System.out.println("enter the values of array");
		for (int i = 0; i < size; i++) {
			tranarry[i] = scanner.nextInt();
		}
		System.out.println("enter the total no of targets that needs to be achieved");
		int targetnumber = scanner.nextInt();
		for (int i = 0; i < targetnumber; i++) {
			System.out.println("enter the value of target");
			int trgt = scanner.nextInt();
			PayMoney paymoney = new PayMoney(tranarry, trgt);
			paymoney.findtargettTransactions();

		}
		scanner.close();
	}

}
