package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;

public class FontAttributes extends Attributes {

	private static String id = "font";
	private Font font;
	private Color fontColor;
	private FontRenderContext frc;
	private int fontSize;
	private int fontStyle;
	private String fontType;

	public String getId() {
		return FontAttributes.id;
	}

	public FontAttributes() {
		this.fontSize=12;
		this.fontStyle = 1;
		this.fontType="Verdana";
		this.fontColor=Color.black;
		
		this.font = new Font(fontType, fontStyle, fontSize);
		this.setFontColor(fontColor);
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.font.deriveFont(fontSize);
		this.fontSize = fontSize;
	}

	public String getFontType() {
		return fontType;
	}

	public void setFontType(String fontType) {
		this.fontType = fontType;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public FontRenderContext getFrc() {
		return frc;
	}

	public void setFrc(FontRenderContext frc) {
		this.frc = frc;
	}

	public void grow(int x, int y) {
		setFontSize(this.font.getSize() + (x + y) / 2);
		this.font = new Font(fontType, fontStyle, fontSize).deriveFont(this.font.getSize() + (x + y) / 2);
	}
}
