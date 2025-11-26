package main;

import java.awt.Color;

/**
 * Triangle Shape
 * 
 * Represents a triangle defined by three vertices.
 * Implements both Drawable and Saveable interfaces.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class Triangle implements Drawable, Saveable {

	// Data members
	private Point vertex0;
	private Point vertex1;
	private Point vertex2;
	private Color color;
	private boolean fill;

	/**
	 * Constructs a Triangle with three vertices.
	 * 
	 * @param vertex0 First vertex of the triangle
	 * @param vertex1 Second vertex of the triangle
	 * @param vertex2 Third vertex of the triangle
	 * @param color   Color of the triangle
	 * @param fill    Whether the triangle should be filled or just outlined
	 */
	public Triangle(Point vertex0, Point vertex1, Point vertex2, Color color, boolean fill) {
		this.vertex0 = vertex0;
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.color = color;
		this.fill = fill;
	}

	@Override
	public Color getColor() {
		return color;
	}

	/**
	 * Gets the X coordinates of all three vertices.
	 * 
	 * @return Array of 3 X coordinates
	 */
	public int[] getXs() {
		int[] xCoordinates = new int[3];
		xCoordinates[0] = vertex0.getX();
		xCoordinates[1] = vertex1.getX();
		xCoordinates[2] = vertex2.getX();
		return xCoordinates;
	}

	/**
	 * Gets the Y coordinates of all three vertices.
	 * 
	 * @return Array of 3 Y coordinates
	 */
	public int[] getYs() {
		int[] yCoordinates = new int[3];
		yCoordinates[0] = vertex0.getY();
		yCoordinates[1] = vertex1.getY();
		yCoordinates[2] = vertex2.getY();
		return yCoordinates;
	}

	@Override
	public boolean getFill() {
		return fill;
	}

	/**
	 * Calculates the area using the cross product formula.
	 * 
	 * The formula is: Area = |(v1-v0) × (v2-v0)| / 2
	 * Simplified to: |x1*y2 - x2*y1 + x2*y0 - x0*y2 + x0*y1 - x1*y0|
	 * 
	 * @return Area of the triangle in square pixels
	 */
	@Override
	public double getArea() {
		return Math.abs((vertex1.getX() - vertex0.getX()) * (vertex2.getY() - vertex0.getY())
				- (vertex2.getX() - vertex0.getX()) * (vertex1.getY() - vertex0.getY()));
	}

	/**
	 * Calculates Euclidean distance between two points.
	 * Uses the formula: √((x2-x1)² + (y2-y1)²)
	 * 
	 * @param point1 First point
	 * @param point2 Second point
	 * @return Distance between the two points
	 */
	private double getDistance(Point point1, Point point2) {
		return Math.sqrt(Math.pow(point1.getY() - point2.getY(), 2)
				+ Math.pow(point1.getX() - point2.getX(), 2));
	}

	/**
	 * Calculates the perimeter as the sum of all three side lengths.
	 * 
	 * @return Perimeter of the triangle in pixels
	 */
	@Override
	public double getPerimeter() {
		return getDistance(vertex0, vertex1) + getDistance(vertex1, vertex2) + getDistance(vertex2, vertex0);
	}

	@Override
	public String getFileText() {
		return "Triangle*" + vertex0.getFileText() + "*" + vertex1.getFileText() + "*"
				+ vertex2.getFileText() + "*" + Main.translateColor(color) + "*" + fill;
	}

	@Override
	public void loadFileText(String data) {
		String[] triangleData = data.split("\\*");
		this.vertex0 = new Point(Integer.parseInt(triangleData[1]), Integer.parseInt(triangleData[2]),
				Main.translateColor(triangleData[3]), Boolean.parseBoolean(triangleData[4]));
		this.vertex1 = new Point(Integer.parseInt(triangleData[5]), Integer.parseInt(triangleData[6]),
				Main.translateColor(triangleData[7]), Boolean.parseBoolean(triangleData[8]));
		this.vertex2 = new Point(Integer.parseInt(triangleData[9]), Integer.parseInt(triangleData[10]),
				Main.translateColor(triangleData[11]), Boolean.parseBoolean(triangleData[12]));
		this.color = Main.translateColor(triangleData[13]);
		this.fill = Boolean.parseBoolean(triangleData[14]);
	}

}
