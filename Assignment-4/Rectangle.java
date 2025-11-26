package main;

import java.awt.Color;

/**
 * Rectangle Shape
 * 
 * Represents a rectangle defined by two opposite corner points.
 * Automatically calculates the other two corners.
 * Implements both Drawable and Saveable interfaces.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class Rectangle implements Drawable, Saveable {
	// Data members
	private Point corner0;
	private Point corner1;
	private Point corner2;
	private Point corner3;
	private Color color;
	private boolean fill;

	/**
	 * Constructs a Rectangle from two opposite corners.
	 * The other two corners are calculated automatically.
	 * 
	 * @param corner0 First corner point
	 * @param corner1 Opposite corner point
	 * @param color   Color of the rectangle
	 * @param fill    Whether the rectangle should be filled or just outlined
	 */
	public Rectangle(Point corner0, Point corner1, Color color, boolean fill) {
		this.corner0 = corner0;
		this.corner1 = corner1;
		this.color = color;
		this.fill = fill;
		this.corner2 = new Point(corner0.getX(), corner1.getY(), color, fill);
		this.corner3 = new Point(corner1.getX(), corner0.getY(), color, fill);
	}

	@Override
	public Color getColor() {
		return color;
	}

	/**
	 * Gets the X coordinates of all four corners.
	 * 
	 * @return Array of 4 X coordinates
	 */
	public int[] getXs() {
		int[] xCoordinates = new int[4];
		xCoordinates[0] = corner0.getX();
		xCoordinates[1] = corner1.getX();
		xCoordinates[2] = corner2.getX();
		xCoordinates[3] = corner3.getX();
		return xCoordinates;
	}

	/**
	 * Gets the Y coordinates of all four corners.
	 * 
	 * @return Array of 4 Y coordinates
	 */
	public int[] getYs() {
		int[] yCoordinates = new int[4];
		yCoordinates[0] = corner0.getY();
		yCoordinates[1] = corner1.getY();
		yCoordinates[2] = corner2.getY();
		yCoordinates[3] = corner3.getY();
		return yCoordinates;
	}

	@Override
	public boolean getFill() {
		return fill;
	}

	/**
	 * Calculates the area using: |width * height|
	 * 
	 * @return Area of the rectangle in square pixels
	 */
	@Override
	public double getArea() {
		return Math.abs((corner1.getX() - corner0.getX()) * (corner1.getY() - corner0.getY()));
	}

	@Override
	public String getFileText() {
		return "Rectangle*" + corner0.getFileText() + "*" + corner1.getFileText() + "*" + Main.translateColor(color)
				+ "*" + fill;
	}

	@Override
	public void loadFileText(String data) {
		String[] rectangleData = data.split("\\*");
		this.corner0 = new Point(Integer.parseInt(rectangleData[1]), Integer.parseInt(rectangleData[2]),
				Main.translateColor(rectangleData[3]), Boolean.parseBoolean(rectangleData[4]));
		this.corner1 = new Point(Integer.parseInt(rectangleData[5]), Integer.parseInt(rectangleData[6]),
				Main.translateColor(rectangleData[7]), Boolean.parseBoolean(rectangleData[8]));
		this.color = Main.translateColor(rectangleData[9]);
		this.fill = Boolean.parseBoolean(rectangleData[10]);
		this.corner2 = new Point(corner1.getX(), corner0.getY(), color, fill);
		this.corner3 = new Point(corner0.getX(), corner1.getY(), color, fill);
	}

	/**
	 * Gets the X coordinate of the primary corner.
	 * 
	 * @return X coordinate
	 */
	public int getX() {
		return corner0.getX();
	}

	/**
	 * Gets the Y coordinate of the primary corner.
	 * 
	 * @return Y coordinate
	 */
	public int getY() {
		return corner0.getY();
	}

	/**
	 * Gets the height of the rectangle.
	 * 
	 * @return Height in pixels
	 */
	public int getHeight() {
		return Math.abs(corner0.getY() - corner1.getY());
	}

	/**
	 * Gets the width of the rectangle.
	 * 
	 * @return Width in pixels
	 */
	public int getWidth() {
		return Math.abs(corner0.getX() - corner1.getX());
	}

	/**
	 * Calculates the perimeter using: 2 * (width + height)
	 * 
	 * @return Perimeter in pixels
	 */
	@Override
	public double getPerimeter() {
		return 2 * (getHeight() + getWidth());
	}
}
