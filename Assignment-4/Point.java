package main;

import java.awt.Color;

/**
 * Point Shape
 * 
 * Represents a 2D point with x,y coordinates that can be drawn and saved to
 * files.
 * Implements both Drawable and Saveable interfaces.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class Point implements Drawable, Saveable {

	// Data members
	private int x;
	private int y;
	private boolean fill;
	private Color color;

	/**
	 * Constructs a Point with full specifications.
	 * 
	 * @param x     X coordinate
	 * @param y     Y coordinate
	 * @param color Color of the point
	 * @param fill  Whether the point should be filled (not applicable for points)
	 */
	public Point(int x, int y, Color color, boolean fill) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.fill = fill;
	}

	/**
	 * Copy constructor - creates a new Point from an existing Point.
	 * 
	 * @param point Point to copy
	 */
	public Point(Point point) {
		this(point.x, point.y, point.color, point.fill);
	}

	/**
	 * Constructs a Point with default color (black) and not filled.
	 * 
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Point(int x, int y) {
		this(x, y, Color.BLACK, false);
	}

	/**
	 * Default constructor creates a Point at origin (0,0).
	 */
	public Point() {
		// Default values already set
	}

	/**
	 * Gets the X coordinate of this point.
	 * 
	 * @return X coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the Y coordinate of this point.
	 * 
	 * @return Y coordinate
	 */
	public int getY() {
		return y;
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
	 * Points have no area.
	 * 
	 * @return Always returns 0
	 */
	@Override
	public double getArea() {
		return 0;
	}

	/**
	 * Points have no perimeter.
	 * 
	 * @return Always returns 0
	 */
	@Override
	public double getPerimeter() {
		return 0;
	}

	/**
	 * Serializes this Point to a string for file storage.
	 * Format: "Point*x*y*color*fill"
	 * 
	 * @return String representation for file persistence
	 */
	@Override
	public String getFileText() {
		return "Point*" + x + "*" + y + "*" + Main.translateColor(color) + "*" + fill;
	}

	/**
	 * Deserializes a Point from file data.
	 * 
	 * @param data String data in format "Point*x*y*color*fill"
	 */
	@Override
	public void loadFileText(String data) {
		String[] pointData = data.split("\\*");
		this.x = Integer.parseInt(pointData[1]);
		this.y = Integer.parseInt(pointData[2]);
		this.color = Main.translateColor(pointData[3]);
		this.fill = Boolean.parseBoolean(pointData[4]);
	}

}
