package EX3;

public class Rational {
	private int num = 0;
	private int den = 0;

	public Rational(int x, int y) {
		if (y == 0) {
			System.out.println("Unable to enter value 0");
			y = 1;
		}
		this.den = y;
		this.num = x;

	}

	public void setDenominator(int i) {
		this.den = i;
	}

	public int getDenominator() {
		return den;
	}

	public void setNumerator(int i) {
		this.num = i;

	}

	public int getNumerator(int i) {
		return num;
	}

	@Override
	public String toString() {
		return this.num + "/" + this.den;
	}

	public int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public String Fraction() {
		int a = this.num;
		int b = this.den;
		int gcd = gcd(a, b);
		return (a / gcd) + "/" + (b / gcd);
	}

}
