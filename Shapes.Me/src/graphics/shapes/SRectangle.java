package graphics.shapes;

import java.awt.*;

public class SRectangle extends Shape {

	private Rectangle rect;

	public SRectangle() {
		this.rect = new Rectangle();
	}

	public SRectangle(Point p, int width, int height) {
		this.rect = new Rectangle(p.x, p.y, width, height);
	}

	public Rectangle getRect() {
		return this.rect;
	}

	public Point getLoc() {
		Point p = new Point();
		p.setLocation(rect.x, rect.y);
		return p;
	}

	public void setLoc(Point loc) {
		this.rect.x = loc.x;
		this.rect.y = loc.y;
	}

	public void translate(int dx, int dy) {
		this.rect.translate(dx, dy);
	}

	@Override
	public void grow(int x, int y) {
		this.rect.grow(x,y);
	}

	public Rectangle getBounds() {
		return this.rect;
	}

	public void accept(ShapeVisitor sv) {
		sv.visitRectangle(this);
	}

	@Override
	public String toString() {
		return "SRectangle [" + this.rect.x + "," + this.rect.y + "]";
	}

	@Override
	public boolean isText() {
		return false;
	}
}
