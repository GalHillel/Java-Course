package main;

import java.awt.Color;

public class Hexagon implements Drawable, Saveable {
	// Data
	private Point p, p_0, p_1, p_2, p_3, p_4, p_5;
	private int radius;
	private Color color;
	private boolean fill;

	// Constructor
	public Hexagon(Point p, int radius, Color color, boolean fill) {
		this.p = p;
		this.radius = radius;
		this.color = color;
		this.fill = fill;
		this.p_0 = new Point((p.getX() + radius), p.getY(), p.getColor(), p.getFill());
		this.p_1 = new Point((p.getX() - radius), p.getY(), p.getColor(), p.getFill());
		this.p_2 = new Point((int) (p.getX() + (radius / 2)), (int) (p.getY() + (Math.sqrt(3) * radius / 2)),
				p.getColor(), p.getFill());
		this.p_3 = new Point((int) (p.getX() + (radius / 2)), (int) (p.getY() - (Math.sqrt(3) * radius / 2)),
				p.getColor(), p.getFill());
		this.p_4 = new Point((int) (p.getX() - (radius / 2)), (int) (p.getY() + (Math.sqrt(3) * radius / 2)),
				p.getColor(), p.getFill());
		this.p_5 = new Point((int) (p.getX() - (radius / 2)), (int) (p.getY() - (Math.sqrt(3) * radius / 2)),
				p.getColor(), p.getFill());
	}

	// Functions
	public int[] getXs() {
		int[] ans = new int[6];
		ans[0] = p_4.getX();
		ans[1] = p_2.getX();
		ans[2] = p_0.getX();
		ans[3] = p_3.getX();
		ans[4] = p_5.getX();
		ans[5] = p_1.getX();
		return ans;
	}

	public int[] getYs() {
		int[] ans = new int[6];
		ans[0] = p_4.getY();
		ans[1] = p_2.getY();
		ans[2] = p_0.getY();
		ans[3] = p_3.getY();
		ans[4] = p_5.getY();
		ans[5] = p_1.getY();
		return ans;
	}

	public double getArea() {
		// S = 6*(radius^2)*(squer3)/4
		return (6 * radius * radius * Math.sqrt(3)) / 4;
	}

	public Color getColor() {
		return color;
	}

	public boolean getFill() {
		return fill;
	}

	public Point getP() {
		return p;
	}

	public int getRadius() {
		return radius;
	}

	public String getFileText() {
		return "Hexagon*" + p.getFileText() + "*" + radius + "*" + Main.translateColor(color) + "*" + fill;
	}

	public void loadFileText(String data) {
		String[] point = data.split("\\*");
		this.p = new Point(Integer.parseInt(point[1]), Integer.parseInt(point[2]), Main.translateColor(point[3]),
				Boolean.parseBoolean(point[4]));
		this.radius = Integer.parseInt(point[5]);
		this.color = Main.translateColor(point[6]);
		this.fill = Boolean.parseBoolean(point[7]);
		this.p_0 = new Point((p.getX() + radius), p.getY(), p.getColor(), fill);
		this.p_1 = new Point((p.getX() - radius), p.getY(), p.getColor(), fill);
		this.p_2 = new Point((int) (p.getX() + (radius / 2)), (int) (p.getY() + (Math.sqrt(3) * radius / 2)),
				p.getColor(), fill);
		this.p_3 = new Point((int) (p.getX() + (radius / 2)), (int) (p.getY() - (Math.sqrt(3) * radius / 2)),
				p.getColor(), fill);
		this.p_4 = new Point((int) (p.getX() - (radius / 2)), (int) (p.getY() + (Math.sqrt(3) * radius / 2)),
				p.getColor(), fill);
		this.p_5 = new Point((int) (p.getX() - (radius / 2)), (int) (p.getY() - (Math.sqrt(3) * radius / 2)),
				p.getColor(), fill);
	}

	public double getPerimeter() {
		return 6 * radius;
	}
}
