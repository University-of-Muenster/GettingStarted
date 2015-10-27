package org.processmining.plugins.export2em.emDataTypes;

public class ObjectOccurence {
	
	//attributes
	private String Id;
	private String ElementId;
	private String ElementTypeName;
	private String ElementTypeId;
	private String Caption;
	private int X_Position;
	private int Y_Position;
	private int Z_Position;
	
	public ObjectOccurence(String elementTypeName, String caption, int x, int y, int z){
		Id = ElementId = ElementTypeId = "dummy";
		ElementTypeName = elementTypeName;
		Caption = caption;
		setX_Position(x);
		setY_Position(x);
		Z_Position = x;
		
	}

	public int getX_Position() {
		return X_Position;
	}

	public void setX_Position(int x_Position) {
		X_Position = x_Position;
	}

	public int getY_Position() {
		return Y_Position;
	}

	public void setY_Position(int y_Position) {
		Y_Position = y_Position;
	}
	

}
