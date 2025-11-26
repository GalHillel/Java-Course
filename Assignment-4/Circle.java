package main;

import java.awt.Color;

/**
 * Circle Shape
 * 
 * Represents a circle defined by a center point and radius.
 * Implements both Drawable and Saveable interfaces.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class Circle implements Drawable, Saveable {

	// Data members
	private Point center;
	private int radius;
	private Color color;
	private boolean fill;

	/**
	 * Constructs a Circle with specified center, radius, color, and fill status.
	 * 
	 * @param center Center point of the circle
	 * @param radius Radius of the circle in pixels
	 * @param color  Color of the circle
	 * @param fill   Whether the circle should be filled or just outlined
	 */
	public Circle(Point center, int radius, Color color, boolean fill) {
		this.center = center;
		this.radius = radius;
		this.color = color;
		this.fill = fill;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public boolean getFill() {
		return fill;
	}

	/**
	 * Calculates the area of this circle using the formula: π * r²
	 * 
	 * @return Area of the circle in square pixels
	 */
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	/**
	 * Gets the center point of this circle.
	 * 
	 * @return Center point
	 */
	public Point getP() {
		return center;
	}

	/**
	 * Gets the radius of this circle.
	 * 
	 * @return Radius in pixels
	 */
	public int getRadius() {
		return radius;
	}

	@Override
	public String getFileText() {
		return "Circle*" + center.getFileText() + "*" + radius + "*" + Main.translateColor(color) + "*" + fill;
	}

	@Override
	public void loadFileText(String data) {
		String[] circleData = data.split("\\*");
		this.center = new Point(Integer.parseInt(circleData[1]), Integer.parseInt(circleData[2]),
				Main.translateColor(circleData[3]), Boolean.parseBoolean(circleData[4]));
		this.radius = Integer.parseInt(circleData[5]);
		this.color = Main.translateColor(circleData[6]);
		this.fill = Boolean.parseBoolean(circleData[7]);
	}

	/**
	 * Calculates the perimeter (circumference) of this circle using the formula: 2
	 * * π * r
	 * 
	 * @return Perimeter of the circle in pixels
	 */
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
}
