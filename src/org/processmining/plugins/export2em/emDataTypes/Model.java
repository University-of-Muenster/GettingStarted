package org.processmining.plugins.export2em.emDataTypes;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Model")
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
    @XmlElementWrapper(name="ObjectOccurrences")
    @XmlElement(name="ObjectOccurrence")
	private List<ObjectOccurrence> ObjectOccurrences;
    @XmlElementWrapper(name="RelationshipOccurrences")
    @XmlElement(name="RelationshipOccurrence")
	private List<RelationshipOccurrence> RelationshipOccurrences;
	
	//standard constructor for JAXB
	public Model(){};
	
	public Model(String name, String language, List<ObjectOccurrence> objectOccurrences, List<RelationshipOccurrence> relationshipOccurrences){
		Id = LanguageId = DefaultModelSelection = DiagramTypeId = "dummy";
		Name = name;
		Language = language;
		ObjectOccurrences = objectOccurrences;
		RelationshipOccurrences = relationshipOccurrences;
		PageWidth = CalculateSheetWidth();
		PageHeight = CalculateSheetHeight();
	}

	private double CalculateSheetHeight() {
		double max = 0;
		for (ObjectOccurrence objectOccurrence : ObjectOccurrences) {
			if (objectOccurrence.getY_Position() > max)
				max = objectOccurrence.getY_Position();
		}
		return max+100;
	}

	private double CalculateSheetWidth() {
		double max = 0;
		for (ObjectOccurrence objectOccurrence : ObjectOccurrences) {
			if (objectOccurrence.getX_Position() > max)
				max = objectOccurrence.getX_Position();
		}
		return max+100;
	}
	
	
	

}
