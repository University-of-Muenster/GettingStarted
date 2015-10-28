package org.processmining.plugins.export2em;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.processmining.contexts.uitopia.UIPluginContext;
import org.processmining.contexts.uitopia.annotations.UIExportPlugin;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.connections.ConnectionCannotBeObtained;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.framework.plugin.annotations.PluginVariant;
import org.processmining.models.connections.GraphLayoutConnection;
import org.processmining.models.connections.petrinets.behavioral.InitialMarkingConnection;
import org.processmining.models.graphbased.directed.petrinet.Petrinet;
import org.processmining.models.graphbased.directed.petrinet.PetrinetGraph;
import org.processmining.models.semantics.petrinet.Marking;
import org.processmining.plugins.export2em.converters.PetrinetConverter;
import org.processmining.plugins.export2em.emDataTypes.Model;

@Plugin(name = "Export to em", returnLabels = {}, returnTypes = {}, parameterLabels = { "Petri net", "File" }, userAccessible = true)
@UIExportPlugin(description = "Em XML", extension = "xml")
public class ExportPlugin {
	
	@UITopiaVariant(affiliation = "WWU Münster", author = "Tobias Potthoff, Rainer Cording", email = "no@mail.de")
	@PluginVariant(variantLabel = "String export (txt)", requiredParameterLabels = { 0, 1 })
	public void export(UIPluginContext context, Petrinet net, File file) throws IOException {
		
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
		//Pnml pnml = new Pnml().convertFromNet(markedNets, layout);
		//pnml.setType(type);
		Model emModel = PetrinetConverter.convert(net);
		//String text = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" + pnml.exportElement(pnml);
		try{
	        JAXBContext jaxbContext = JAXBContext.newInstance(Model.class);
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	        // output pretty printed
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	        jaxbMarshaller.marshal(emModel, file);
	        jaxbMarshaller.marshal(emModel, System.out);
		}
		catch(Exception e){}
		
		

		
//		FileWriter writer = new FileWriter(file);
//		PrintWriter pwriter = new PrintWriter(writer);
//		pwriter.print("test");
//		pwriter.close();
	}
}