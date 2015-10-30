package org.processmining.plugins.export2em.converters;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import org.processmining.models.connections.GraphLayoutConnection;
import org.processmining.models.graphbased.AbstractGraphElement;
import org.processmining.models.graphbased.AttributeMap;
import org.processmining.models.graphbased.directed.petrinet.Petrinet;
import org.processmining.models.graphbased.directed.petrinet.PetrinetEdge;
import org.processmining.models.graphbased.directed.petrinet.PetrinetNode;
import org.processmining.models.graphbased.directed.petrinet.elements.ExpandableSubNet;
import org.processmining.plugins.export2em.emDataTypes.Model;
import org.processmining.plugins.export2em.emDataTypes.ObjectOccurence;
import org.processmining.plugins.export2em.emDataTypes.RelationshipOccurence;

public class PetrinetConverter extends AbstractConverter {

	public static Model convert(Petrinet source, GraphLayoutConnection layout) {
		List<ObjectOccurence> objectOccurences = new ArrayList<ObjectOccurence>();
		List<RelationshipOccurence> relationshipOccurences = new ArrayList<RelationshipOccurence>();
		//get ObjectOccurences
		for (PetrinetNode node : source.getNodes()) {
			objectOccurences.add(new ObjectOccurence(node.toString(), node.getClass().getSimpleName(), node.getLabel(), getElementCoordinates(node,layout).getX(), getElementCoordinates(node, layout).getY(), 0));
		}
		//get RelationshipOccurences
		for (PetrinetEdge edge : source.getEdges()) {
			relationshipOccurences.add(new RelationshipOccurence(edge.getClass().getSimpleName(), edge.getSource().toString(), edge.getTarget().toString()));
		}
		Model modelToReturn = new Model(source.getLabel(), source.getClass().getTypeName(), objectOccurences, relationshipOccurences); 
		return modelToReturn;
		
	}
	
	private static Point2D getElementCoordinates(AbstractGraphElement element,	GraphLayoutConnection layout) {
		Point2D result = null;
		try {
			/*
			 * Map the position from position-of-left-upper-corner to
			 * position-of-center.
			 */
			Point2D pos = layout.getPosition(element);
			if (pos == null) {
				pos = new Point2D.Double(10,10);
			}
			Dimension size = (Dimension) element.getAttributeMap().get(AttributeMap.SIZE);
			double x = pos.getX() + size.getWidth() / 2;
			double y = pos.getY() + size.getHeight() / 2;
			/*
			 * If this happens to be a sub net, then the current position is the
			 * position of the rectangular space surrounding it. Correct this
			 * (the empty space around the sub net measures 20 pixels, so it
			 * seems.
			 */
			if (element instanceof ExpandableSubNet) {
				x += 20.0;
				y += 20.0;
			}
			pos.setLocation(x, y);
			result = pos;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
