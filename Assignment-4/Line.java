package main;

import java.awt.Color;

public class Line implements Drawable, Saveable {

	// data
	private Point p0, p1;
	private Color color;

	// constructor
	public Line(Point p0, Point p1, Color color) {
		this.p0 = p0;
		this.p1 = p1;
		this.color = color;
	}

	// functions
	public Point getP0() {
		return p0;
	}

	public Point getP1() {
		return p1;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public boolean getFill() {
		return false;
	}

	@Override
	public double getArea() {
		return 1;
	}

	@Override
	public String getFileText() {
		return "Line*" + p0.getFileText() + "*" + p1.getFileText() + "*" + Main.translateColor(color);
	}

	@Override
	public void loadFileText(String data) {
		String[] point = data.split("\\*");
		this.p0 = new Point(Integer.parseInt(point[1]), Integer.parseInt(point[2]), Main.translateColor(point[3]),
				Boolean.parseBoolean(point[4]));
		this.p1 = new Point(Integer.parseInt(point[5]), Integer.parseInt(point[6]), Main.translateColor(point[7]),
				Boolean.parseBoolean(point[8]));
		this.color = Main.translateColor(point[9]);
	}

	public double getPerimeter() {
		return 2 * (Math.sqrt(((p0.getX() - p1.getX()) * (p0.getX() - p1.getX()))
				+ ((p0.getY() - p1.getY()) * (p0.getY() - p1.getY()))));
	}

}
