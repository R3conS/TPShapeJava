package graphics.shapes.ui;

import java.awt.Graphics;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.awt.event.MouseEvent;

//import javax.swing.JPopupMenu;
//import javax.swing.JLabel;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
//import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;
import graphics.ui.View;

public class ShapesView extends View {

	private ShapeDraftman draftman;

	private static final long serialVersionUID = 1;

	public ShapesView(Shape model) {
		super(model);
	}

	public boolean isFocusTraversable() {
		return true;
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		SCollection collection = (SCollection) this.getModel();
		this.draftman = new ShapeDraftman(g);
		collection.accept(draftman);

	}

	@Override
	public Controller defaultController(Object model) {
		return new ShapesController((SCollection) model);
	}

}
