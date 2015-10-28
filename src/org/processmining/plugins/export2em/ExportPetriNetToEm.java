package org.processmining.plugins.export2em;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import org.processmining.contexts.uitopia.UIPluginContext;
import org.processmining.framework.connections.ConnectionCannotBeObtained;
import org.processmining.models.connections.GraphLayoutConnection;
import org.processmining.models.connections.petrinets.behavioral.InitialMarkingConnection;
import org.processmining.models.graphbased.directed.petrinet.Petrinet;
import org.processmining.models.graphbased.directed.petrinet.PetrinetGraph;
import org.processmining.models.semantics.petrinet.Marking;
import org.processmining.plugins.pnml.Pnml;

public class ExportPetriNetToEm {
	
	protected void exportPetriNetToEmFile(UIPluginContext context, Petrinet net, File file) throws IOException {
		Marking marking;
		try {
			marking = context.tryToFindOrConstructFirstObject(Marking.class, InitialMarkingConnection.class,
					InitialMarkingConnection.MARKING, net);
		} catch (ConnectionCannotBeObtained e) {
			// use empty marking\
			marking = new Marking();
		}
		GraphLayoutConnection layout;
		try {
			layout = context.getConnectionManager().getFirstConnection(GraphLayoutConnection.class, context, net);
		} catch (ConnectionCannotBeObtained e) {
			layout = new GraphLayoutConnection(net);
		}
		HashMap<PetrinetGraph, Marking> markedNets = new HashMap<PetrinetGraph, Marking>();
		markedNets.put(net, marking);
		Pnml pnml = new Pnml().convertFromNet(markedNets, layout);
		//pnml.setType(type);
		String text = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" + pnml.exportElement(pnml);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		bw.write(text);
		bw.close();
	}

}

