package main;

import java.awt.Color;

public class Triangle implements Drawable, Saveable {

	// data
	private Point p0, p1, p2;
	private Color color;
	private boolean fill;

	// constructor
	public Triangle(Point p0, Point p1, Point p2, Color color, boolean fill) {
		this.p0 = p0;
		this.p1 = p1;
		this.p2 = p2;
		this.color = color;
		this.fill = fill;
	}

	// functions
	public Color getColor() {
		return color;
	}

	public int[] getXs() {
		int[] ans = new int[3];
		ans[0] = p0.getX();
		ans[1] = p1.getX();
		ans[2] = p2.getX();
		return ans;
	}

	public int[] getYs() {
		int[] ans = new int[3];
		ans[0] = p0.getY();
		ans[1] = p1.getY();
		ans[2] = p2.getY();
		return ans;
	}

	@Override
	public boolean getFill() {
		return fill;
	}

	@Override
	public double getArea() {
		// Area =|(p1-p0)X(p2-p0)|
		return Math.abs(
				(p1.getX() - p0.getX()) * (p2.getY() - p0.getY()) - (p2.getX() - p0.getX()) * (p1.getY() - p0.getY()));
	}

	private double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.getY() - p2.getY(), 2) + Math.pow(p1.getX() - p2.getX(), 2));
	}

	public double getPerimeter() {
		return getDistance(p0, p1) + getDistance(p1, p2) + getDistance(p2, p0);
	}

	@Override
	public String getFileText() {
		return "Triangle*" + p0.getFileText() + "*" + p1.getFileText() + "*" + p2.getFileText() + "*"
				+ Main.translateColor(color) + "*" + fill;
	}

	@Override
	public void loadFileText(String data) {
		String[] point = data.split("\\*");
		this.p0 = new Point(Integer.parseInt(point[1]), Integer.parseInt(point[2]), Main.translateColor(point[3]),
				Boolean.parseBoolean(point[4]));
		this.p1 = new Point(Integer.parseInt(point[5]), Integer.parseInt(point[6]), Main.translateColor(point[7]),
				Boolean.parseBoolean(point[8]));
		this.p2 = new Point(Integer.parseInt(point[9]), Integer.parseInt(point[10]), Main.translateColor(point[11]),
				Boolean.parseBoolean(point[12]));
		this.color = Main.translateColor(point[13]);
		this.fill = Boolean.parseBoolean(point[14]);
	}

}
