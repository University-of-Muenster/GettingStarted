package org.processmining.plugins.export2em.converters;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import org.processmining.models.connections.GraphLayoutConnection;
import org.processmining.models.graphbased.AbstractGraphElement;
import org.processmining.models.graphbased.directed.petrinet.Petrinet;
import org.processmining.models.graphbased.directed.petrinet.PetrinetEdge;
import org.processmining.models.graphbased.directed.petrinet.PetrinetNode;
import org.processmining.models.graphbased.directed.petrinet.elements.ExpandableSubNet;
import org.processmining.plugins.export2em.emDataTypes.Model;
import org.processmining.plugins.export2em.emDataTypes.ObjectOccurrence;
import org.processmining.plugins.export2em.emDataTypes.RelationshipOccurrence;

public class PetrinetConverter extends AbstractConverter {

	public static Model convert(Petrinet source, GraphLayoutConnection layout) {
		List<ObjectOccurrence> objectOccurences = new ArrayList<ObjectOccurrence>();
		List<RelationshipOccurrence> relationshipOccurences = new ArrayList<RelationshipOccurrence>();
		//get ObjectOccurences
		for (PetrinetNode node : source.getNodes()) {
			objectOccurences.add(new ObjectOccurrence(""+node.hashCode(), node.getClass().getSimpleName(), node.getLabel(), getElementCoordinates(node,layout).getX(), getElementCoordinates(node, layout).getY(), 0));

		}
		//get RelationshipOccurences
		for (PetrinetEdge edge : source.getEdges()) {
			relationshipOccurences.add(new RelationshipOccurrence(edge.getClass().getSimpleName(), ""+edge.getSource().hashCode(), ""+edge.getTarget().hashCode()));
		}
		Model modelToReturn = new Model(source.getLabel(), source.getClass().getSimpleName(), objectOccurences, relationshipOccurences); 
		return modelToReturn;
		
	}
	/*
	 * Taken from Petrinet package and adapted to fit to em converter
	 */
	private static Point2D getElementCoordinates(AbstractGraphElement element,	GraphLayoutConnection layout) {
		Point2D result = null;
		double emNodeWidth = 100;
		double emNodeHeight = 30;
		
		try {
			/*
			 * Map the position from position-of-left-upper-corner to
			 * position-of-center.
			 */
			Point2D pos = layout.getPosition(element);
			if (pos == null) {
				pos = new Point2D.Double(10,10);
			}
//			Dimension size = (Dimension) element.getAttributeMap().get(AttributeMap.SIZE);
//			double x = pos.getX()*1.1 + size.getWidth();
//			double y = pos.getY()*1.1 - size.getHeight()/2; 
			
			double x = pos.getX()*1.3 + emNodeWidth;
			double y = pos.getY()*1.3 - emNodeHeight; 
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
