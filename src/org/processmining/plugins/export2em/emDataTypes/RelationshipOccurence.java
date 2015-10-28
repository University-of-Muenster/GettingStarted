package org.processmining.plugins.export2em.emDataTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
@XmlAccessorType( XmlAccessType.NONE )
public class RelationshipOccurence {

	//attributes
	@XmlAttribute(name="Id")
	private String Id;
	@XmlAttribute(name="ElementId")
	private String ElementId;
	@XmlAttribute(name="SourceElementOccurence")
	private String SourceElementOccurence;
	@XmlAttribute(name="TargetElementOccurence")
	private String TargetElementOccurence;
	@XmlAttribute(name="RelationshipType")
	private String RelationshipType;
	
	public RelationshipOccurence(){}
	
	public RelationshipOccurence(String relationshipType, String source, String target){
		Id = ElementId = "dummy";
		RelationshipType =relationshipType;
		SourceElementOccurence = source;
		TargetElementOccurence = target;
		
	}
}
