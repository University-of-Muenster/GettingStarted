package org.processmining.plugins.export2em.emDataTypes;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType( XmlAccessType.NONE )
public class Model {
	//attributes
	@XmlAttribute(name = "Id")
	private String Id;
	@XmlAttribute(name = "Name")
	private String Name;
	@XmlAttribute(name = "Language")
	private String Language;
	@XmlAttribute(name = "LanguageId")
	private String LanguageId;
	@XmlAttribute(name = "PageWidth")
	private double PageWidth;
	@XmlAttribute(name = "PageHeight")
	private double PageHeight;
	@XmlAttribute(name = "DefaultModelSelection")
	private String DefaultModelSelection;
	@XmlAttribute(name = "Perspective")
	private String Perspective;
	@XmlAttribute(name = "DiagramType")
	private String DiagramType;
	@XmlAttribute(name = "DiagramTypeId")
	private String DiagramTypeId;
	
	//elements
    @XmlElementWrapper(name="ObjectOccurences")
    @XmlElement(name="ObjectOccurence")
	private List<ObjectOccurence> ObjectOccurences;
    @XmlElementWrapper(name="RelationshipOccurences")
    @XmlElement(name="RelationshipOccurence")
	private List<RelationshipOccurence> RelationshipOccurences;
	
	//standard constructor for JAXB
	public Model(){};
	
	public Model(String name, String language, List<ObjectOccurence> objectOccurences, List<RelationshipOccurence> relationshipOccurences){
		Id = LanguageId = DefaultModelSelection = DiagramTypeId = "dummy";
		Name = name;
		Language = language;
		ObjectOccurences = objectOccurences;
		RelationshipOccurences = relationshipOccurences;
		PageWidth = CalculateSheetWidth();
		PageHeight = CalculateSheetHeight();
	}

	private double CalculateSheetHeight() {
		double max = 0;
		for (ObjectOccurence objectOccurence : ObjectOccurences) {
			if (objectOccurence.getY_Position() > max)
				max = objectOccurence.getY_Position();
		}
		return max+100;
	}

	private double CalculateSheetWidth() {
		double max = 0;
		for (ObjectOccurence objectOccurence : ObjectOccurences) {
			if (objectOccurence.getX_Position() > max)
				max = objectOccurence.getX_Position();
		}
		return max+100;
	}
	
	
	

}
