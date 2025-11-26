package main;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * Main Rendering Window
 * 
 * A Swing-based window that renders drawable shapes using Java AWT Graphics.
 * Supports rendering Points, Lines, Circles, Rectangles, Triangles, and
 * Hexagons.
 * 
 * @author University Assignment
 * @version 1.0
 */
public class MainWindow extends JFrame {

	// Data members
	private ArrayList<Drawable> drawable;

	/**
	 * Constructs a new MainWindow.
	 */
	public MainWindow() {
		super();
	}

	/**
	 * Paints all drawable shapes on the window.
	 * Uses instanceof checks to determine shape type and render appropriately.
	 * 
	 * @param g Graphics context for rendering
	 */
	@Override
	public void paint(Graphics g) {

		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		for (int i = 0; i < drawable.size(); i++) {

			// Render Points
			if (drawable.get(i) instanceof Point) {
				Point p = (Point) drawable.get(i);
				g.drawOval(p.getX(), p.getY(), 3, 3);
			}

			// Render Lines
			if (drawable.get(i) instanceof Line) {
				Line l = (Line) drawable.get(i);

				g.setColor(l.getColor());
				g.drawLine(l.getP0().getX(), l.getP0().getY(),
						l.getP1().getX(), l.getP1().getY());
			}

			// Render Circles
			if (drawable.get(i) instanceof Circle) {
				Circle c = (Circle) drawable.get(i);

				g.setColor(c.getColor());

				if (c.getFill()) {
					g.fillOval(c.getP().getX() - c.getRadius() / 2,
							c.getP().getY() - c.getRadius() / 2,
							c.getRadius(), c.getRadius());
				} else {
					g.drawOval(c.getP().getX() - c.getRadius() / 2,
							c.getP().getY() - c.getRadius() / 2,
							c.getRadius(), c.getRadius());
				}

			}

			// Render Triangles
			if (drawable.get(i) instanceof Triangle) {
				Triangle t = (Triangle) drawable.get(i);

				g.setColor(t.getColor());

				if (t.getFill()) {
					g.fillPolygon(t.getXs(), t.getYs(), t.getXs().length);
				} else {
					g.drawPolygon(t.getXs(), t.getYs(), t.getXs().length);
				}

			}

			// Render Rectangles
			if (drawable.get(i) instanceof Rectangle) {
				Rectangle r = (Rectangle) drawable.get(i);
				g.setColor(r.getColor());
				if (r.getFill()) {
					g.fillRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());

				} else {
					g.drawRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
				}

			}

			// Render Hexagons
			if (drawable.get(i) instanceof Hexagon) {
				Hexagon h = (Hexagon) drawable.get(i);
				g.setColor(h.getColor());
				if (h.getFill()) {
					g.fillPolygon(h.getXs(), h.getYs(), h.getYs().length);
				} else {
					g.drawPolygon(h.getXs(), h.getYs(), h.getXs().length);
				}
			}

		}

	}

	/**
	 * Sets the list of shapes to be drawn and triggers a repaint.
	 * 
	 * @param drawable ArrayList of Drawable shapes to render
	 */
	public void setDraws(ArrayList<Drawable> drawable) {
		this.drawable = drawable;
		this.repaint();
	}

}