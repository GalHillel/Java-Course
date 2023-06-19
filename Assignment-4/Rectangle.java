package main;

import java.awt.Color;

public class Rectangle implements Drawable, Saveable {
	// Data
	private Point p_0, p_1, p_2, p_3;
	private Color color;
	private boolean fill;

	// Constructor
	public Rectangle(Point p_0, Point p_1, Color color, boolean fill) {
		this.p_0 = p_0;
		this.p_1 = p_1;
		this.color = color;
		this.fill = fill;
		this.p_2 = new Point(p_0.getX(), p_1.getY(), color, fill);
		this.p_3 = new Point(p_1.getX(), p_0.getY(), color, fill);
	}

	// Functions
	public Color getColor() {
		return color;
	}

	public int[] getXs() {
		int[] ans = new int[2];
		ans[0] = p_0.getX();
		ans[1] = p_1.getX();
		ans[2] = p_2.getX();
		ans[3] = p_3.getX();
		return ans;
	}

	public int[] getYs() {
		int[] ans = new int[2];
		ans[0] = p_0.getY();
		ans[1] = p_1.getY();
		ans[2] = p_2.getY();
		ans[3] = p_3.getY();
		return ans;
	}

	public boolean getFill() {
		return fill;
	}

	public double getArea() {
		return Math.abs((p_1.getX() - p_0.getX()) * (p_1.getY() - p_0.getY()));
	}

	public String getFileText() {
		return "Rectangle*" + p_0.getFileText() + "*" + p_1.getFileText() + "*" + Main.translateColor(color) + "*"
				+ fill;
	}

	public void loadFileText(String data) {
		String[] point = data.split("\\*");
		this.p_0 = new Point(Integer.parseInt(point[1]), Integer.parseInt(point[2]), Main.translateColor(point[3]),
				Boolean.parseBoolean(point[4]));
		this.p_1 = new Point(Integer.parseInt(point[5]), Integer.parseInt(point[6]), Main.translateColor(point[7]),
				Boolean.parseBoolean(point[8]));
		this.color = Main.translateColor(point[9]);
		this.fill = Boolean.parseBoolean(point[10]);
		this.p_2 = new Point(p_1.getX(), p_0.getY(), color, fill);
		this.p_3 = new Point(p_0.getX(), p_1.getY(), color, fill);
	}

	public int getx() {
		return p_0.getX();
	}

	public int gety() {
		return p_0.getY();
	}

	public int geth() {
		return Math.abs(p_0.getY() - p_1.getY());
	}

	public int getw() {
		return Math.abs(p_0.getX() - p_1.getX());
	}

	public double getPerimeter() {
		return geth() * getw();
	}
}
