package graphics.shapes.ui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Iterator;
import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends Controller {

	private boolean dragging = false;

	public ShapesController(SCollection model) {
		super(model);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		if (e.getButton() == 1)
			this.dragging = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		this.dragging = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if (e.getButton() == 1) {
			Shape s = this.isAimed(e);
			if (!e.isShiftDown())
				this.unselAll();
			if (s != null) {
				SelectionAttributes sa = new SelectionAttributes();
				sa.select();
				s.addAttributes(sa);
			}
		}
		if (e.getButton() == 3) {
			doPop(e);
		}
		super.getView().repaint();
	}

	@Override
	public void mouseMoved(MouseEvent evt) {
		// TODO Auto-generated method stub
		super.mouseMoved(evt);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		super.mouseWheelMoved(e);
		boolean wheelRotation = e.getWheelRotation() < 0;
		ArrayList<Shape> toGrow = selected();
		for (Shape currentShape : toGrow) {
			if (wheelRotation)
				currentShape.grow(5, 5);
			else
				currentShape.grow(-5, -5);
			this.getView().repaint();
		}

	}

	@Override
	public void mouseDragged(MouseEvent evt) {
		super.mouseDragged(evt);
		if (this.dragging) {
			SCollection sc = (SCollection) this.getModel();
			ArrayList<Shape> toMove = selected();
			for (Shape currentShape : toMove) {
				sc.translate(evt.getX() - currentShape.getBounds().x - currentShape.getBounds().width / 2,
						evt.getY() - currentShape.getBounds().y - currentShape.getBounds().height / 2);
				super.getView().repaint();
			}
		}
	}

	public void unselAll() {
		SCollection sc = (SCollection) this.getModel();
		for (Iterator<Shape> it = sc.iterator(); it.hasNext();) {
			Shape currentShape = it.next();
			SelectionAttributes sa = new SelectionAttributes();
			sa.unselect();
			currentShape.addAttributes(sa);
			super.getView().repaint();
		}
	}

	public Shape isAimed(MouseEvent e) {
		Shape s;
		SCollection sc = (SCollection) this.getModel();
		for (Iterator<Shape> i = sc.iterator(); i.hasNext();) {
			s = (Shape) i.next();
			if (s.getBounds().contains(e.getPoint()))
				return s;
		}
		return null;
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		super.keyPressed(evt);

	}
	@Override
	public void keyReleased(KeyEvent evr){
		super.keyReleased(evr);
		int key=evr.getKeyCode();
		if(key==KeyEvent.VK_LEFT){
		ArrayList<Shape> toMove = selected();
		for (Shape currentShape : toMove) {
			currentShape.translate(-5,0);
			super.getView().repaint();
		}		
		}
		else if(key==KeyEvent.VK_RIGHT){
		ArrayList<Shape> toMove = selected();
		for (Shape currentShape : toMove) {
			currentShape.translate(5,0);
			super.getView().repaint();
		}		
		}
		else if(key==KeyEvent.VK_UP){
		
		ArrayList<Shape> toMove = selected();
		for (Shape currentShape : toMove) {
			currentShape.translate(0,-5);
			super.getView().repaint();
		}		
		}	
		else if(key==KeyEvent.VK_DOWN){
			
			ArrayList<Shape> toMove = selected();
			for (Shape currentShape : toMove) {
				currentShape.translate(0,5);
				super.getView().repaint();
			}		
			}
		else if(key==KeyEvent.VK_DELETE){
			ArrayList<Shape> toMove = selected();
			for (@SuppressWarnings("unused") Shape currentShape : toMove) {
				delete();
				super.getView().repaint();
			}		
			}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
	}

	public ArrayList<Shape> selected() {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		SCollection sc = (SCollection) this.getModel();
		for (Iterator<Shape> it = sc.iterator(); it.hasNext();) {
			Shape currentShape = it.next();
			SelectionAttributes selectAtt = (SelectionAttributes) currentShape.getAttributes("selection");
			if (selectAtt != null) {
				if (selectAtt.isSelected()) {
					shapes.add(currentShape);
				}
			}
		}
		return shapes;
	}

	public void delete() {
		ArrayList<Shape> toDelete = selected();
		for (Shape currentShape : toDelete) {
			((SCollection) (this.getModel())).remove(currentShape);
			this.getView().repaint();
		}
	}

	public void rectangle(MouseEvent e) {
		SRectangle r = new SRectangle(e.getPoint(), 200, 300);
		r.addAttributes(new ColorAttributes(false, true, Color.cyan, Color.black));
		r.addAttributes(new SelectionAttributes());
		((SCollection) (super.getModel())).add(r);
		this.getView().repaint();
	}

	public void circle(MouseEvent e) {
		SCircle c = new SCircle(e.getPoint(), 100);
		c.addAttributes(new ColorAttributes(false, true, Color.gray, Color.black));
		c.addAttributes(new SelectionAttributes());
		((SCollection) (super.getModel())).add(c);
		this.getView().repaint();
	}

	public void text(MouseEvent e) {
		SText t = new SText(e.getPoint(), "hello");
		t.addAttributes(new ColorAttributes(false, true, Color.yellow, Color.black));
		t.addAttributes(new FontAttributes());
		t.addAttributes(new SelectionAttributes());
		((SCollection) (super.getModel())).add(t);
		this.getView().repaint();
	}

	public void filled(Color color) {
		ArrayList<Shape> toChange = selected();
		for (Shape currentShape : toChange) {
			ColorAttributes c = ((ColorAttributes) currentShape.getAttributes("color"));
			c.setFilled(true);
			c.setFilledColor(color);
			this.getView().repaint();
		}
	}

	public void stroked(Color color) {
		ArrayList<Shape> toChange = selected();
		for (Shape currentShape : toChange) {
			ColorAttributes c = ((ColorAttributes) currentShape.getAttributes("color"));
			c.setStroked(true);
			c.setStrokedColor(color);
			this.getView().repaint();
		}
	}

	public void textC(Color color) {
		ArrayList<Shape> toChange = selected();
		for (Shape currentShape : toChange) {
			FontAttributes t = ((FontAttributes) currentShape.getAttributes("font"));
			t.setFontColor(color);
			this.getView().repaint();
		}
	}

	public void none(String type) {
		ArrayList<Shape> toChange = selected();
		for (Shape currentShape : toChange) {
			ColorAttributes c = ((ColorAttributes) currentShape.getAttributes("color"));
			boolean bool = currentShape.isText();
			if (type == "filled" && c.isStroked() || type == "filled" && bool)
				c.setFilled(false);
			else if (c.isFilled() || bool)
				c.setStroked(false);
			this.getView().repaint();
		}
	}


	private void doPop(MouseEvent e) {

		PopupMenu p = new PopupMenu(this);
		p.pop(e);

	}

}
