package org.processmining.plugins.export2em.converters;

import java.util.ArrayList;
import java.util.List;

import org.processmining.models.graphbased.directed.petrinet.Petrinet;
import org.processmining.models.graphbased.directed.petrinet.PetrinetEdge;
import org.processmining.models.graphbased.directed.petrinet.PetrinetNode;
import org.processmining.plugins.export2em.emDataTypes.Model;
import org.processmining.plugins.export2em.emDataTypes.ObjectOccurence;
import org.processmining.plugins.export2em.emDataTypes.RelationshipOccurence;

public class PetrinetConverter extends AbstractConverter {

	public static Model convert(Petrinet source) {
		List<ObjectOccurence> objectOccurences = new ArrayList<ObjectOccurence>();
		List<RelationshipOccurence> relationshipOccurences = new ArrayList<RelationshipOccurence>();
		//get ObjectOccurences
		for (PetrinetNode node : source.getNodes()) {
			objectOccurences.add(new ObjectOccurence(node.toString(), node.getClass().getTypeName(), node.getLabel(), 0, 0, 0));
		}
		//get RelationshipOccurences
		for (PetrinetEdge edge : source.getEdges()) {
			relationshipOccurences.add(new RelationshipOccurence(edge.getClass().getTypeName(), edge.getSource().toString(), edge.getTarget().toString()));
		}
		Model modelToReturn = new Model(source.getLabel(), source.getClass().getTypeName(), objectOccurences, relationshipOccurences); 
		return modelToReturn;
	}

}
