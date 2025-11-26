package main;

import java.util.Comparator;

/**
 * Perimeter-based Comparator for Drawable Shapes
 * 
 * Implements the Comparator pattern to enable sorting of Drawable shapes
 * by their perimeter in ascending order.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class CompareByPerimeter implements Comparator<Drawable> {

	/**
	 * Compares two Drawable shapes by their perimeter.
	 * 
	 * @param first  First shape to compare
	 * @param second Second shape to compare
	 * @return Positive if first > second, negative if first < second, 0 if equal
	 */
	@Override
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
