package graphics.shapes;

import java.util.ArrayList;
import java.util.Iterator;

import graphics.shapes.attributes.Attributes;
import graphics.shapes.attributes.SelectionAttributes;

import java.awt.*;

public class SCollection extends Shape {

	private ArrayList<Shape> collection;

	public SCollection() {
		this.collection = new ArrayList<Shape>();
	}

	public Iterator<Shape> iterator() {
		return this.collection.iterator();
	}

	public void add(Shape s) {
		collection.add(s);
	}
	
	public void remove(Shape s) {
		collection.remove(s);
	}

	public Point getLoc() {
		return this.getBounds().getLocation();
	}

	public void setLoc(Point loc) {
	}

	public ArrayList<Shape> getCollection() {
		return collection;
	}

	public void translate(int dx, int dy) {
		for (Iterator<Shape> it = this.iterator(); it.hasNext();) {
			Shape currentShape = it.next();
			SelectionAttributes selectAtt = (SelectionAttributes) currentShape.getAttributes("selection");
			if (selectAtt != null) {
				if (selectAtt.isSelected() == true) {
					currentShape.translate(dx, dy);
				}
			}
		}
	}
	
	@Override
	public void grow(int x, int y) {
		for (Iterator<Shape> it = this.iterator(); it.hasNext();) {
			Shape currentShape = it.next();
			SelectionAttributes selectAtt = (SelectionAttributes) currentShape.getAttributes("selection");
			if (selectAtt != null) {
				if (selectAtt.isSelected() == true) {
					currentShape.grow(x, y);
				}
			}
		}
	}

	public Rectangle getBounds() {
		Rectangle r = collection.get(0).getBounds();
		for (Iterator<Shape> it = collection.iterator(); it.hasNext();) {
			r = r.union(((Shape) it.next()).getBounds());
		}
		return r;
	}

	public void accept(ShapeVisitor sv) {
		sv.visitCollection(this);
	}

	@Override
	public void addAttributes(Attributes a) {
		for (Shape s : collection) {
			s.addAttributes(a);
		}
	}

	@Override
	public Attributes getAttributes(String s) {
		return collection.get(0).getAttributes(s);
	}

	@Override
	public boolean isText() {
		return false;
	}
}
