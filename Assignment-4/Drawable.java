package main;

import java.awt.Color;

/**
 * Drawable Interface
 * 
 * Defines the contract for geometric shapes that can be rendered on screen.
 * All drawable shapes must provide color, fill status, area, and perimeter
 * information.
 * 
 * @author University Assignment
 * @version 1.0
 */
public interface Drawable {

	/**
	 * Gets the color of this drawable shape.
	 * 
	 * @return The color used to render this shape
	 */
	public Color getColor();

	/**
	 * Determines if this shape should be filled or just outlined.
	 * 
	 * @return true if the shape should be filled, false for outline only
	 */
	public boolean getFill();

	/**
	 * Calculates the area of this shape.
	 * 
	 * @return The area in square pixels
	 */
	public double getArea();

	/**
	 * Calculates the perimeter of this shape.
	 * 
	 * @return The perimeter in pixels
	 */
	public double getPerimeter();
}
