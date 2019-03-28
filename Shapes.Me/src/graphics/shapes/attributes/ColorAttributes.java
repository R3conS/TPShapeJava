package graphics.shapes.attributes;

import java.awt.Color;

public class ColorAttributes extends Attributes {

	public static String id = "color";
	private boolean filled;
	private boolean stroked;
	private Color filledColor;
	private Color strokedColor;

	public ColorAttributes(boolean filled, boolean stroked, Color filledColor, Color strokedColor) {
		this.filled = filled;
		this.stroked = stroked;
		this.filledColor = filledColor;
		this.strokedColor = strokedColor;
	}

	public String getId() {
		return ColorAttributes.id;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public boolean isStroked() {
		return stroked;
	}

	public void setStroked(boolean stroked) {
		this.stroked = stroked;
	}

	public Color getFilledColor() {
		return filledColor;
	}

	public void setFilledColor(Color filledColor) {
		this.filledColor = filledColor;
	}

	public Color getStrokedColor() {
		return strokedColor;
	}

	public void setStrokedColor(Color strokedColor) {
		this.strokedColor = strokedColor;
	}

	public String toString() {
		return "ColorAttributes [filled=" + filled + ", stroked=" + stroked + ", filledColor=" + filledColor
				+ ", strokedColor=" + strokedColor + "]";
	}

}
