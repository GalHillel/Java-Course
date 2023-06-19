package ex1;

public class EX1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Question 1

		int sum = 0, num = MyConsole.readInt("Hi, enter a number");
		if (num < 0) {
			num = num * (-1);
			if (num < 10)
				System.out.println("The sum of digits is: " + num * (-1));
			else {
				while (num > 0) {
					sum += (int) num % 10;
					num = (int) num / 10;
					if (num == 0 && sum > 9) {
						num = sum;
						sum = 0;
					}
				}
				System.out.println("The sum of digits is: " + sum * (-1));
			}
		} else if (num < 10)
			System.out.println("The sum of digits is: " + num);
		else {
			while (num > 0) {
				sum += (int) num % 10;
				num = (int) num / 10;
				if (num == 0 && sum > 9) {
					num = sum;
					sum = 0;
				}
			}
			System.out.println("The sum of digits is: " + sum);
		}

		// End solution 1

		// Question 2

		int square = 0, number = MyConsole.readInt("Hi, enter a number");
		int numb = number;
		if (number == 1)
			System.out.println("True");
		else {
			while (numb > 0) {
				square += (numb % 10) * (numb % 10);
				numb = numb / 10;
				if (numb == 0 && square > 1) {
					if (square == 4)
						break;
					numb = square;
					square = 0;

				}
			}
			if (square == 1) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}

		}
		// End solution 2

		// Question 3

		int newn = 0, poli = 0, num2 = MyConsole.readInt("Hi, enter a number");
		newn = num2;
		while (num2 > 0) {
			poli = (poli * 10) + (num2 % 10);
			num2 = num2 / 10;
		}
		if (poli == newn)
			System.out.println("True");
		else
			System.out.println("False");

		// End solution 3

		// Question 4

		int square1 = 1, m = 0, people = MyConsole.readInt("Enter number of people");
		m = (int) (Math.log(people) / Math.log(2));
		for (int i = 0; i < m; i++) {
			square1 *= 2;
		}
		people = ((people - square1) * 2) + 1;
		System.out.println("The winner is: " + people);

		// End solution 4

	}
}
