package com.greatlearning.LabDSA10Oct21;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {
	
	public boolean checkBalancedBrackets(String bracket) {
		
		//checking the Input String has Balanced Brackets using Stack
		
		Stack <Character> stack = new Stack <Character>();

		for (int i = 0; i < bracket.length(); i++) {
		
			char ch = bracket.charAt(i);

			if(ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
				continue;
			}
			else {

				if(stack.isEmpty() == true) {
					return false;
				}

				char localCh = stack.pop();

				switch(ch) {

				case ')' : 
				{
					if (localCh != '(') {
						return false;
					}
					break;
				}

				case ']' :
				{
					if (localCh != '[') {
						return false;
					}
					break;
				}
				
				case '}' :
				{
					if(localCh != '{') { 
						return false;
					}
					break;
				}
				}
			}

		}
		
		return stack.isEmpty();
	}


	public static void main(String[] args) {

		BalancingBrackets balancedbracket = new BalancingBrackets();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Key in the brackets as a String to check");

		String brackets = scanner.next();

		boolean result = balancedbracket.checkBalancedBrackets(brackets);

		System.out.print("The entered string " + brackets);
		
		if (result == true) {
			
			System.out.println(" has Balanced Brackets");
		}
		else {
			
			System.out.println(" do not contain Balanced Brackets");
		}

		scanner.close();

	}

}
