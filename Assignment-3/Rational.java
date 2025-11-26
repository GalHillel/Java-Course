package EX3;

/**
 * Rational Number Representation
 * 
 * This class represents a rational number (fraction) with a numerator and
 * denominator.
 * Provides methods for accessing components and simplifying fractions using the
 * Greatest Common Divisor (GCD) algorithm.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class Rational {
	private int numerator = 0;
	private int denominator = 0;

	/**
	 * Constructs a new Rational number.
	 * 
	 * @param numerator   The numerator (top part of the fraction)
	 * @param denominator The denominator (bottom part of the fraction)
	 *                    Cannot be zero; if zero is provided, defaults to 1
	 */
	public Rational(int numerator, int denominator) {
		if (denominator == 0) {
			System.out.println("Unable to enter value 0");
			denominator = 1;
		}
		this.denominator = denominator;
		this.numerator = numerator;
	}

	/**
	 * Sets the denominator value.
	 * 
	 * @param denominator New denominator value
	 */
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	/**
	 * Gets the current denominator value.
	 * 
	 * @return The denominator
	 */
	public int getDenominator() {
		return denominator;
	}

	/**
	 * Sets the numerator value.
	 * 
	 * @param numerator New numerator value
	 */
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	/**
	 * Gets the current numerator value.
	 * 
	 * @return The numerator
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * Returns a string representation of the rational number.
	 * 
	 * @return String in the format "numerator/denominator"
	 */
	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}

	/**
	 * Calculates the Greatest Common Divisor (GCD) using Euclidean algorithm.
	 * 
	 * Uses recursive approach: gcd(a, b) = gcd(b, a mod b) until b = 0
	 * 
	 * @param a First number
	 * @param b Second number
	 * @return The GCD of a and b
	 */
	public int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	/**
	 * Returns the simplified (reduced) form of this rational number.
	 * 
	 * Divides both numerator and denominator by their GCD to get
	 * the fraction in lowest terms.
	 * 
	 * @return String representation of the simplified fraction
	 *         "numerator/denominator"
	 */
	public String toSimplifiedString() {
		int num = this.numerator;
		int den = this.denominator;
		int commonDivisor = gcd(num, den);
		return (num / commonDivisor) + "/" + (den / commonDivisor);
	}
}
