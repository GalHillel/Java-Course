package main;

import java.awt.Color;

/**
 * Hexagon Shape
 * 
 * Represents a regular hexagon defined by a center point and radius.
 * The hexagon is oriented with flat sides on top/bottom.
 * Implements both Drawable and Saveable interfaces.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class Hexagon implements Drawable, Saveable {
	// Data members
	private Point center;
	private Point vertex0, vertex1, vertex2, vertex3, vertex4, vertex5;
	private int radius;
	private Color color;
	private boolean fill;

	/**
	 * Constructs a regular Hexagon with specified center and radius.
	 * Automatically calculates all 6 vertices based on hexagon geometry.
	 * 
	 * @param center Center point of the hexagon
	 * @param radius Distance from center to each vertex
	 * @param color  Color of the hexagon
	 * @param fill   Whether the hexagon should be filled or just outlined
	 */
	public Hexagon(Point center, int radius, Color color, boolean fill) {
		this.center = center;
		this.radius = radius;
		this.color = color;
		this.fill = fill;

		// Calculate vertex positions for a regular hexagon
		// Vertices are positioned at 0°, 60°, 120°, 180°, 240°, 300° from center
		this.vertex0 = new Point((center.getX() + radius), center.getY(),
				center.getColor(), center.getFill());
		this.vertex1 = new Point((center.getX() - radius), center.getY(),
				center.getColor(), center.getFill());
		this.vertex2 = new Point((int) (center.getX() + (radius / 2)),
				(int) (center.getY() + (Math.sqrt(3) * radius / 2)), center.getColor(), center.getFill());
		this.vertex3 = new Point((int) (center.getX() + (radius / 2)),
				(int) (center.getY() - (Math.sqrt(3) * radius / 2)), center.getColor(), center.getFill());
		this.vertex4 = new Point((int) (center.getX() - (radius / 2)),
				(int) (center.getY() + (Math.sqrt(3) * radius / 2)), center.getColor(), center.getFill());
		this.vertex5 = new Point((int) (center.getX() - (radius / 2)),
				(int) (center.getY() - (Math.sqrt(3) * radius / 2)), center.getColor(), center.getFill());
	}

	/**
	 * Gets the X coordinates of all six vertices.
	 * 
	 * @return Array of 6 X coordinates in drawing order
	 */
	public int[] getXs() {
		int[] xCoordinates = new int[6];
		xCoordinates[0] = vertex4.getX();
		xCoordinates[1] = vertex2.getX();
		xCoordinates[2] = vertex0.getX();
		xCoordinates[3] = vertex3.getX();
		xCoordinates[4] = vertex5.getX();
		xCoordinates[5] = vertex1.getX();
		return xCoordinates;
	}

	/**
	 * Gets the Y coordinates of all six vertices.
	 * 
	 * @return Array of 6 Y coordinates in drawing order
	 */
	public int[] getYs() {
		int[] yCoordinates = new int[6];
		yCoordinates[0] = vertex4.getY();
		yCoordinates[1] = vertex2.getY();
		yCoordinates[2] = vertex0.getY();
		yCoordinates[3] = vertex3.getY();
		yCoordinates[4] = vertex5.getY();
		yCoordinates[5] = vertex1.getY();
		return yCoordinates;
	}

	/**
	 * Calculates the area using the formula for a regular hexagon.
	 * Formula: Area = (3√3 / 2) × r² = (6 × r² × √3) / 4
	 * 
	 * @return Area of the hexagon in square pixels
	 */
	@Override
	public double getArea() {
		return (6 * radius * radius * Math.sqrt(3)) / 4;
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
	 * Gets the center point of this hexagon.
	 * 
	 * @return Center point
	 */
	public Point getP() {
		return center;
	}

	/**
	 * Gets the radius of this hexagon.
	 * 
	 * @return Radius (distance from center to vertex)
	 */
	public int getRadius() {
		return radius;
	}

	@Override
	public String getFileText() {
		return "Hexagon*" + center.getFileText() + "*" + radius + "*"
				+ Main.translateColor(color) + "*" + fill;
	}

	@Override
	public void loadFileText(String data) {
		String[] hexagonData = data.split("\\*");
		this.center = new Point(Integer.parseInt(hexagonData[1]), Integer.parseInt(hexagonData[2]),
				Main.translateColor(hexagonData[3]), Boolean.parseBoolean(hexagonData[4]));
		this.radius = Integer.parseInt(hexagonData[5]);
		this.color = Main.translateColor(hexagonData[6]);
		this.fill = Boolean.parseBoolean(hexagonData[7]);

		// Recalculate all vertices from loaded center and radius
		this.vertex0 = new Point((center.getX() + radius), center.getY(), center.getColor(), fill);
		this.vertex1 = new Point((center.getX() - radius), center.getY(), center.getColor(), fill);
		this.vertex2 = new Point((int) (center.getX() + (radius / 2)),
				(int) (center.getY() + (Math.sqrt(3) * radius / 2)), center.getColor(), fill);
		this.vertex3 = new Point((int) (center.getX() + (radius / 2)),
				(int) (center.getY() - (Math.sqrt(3) * radius / 2)), center.getColor(), fill);
		this.vertex4 = new Point((int) (center.getX() - (radius / 2)),
				(int) (center.getY() + (Math.sqrt(3) * radius / 2)), center.getColor(), fill);
		this.vertex5 = new Point((int) (center.getX() - (radius / 2)),
				(int) (center.getY() - (Math.sqrt(3) * radius / 2)), center.getColor(), fill);
	}

	/**
	 * Calculates the perimeter as 6 times the radius.
	 * For a regular hexagon, perimeter = 6 × side length = 6 × radius
	 * 
	 * @return Perimeter of the hexagon in pixels
	 */
	@Override
	public double getPerimeter() {
		return 6 * radius;
	}
}
