package org.processmining.plugins.export2em.emDataTypes;

import java.util.List;

public class Model {
	//attributes
	private String Id;
	private String Name;
	private String Language;
	private String LanguageId;
	private double PageWidth;
	private double PageHeight;
	private String DefaultModelSelection;
	private String Perspective;
	private String DiagramType;
	private String DiagramTypeId;
	
	//elements
	private List<ObjectOccurence> ObjectOccurences;
	private List<RelationshipOccurence> RelationshipOccurences;
	
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
		return max;
	}

	private double CalculateSheetWidth() {
		double max = 0;
		for (ObjectOccurence objectOccurence : ObjectOccurences) {
			if (objectOccurence.getX_Position() > max)
				max = objectOccurence.getX_Position();
		}
		return max;
	}
	
	
	

}
