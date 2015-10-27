package org.processmining.plugins.export2em.emDataTypes;

public class RelationshipOccurence {

	//attributes
	private String Id;
	private String ElementId;
	private String SourceElementOccurence;
	private String TargetElementOccurence;
	private String RelationshipType;
	
	public RelationshipOccurence(String relationshipType, String source, String target){
		Id = ElementId = "dummy";
		RelationshipType =relationshipType;
		SourceElementOccurence = source;
		TargetElementOccurence = target;
		
	}
}
