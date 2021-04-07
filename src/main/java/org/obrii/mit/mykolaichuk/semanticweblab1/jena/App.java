/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.mykolaichuk.semanticweblab1.jena;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.VCARD;


/**
 *
 * @author 38068
 */
public class App {

    static String personURI = "http://somewhere/JohnSmith";
    static String fullName = "John Smith";
    static String givenName = "John";
    static String familyName = "Smith";

    public static void main(String[] args) throws FileNotFoundException {
        // some definitions

// create an empty Model
        Model model = ModelFactory.createDefaultModel();

// create the resource
        Resource johnSmith = model.createResource(personURI);

// add the property
        johnSmith.addProperty(VCARD.FN, fullName)
                .addProperty(VCARD.N,
                        model.createResource()
                                .addProperty(VCARD.Given, givenName)
                                .addProperty(VCARD.Family, familyName));

        // list the statements in the Model
        StmtIterator iter = model.listStatements();
        while (iter.hasNext()) {
    Statement stmt      = iter.nextStatement();  // get next statement
    Resource  subject   = stmt.getSubject();     // get the subject
    Property  predicate = stmt.getPredicate();   // get the predicate
    RDFNode   object    = stmt.getObject();      // get the object

    System.out.print(subject.toString());
    System.out.print(" " + predicate.toString() + " ");
    if (object instanceof Resource) {
       System.out.print(object.toString());
    } else {
        // object is a literal
        System.out.print(" \"" + object.toString() + "\"");
    }

    System.out.println(" .");
    
    model.write(System.out);
    
    
    OutputStream outStream = new FileOutputStream("file.xml");
            
            RDFDataMgr.write(outStream,model,Lang.RDFXML);
            
            
            
             // create an empty model
 Model model2 = ModelFactory.createDefaultModel();

 // use the RDFDataMgr to find the input file
 InputStream in = RDFDataMgr.open( "file.xml");
if (in == null) {
    throw new IllegalArgumentException(
                                 "File: " + "file.xml" + " not found");
}

// read the RDF/XML file
model2.read(in, null);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++");
// write it to standard out
model2.write(System.out);
}
    }

}
