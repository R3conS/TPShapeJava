package graphics.shapes;

import java.awt.*;
import java.util.HashMap;
import graphics.shapes.attributes.*;

public abstract class Shape {

	private HashMap<String, Attributes> attributes;

	public Shape() {
		this.attributes = new HashMap<String, Attributes>();
	}

	public void addAttributes(Attributes a) {
		this.attributes.put(a.getId(), a);
	}

	public Attributes getAttributes(String s) {
		return this.attributes.get(s);
	}

	public abstract Point getLoc();

	public abstract void setLoc(Point p);

	public abstract void translate(int dx, int dy);
	
	public abstract void grow(int x, int y);

	public abstract Rectangle getBounds();

	public abstract void accept(ShapeVisitor sv);

	public abstract boolean isText();

}
