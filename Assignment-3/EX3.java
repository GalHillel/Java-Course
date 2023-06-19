package EX3;

import java.util.ArrayList;

public class EX3 {

	// Solution 1
	public static String[] sentence(String S) {
		ArrayList<String> Words = new ArrayList<String>();
		String NewS = "";
		for (int j = 0; j < S.length(); j++) {
			if (S.charAt(j) != ' ' && S.charAt(j) != '.' && S.charAt(j) != ',') {
				NewS += S.charAt(j);
			} else {
				if (NewS.length() > 0) {
					Words.add(NewS);
					NewS = "";
				}
			}
		}
		Words.add(NewS);
		String[] sen = new String[Words.size()];
		for (int i = 0; i < Words.size(); i++) {
			sen[i] = Words.get(i);
		}
		return sen;
	}

	// Solution 2
	public static String[] dictionary(String s) {
		ArrayList<String> D = new ArrayList<String>();
		ArrayList<String> A = new ArrayList<String>();
		String temp = "";
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) != ' ' && s.charAt(j) != '.' && s.charAt(j) != ',') {
				temp += s.charAt(j);
				temp = temp.toLowerCase();
			} else {
				if (temp.length() > 0) {
					D.add(temp);
					temp = "";
				}
			}
		}
		D.add(temp);
		String[] Dictionary = new String[D.size()];
		for (int i = 0; i < D.size(); i++) {
			Dictionary[i] = D.get(i);
		}
		for (int i = 0; i < Dictionary.length - 1; i++) {
			for (int j = i + 1; j < Dictionary.length; j++) {
				if (Dictionary[i].compareTo(Dictionary[j]) > 0) {
					temp = Dictionary[i];
					Dictionary[i] = Dictionary[j];
					Dictionary[j] = temp;
				}
			}
		}
		A.add(Dictionary[0]);
		for (int i = 1; i < Dictionary.length - 1; i++) {
			if (Dictionary[i].compareTo(Dictionary[i + 1]) != 0 && Dictionary[i].compareTo(Dictionary[i - 1]) != 0) {
				A.add(Dictionary[i]);
			}
			if (i == Dictionary.length - 2) {
				A.add(Dictionary[i + 1]);
			}
		}
		String[] B = new String[A.size()];
		for (int i = 0; i < A.size(); i++) {
			B[i] = A.get(i);
		}
		return B;
	}

}
