package org.processmining.plugins.export2em.emDataTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
@XmlAccessorType( XmlAccessType.NONE )
public class RelationshipOccurrence {

	//attributes
	@XmlAttribute(name="Id")
	private String Id;
	@XmlAttribute(name="ElementId")
	private String ElementId;
	@XmlAttribute(name="SourceElementOccurrence")
	private String SourceElementOccurrence;
	@XmlAttribute(name="TargetElementOccurrence")
	private String TargetElementOccurrence;
	@XmlAttribute(name="RelationshipType")
	private String RelationshipType;
	
	public RelationshipOccurrence(){}
	
	public RelationshipOccurrence(String relationshipType, String source, String target){
		Id = ElementId = "dummy";
		RelationshipType =relationshipType;
		SourceElementOccurrence = source;
		TargetElementOccurrence = target;
		
	}
}
