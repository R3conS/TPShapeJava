package graphics.shapes.attributes;

public class SelectionAttributes extends Attributes {

	private static String id = "selection";
	private boolean selected = false;

	public String getId() {
		return SelectionAttributes.id;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void select() {
		this.selected = true;
	}

	public void unselect() {
		this.selected = false;
	}

	public void toggleSelection() {
		this.selected = !this.selected;
	}
}
