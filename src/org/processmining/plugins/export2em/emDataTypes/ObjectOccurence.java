package org.processmining.plugins.export2em.emDataTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType( XmlAccessType.NONE )
public class ObjectOccurence {
	
	//attributes
	@XmlAttribute(name="Id")
	private String Id;
	@XmlAttribute(name="ElementId")
	private String ElementId;
	@XmlAttribute(name="ElementTypeName")
	private String ElementTypeName;
	@XmlAttribute(name="ElementTypeId")
	private String ElementTypeId;
	@XmlAttribute(name="Caption")
	private String Caption;
	@XmlAttribute(name="X-Position")
	private int X_Position;
	@XmlAttribute(name="Y-Position")
	private int Y_Position;
	@XmlAttribute(name="Z-Position")
	private int Z_Position;
	
	public ObjectOccurence(String id, String elementTypeName, String caption, int x, int y, int z){
		ElementId = ElementTypeId = "dummy";
		Id = id;
		ElementTypeName = elementTypeName;
		Caption = caption;
		setX_Position(x);
		setY_Position(x);
		Z_Position = x;
		
	}
	
	public ObjectOccurence(){}

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
