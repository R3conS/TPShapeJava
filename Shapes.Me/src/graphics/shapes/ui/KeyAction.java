package graphics.shapes.ui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import graphics.shapes.Shape;

public class KeyAction {

	private ShapesController c;

	public KeyAction(ShapesController c) {
		this.c = c;
	}

	public void key(KeyEvent e) {
		int key = e.getKeyCode();
		ArrayList<Shape> toMove = c.selected();
		if (key == KeyEvent.VK_LEFT) {
			for (Shape currentShape : toMove) {
				currentShape.translate(-5, 0);
			}
		} else if (key == KeyEvent.VK_RIGHT) {
			for (Shape currentShape : toMove) {
				currentShape.translate(5, 0);
			}
		} else if (key == KeyEvent.VK_UP) {
			for (Shape currentShape : toMove) {
				currentShape.translate(0, -5);
			}
		} else if (key == KeyEvent.VK_DOWN) {
			for (Shape currentShape : toMove) {
				currentShape.translate(0, 5);
			}
		} else if (key == KeyEvent.VK_DELETE) {
			c.delete();
		} else if (key == KeyEvent.VK_C && e.isControlDown()) {
			c.copy();
		} else if (key == KeyEvent.VK_V && e.isControlDown()) {
			c.paste();
		} else if (key == KeyEvent.VK_A && e.isControlDown()) {
			c.selectAll();
		} else if (key == KeyEvent.VK_Z && e.isControlDown()) {
			c.undo();
		}
		c.getView().repaint();

	}
}
