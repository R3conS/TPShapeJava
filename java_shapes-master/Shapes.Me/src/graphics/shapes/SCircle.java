package graphics.shapes;

import java.awt.*;

public class SCircle extends Shape{

	private int radius;
	private Point loc;

	public SCircle() {
		this.radius = 1;
		this.loc = new Point();
	}

	public SCircle(java.awt.Point point, int radius) {
		this.radius=radius;
		this.loc = new Point(point);
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getLoc() {
		return this.loc;
	}

	public void setLoc(Point loc) {
		this.loc = loc;
	}

	public void translate(int dx,int dy) {
		this.loc.setLocation(this.loc.getX()+dx,this.loc.getY()+dy);
	}

	@Override
	public void grow(int x, int y) {
		this.radius+=Integer.max(x,y);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(loc.x,loc.y,2*radius,2*radius);
	}

	public void accept(ShapeVisitor sv) {
		sv.visitCircle(this);
	}

	@Override
	public String toString() {
		return "SCircle [radius=" + radius + ", loc=" + loc + "]";
	}

	@Override
	public boolean isText() {
		return false;
	}
	
}
