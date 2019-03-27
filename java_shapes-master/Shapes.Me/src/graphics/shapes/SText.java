package graphics.shapes;

import java.awt.*;

import graphics.shapes.attributes.FontAttributes;

public class SText extends Shape {

	private String text;
	private Point loc;
	private int width;
	private int height;

	public SText() {
		this.text = "";
		this.loc = new Point();
	}

	public SText(Point loc, String text) {
		this.text = text;
		this.loc = loc;
		this.height=10;
		this.width=8*this.text.length();
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

	public void translate(int dx, int dy) {
		this.loc.setLocation(this.loc.getX() + dx, this.loc.getY() + dy);
	}

	@Override
	public void grow(int x, int y) {
		FontAttributes fontAtt = (FontAttributes) this.getAttributes("font");
		fontAtt.grow(x, y);
		this.addAttributes(fontAtt);
		width += 6*x;
		height += 1.5*y;
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
