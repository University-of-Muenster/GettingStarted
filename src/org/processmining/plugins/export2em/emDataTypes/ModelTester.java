package org.processmining.plugins.export2em.emDataTypes;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ModelTester {
    public static void main(String[] args) {
    	
    
    	ArrayList <ObjectOccurrence> objectOccurences = new ArrayList<ObjectOccurrence>();
    	ArrayList <RelationshipOccurrence> relationshipOccurences = new ArrayList<RelationshipOccurrence>();
    	
    	//set test variables
    	String name = "TestNet";
    	String language = "Petrinet";
    	objectOccurences.add(new ObjectOccurrence("1", "Place", "Place1", 50,50, 0));
    	objectOccurences.add(new ObjectOccurrence("2", "Place", "Place2", 200,50, 0));
    	objectOccurences.add(new ObjectOccurrence("3", "Transition", "Trans1", 125,50, 0));
    	relationshipOccurences.add(new RelationshipOccurrence("PetriArc", "1", "3"));
    	relationshipOccurences.add(new RelationshipOccurrence("PetriArc", "3", "2"));

    	//get test model
    	Model emModel = new Model(name, language, objectOccurences, relationshipOccurences);
    	

      try {

        File file = new File("D:\\export.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Model.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(emModel, file);
        jaxbMarshaller.marshal(emModel, System.out);

          } catch (JAXBException e) {
        e.printStackTrace();
          }

    }
}
