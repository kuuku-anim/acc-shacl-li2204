import java.util.*;
import java.io.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileUtils;
import org.apache.jena.ontology.*;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.topbraid.jenax.util.JenaUtil;
import org.topbraid.shacl.rules.RuleUtil;

import org.topbraid.shacl.util.ModelPrinter;

public class executeRules 
{
    private static File TBoxFile = new File("./TBox.rdf");
    private static File ABoxFile = new File("./ABox.rdf");
    private static File rulesFile = new File("./rules.rdf");
	
    private static File inferredTriplesFile = new File("./inferredTriples.rdf");
    private static File inferredOntologyFile = new File("./inferredOntology.rdf");
    
    public static void main(String[] args) throws Exception 
    {
        try
        {
			if(args.length==3)
			{
				TBoxFile = new File(args[0]);
				ABoxFile = new File(args[1]);
				rulesFile = new File(args[2]);
			}
			
				//Load the TBox(es)
			Model model = JenaUtil.createMemoryModel();
			FileInputStream fisTBox = new FileInputStream(TBoxFile);
			model.read(fisTBox, "urn:dummy", FileUtils.langTurtle);
			fisTBox.close();
			
				//Load the ABox
			Model ABox = JenaUtil.createMemoryModel();
			FileInputStream fisABox = new FileInputStream(ABoxFile);
			ABox.read(fisABox, "urn:dummy", FileUtils.langTurtle);
			fisABox.close();

				//We add the ABox to the TBox, thus model is the union of both.
			model.add(ABox);
			
				//Inference regulative rules
			Model rules = JenaUtil.createMemoryModel();
			FileInputStream fisRules = new FileInputStream(rulesFile);
			rules.read(fisRules, "urn:dummy", FileUtils.langTurtle);
			fisRules.close();
			
			Model inferredModel = RuleUtil.executeRules(model, rules, null, null);
			inferredModel.setNsPrefixes(ABox.getNsPrefixMap());
			//System.out.println(ModelPrinter.get().print(inferredModel));
			
			FileOutputStream outputStream = new FileOutputStream(inferredTriplesFile);
			RDFDataMgr.write(outputStream, inferredModel, RDFFormat.TURTLE_BLOCKS);
			outputStream.close();
			
			inferredModel = inferredModel.add(ABox);
			outputStream = new FileOutputStream(inferredOntologyFile);
			RDFDataMgr.write(outputStream, inferredModel, RDFFormat.TURTLE_BLOCKS);
			outputStream.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
	}
}