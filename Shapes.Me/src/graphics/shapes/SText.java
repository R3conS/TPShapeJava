package graphics.shapes;

import java.awt.*;

import graphics.shapes.attributes.FontAttributes;

public class SText extends Shape {

	private String text;
	private Point loc;
	private int width;
	private int height;

	public SText(Point loc, String text) {
		this.text = text;
		this.loc = loc;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Point getLoc() {
		return this.loc;
	}

	public void setLoc(Point loc) {
		this.loc = loc;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void translate(int dx, int dy) {
		this.loc.setLocation(this.loc.getX() + dx, this.loc.getY() + dy);
	}

	@Override
	public void grow(int x, int y) {
		((FontAttributes) this.getAttributes("font")).grow(x, y);
	}

	public Rectangle getBounds() {
		return new Rectangle(loc.x, loc.y, this.width, this.height);
		
	}

	public void accept(ShapeVisitor sv) {
		sv.visitText(this);
	}

	@Override
	public String toString() {
		return "SText [text=" + text + ", loc=" + loc + "]";
	}

	@Override
	public boolean isText() {
		return true;
	}
}
