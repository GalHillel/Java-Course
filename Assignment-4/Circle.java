package main;

import java.awt.Color;

public class Circle implements Drawable, Saveable {

	// data
	private Point p;
	private int radius;
	private Color color;
	private boolean fill;

	// constructor
	public Circle(Point p, int radius, Color color, boolean fill) {
		this.p = p;
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

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	public Point getP() {
		return p;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public String getFileText() {
		return "Circle*" + p.getFileText() + "*" + radius + "*" + Main.translateColor(color) + "*" + fill;
	}

	@Override
	public void loadFileText(String data) {
		String[] point = data.split("\\*");
		this.p = new Point(Integer.parseInt(point[1]), Integer.parseInt(point[2]), Main.translateColor(point[3]),
				Boolean.parseBoolean(point[4]));
		this.radius = Integer.parseInt(point[5]);
		this.color = Main.translateColor(point[6]);
		this.fill = Boolean.parseBoolean(point[7]);
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

}
