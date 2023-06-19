package main;

import java.util.Comparator;

public class CompareByPerimeter implements Comparator<Drawable> {
	public int compare(Drawable first, Drawable second) {
		if (first.getPerimeter() > second.getPerimeter()) {
			return 1;
		}
		if (first.getPerimeter() < second.getPerimeter()) {
			return -1;
		}
		return 0;
	}
}
