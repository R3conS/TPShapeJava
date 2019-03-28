package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class ShapeDraftman implements ShapeVisitor {

	private Graphics g;

	public ShapeDraftman(Graphics g) {
		this.g = g;
	}

	public void visitRectangle(SRectangle rect) {

		ColorAttributes colorAtt = (ColorAttributes) rect.getAttributes(ColorAttributes.id);
		this.g.setColor(Color.black);
		if (colorAtt == null) {
			colorAtt = Default.DEFAULT_COLOR_ATTRIBUTES;
		}
		if (colorAtt.isFilled()) {
			this.g.setColor(colorAtt.getFilledColor());
			this.g.fillRect(rect.getLoc().x, rect.getLoc().y, rect.getRect().width, rect.getRect().height);
		}
		if (colorAtt.isStroked()) {
			this.g.setColor(colorAtt.getStrokedColor());
			this.g.drawRect(rect.getLoc().x, rect.getLoc().y, rect.getRect().width, rect.getRect().height);
		}

		SelectionAttributes selectAtt = (SelectionAttributes) rect.getAttributes(SelectionAttributes.id);
		if (selectAtt != null) {
			if (selectAtt.isSelected() == true) {
				this.g.setColor(Color.BLACK);
				if (colorAtt.isStroked())
					this.g.drawRect(rect.getLoc().x - 2, rect.getLoc().y - 2, rect.getRect().width + 4,
							rect.getRect().height + 4);
				else
					this.g.drawRect(rect.getLoc().x - 2, rect.getLoc().y - 2, rect.getRect().width + 3,
							rect.getRect().height + 3);
			}

		}
	}

	public void visitCircle(SCircle circle) {

		ColorAttributes colorAtt = (ColorAttributes) circle.getAttributes(ColorAttributes.id);
		this.g.setColor(Color.black);
		if (colorAtt == null) {
			colorAtt = Default.DEFAULT_COLOR_ATTRIBUTES;
		}
		if (colorAtt.isFilled()) {
			this.g.setColor(colorAtt.getFilledColor());
			this.g.fillOval(circle.getLoc().x, circle.getLoc().y, 2 * circle.getRadius(), 2 * circle.getRadius());
		}
		if (colorAtt.isStroked()) {
			this.g.setColor(colorAtt.getStrokedColor());
			this.g.drawOval(circle.getLoc().x, circle.getLoc().y, 2 * circle.getRadius(), 2 * circle.getRadius());
		}

		SelectionAttributes selectAtt = (SelectionAttributes) circle.getAttributes(SelectionAttributes.id);
		if (selectAtt != null) {
			if (selectAtt.isSelected() == true) {
				this.g.setColor(Color.BLACK);
				if (colorAtt.isStroked())
					this.g.drawRect(circle.getLoc().x - 2, circle.getLoc().y - 2, circle.getBounds().width + 4,
							circle.getBounds().height + 4);
				else
					this.g.drawRect(circle.getLoc().x - 2, circle.getLoc().y - 2, circle.getBounds().width + 3,
							circle.getBounds().height + 3);
			}
		}
	}

	public void visitText(SText text) {

		ColorAttributes colorAtt = (ColorAttributes) text.getAttributes(ColorAttributes.id);
		this.g.setColor(Color.black);
		if (colorAtt == null) {
			colorAtt = Default.DEFAULT_COLOR_ATTRIBUTES;
		}

		FontAttributes font = (FontAttributes) text.getAttributes(FontAttributes.id);
		this.g.setFont(font.getFont());
		this.g.setColor(font.getFontColor());
		int width = g.getFontMetrics().getStringBounds(text.getText(), g).getBounds().width + 3;
		int height = g.getFontMetrics().getStringBounds(text.getText(), g).getBounds().height - 2;
		text.setWidth(width);
		text.setHeight(height);
		if (colorAtt.isFilled()) {
			this.g.setColor(colorAtt.getFilledColor());
			this.g.fillRect(text.getLoc().x, text.getLoc().y, width, height);
		}
		if (colorAtt.isStroked()) {
			this.g.setColor(colorAtt.getStrokedColor());
			this.g.drawRect(text.getLoc().x, text.getLoc().y, width, height);
		}
		this.g.setFont(font.getFont());
		this.g.setColor(font.getFontColor());
		this.g.drawString(text.getText(), text.getLoc().x + 2, text.getLoc().y + height - 2);

		SelectionAttributes selectAtt = (SelectionAttributes) text.getAttributes(SelectionAttributes.id);
		if (selectAtt != null) {
			if (selectAtt.isSelected() == true) {
				this.g.setColor(Color.BLACK);
				if (colorAtt.isStroked())
					this.g.drawRect(text.getLoc().x - 2, text.getLoc().y - 2, width + 4, height + 4);
				else
					this.g.drawRect(text.getLoc().x - 2, text.getLoc().y - 2, width + 3, height + 3);
			}
		}
	}

	public void visitCollection(SCollection sc) {

		for (Iterator<Shape> it = sc.iterator(); it.hasNext();) {
			Shape currentShape = it.next();
			currentShape.accept(this);
		}
	}
}
