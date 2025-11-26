package main;

import java.awt.Color;

/**
 * Line Shape
 * 
 * Represents a line segment defined by two endpoints.
 * Implements both Drawable and Saveable interfaces.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class Line implements Drawable, Saveable {

	// Data members
	private Point startPoint;
	private Point endPoint;
	private Color color;

	/**
	 * Constructs a Line with specified endpoints and color.
	 * 
	 * @param startPoint Starting point of the line
	 * @param endPoint   Ending point of the line
	 * @param color      Color of the line
	 */
	public Line(Point startPoint, Point endPoint, Color color) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
	}

	/**
	 * Gets the starting point of this line.
	 * 
	 * @return Starting point
	 */
	public Point getP0() {
		return startPoint;
	}

	/**
	 * Gets the ending point of this line.
	 * 
	 * @return Ending point
	 */
	public Point getP1() {
		return endPoint;
	}

	@Override
	public Color getColor() {
		return color;
	}

	/**
	 * Lines cannot be filled.
	 * 
	 * @return Always returns false
	 */
	@Override
	public boolean getFill() {
		return false;
	}

	/**
	 * Lines have minimal area.
	 * 
	 * @return Always returns 1 (representing a line with width of 1 pixel)
	 */
	@Override
	public double getArea() {
		return 1;
	}

	@Override
	public String getFileText() {
		return "Line*" + startPoint.getFileText() + "*" + endPoint.getFileText() + "*" + Main.translateColor(color);
	}

	@Override
	public void loadFileText(String data) {
		String[] lineData = data.split("\\*");
		this.startPoint = new Point(Integer.parseInt(lineData[1]), Integer.parseInt(lineData[2]),
				Main.translateColor(lineData[3]), Boolean.parseBoolean(lineData[4]));
		this.endPoint = new Point(Integer.parseInt(lineData[5]), Integer.parseInt(lineData[6]),
				Main.translateColor(lineData[7]), Boolean.parseBoolean(lineData[8]));
		this.color = Main.translateColor(lineData[9]);
	}

	/**
	 * Calculates the perimeter (2 * length) of this line.
	 * Uses the Euclidean distance formula: sqrt((x2-x1)^2 + (y2-y1)^2)
	 * 
	 * @return Perimeter (twice the length of the line)
	 */
	@Override
	public double getPerimeter() {
		return 2 * (Math.sqrt(((startPoint.getX() - endPoint.getX()) * (startPoint.getX() - endPoint.getX()))
				+ ((startPoint.getY() - endPoint.getY()) * (startPoint.getY() - endPoint.getY()))));
	}
}
