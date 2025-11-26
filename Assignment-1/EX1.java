package ex1;

/**
 * Assignment 1: Fundamental Algorithms
 * 
 * This class demonstrates four classic algorithmic problems:
 * 1. Digit Sum Reduction - Reduces a number to a single digit by repeatedly summing its digits
 * 2. Happy Number Detection - Determines if a number is "happy" (eventually reaches 1 when replacing 
 *    the number by the sum of squares of its digits)
 * 3. Palindrome Check - Verifies if a number reads the same forwards and backwards
 * 4. Josephus Problem - Finds the survivor position in a circle elimination problem
 * 
 * @author University Assignment
 * @version 1.0
 */
public class EX1 {

	/**
	 * Main method that executes all four algorithmic demonstrations.
	 * Each algorithm prompts the user for input and displays the result.
	 * 
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args) {

		// ========== Algorithm 1: Digit Sum Reduction ==========
		// Repeatedly sum the digits of a number until a single digit remains.
		// Example: 987 -> 9+8+7=24 -> 2+4=6
		// For negative numbers, preserve the sign in the final result.

		int digitSum = 0;
		int inputNumber = MyConsole.readInt("Hi, enter a number");
		
		if (inputNumber < 0) {
			// Handle negative numbers by working with absolute value
			inputNumber = inputNumber * (-1);
			if (inputNumber < 10)
				System.out.println("The sum of digits is: " + inputNumber * (-1));
			else {
				// Repeatedly sum digits until single digit remains
				while (inputNumber > 0) {
					digitSum += inputNumber % 10;
					inputNumber = inputNumber / 10;
					// If processed all digits but result is still multi-digit, continue
					if (inputNumber == 0 && digitSum > 9) {
						inputNumber = digitSum;
						digitSum = 0;
					}
				}
				// Restore negative sign
				System.out.println("The sum of digits is: " + digitSum * (-1));
			}
		} else if (inputNumber < 10) {
			System.out.println("The sum of digits is: " + inputNumber);
		} else {
			// Positive multi-digit number
			while (inputNumber > 0) {
				digitSum += inputNumber % 10;
				inputNumber = inputNumber / 10;
				if (inputNumber == 0 && digitSum > 9) {
					inputNumber = digitSum;
					digitSum = 0;
				}
			}
			System.out.println("The sum of digits is: " + digitSum);
		}

		// ========== Algorithm 2: Happy Number Detection ==========
		// A happy number is defined by repeatedly replacing it with the sum of squares
		// of its digits until it equals 1 (happy) or loops endlessly (unhappy).
		// All unhappy numbers eventually reach the cycle 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
		// Example: 7 is happy: 7 → 49 → 97 → 130 → 10 → 1

		int sumOfSquares = 0;
		int originalNumber = MyConsole.readInt("Hi, enter a number");
		int workingNumber = originalNumber;
		
		if (originalNumber == 1) {
			System.out.println("True");
		} else {
			while (workingNumber > 0) {
				// Sum the square of each digit
				sumOfSquares += (workingNumber % 10) * (workingNumber % 10);
				workingNumber = workingNumber / 10;
				
				if (workingNumber == 0 && sumOfSquares > 1) {
					// If we reach 4, we're in the unhappy cycle
					if (sumOfSquares == 4)
						break;
					// Continue with the new number
					workingNumber = sumOfSquares;
					sumOfSquares = 0;
				}
			}
			
			if (sumOfSquares == 1) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}

		// ========== Algorithm 3: Palindrome Check ==========
		// Determines if a number reads the same forwards and backwards.
		// Example: 12321 is a palindrome, 12345 is not.

		int originalValue = 0;
		int reversedNumber = 0;
		int userInput = MyConsole.readInt("Hi, enter a number");
		originalValue = userInput;
		
		// Build the reversed number digit by digit
		while (userInput > 0) {
			reversedNumber = (reversedNumber * 10) + (userInput % 10);
			userInput = userInput / 10;
		}
		
		// Compare original and reversed
		if (reversedNumber == originalValue) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

		// ========== Algorithm 4: Josephus Problem ==========
		// In a circle of n people, eliminate every 2nd person until only one remains.
		// This finds the survivor's position (1-indexed).
		// The solution uses the formula: J(n) = 2 * (n - 2^floor(log2(n))) + 1

		int largestPowerOfTwo = 1;
		int exponent = 0;
		int numberOfPeople = MyConsole.readInt("Enter number of people");
		
		// Find the largest power of 2 less than or equal to numberOfPeople
		exponent = (int) (Math.log(numberOfPeople) / Math.log(2));
		for (int i = 0; i < exponent; i++) {
			largestPowerOfTwo *= 2;
		}
		
		// Apply Josephus formula
		numberOfPeople = ((numberOfPeople - largestPowerOfTwo) * 2) + 1;
		System.out.println("The winner is: " + numberOfPeople);

	}
}
