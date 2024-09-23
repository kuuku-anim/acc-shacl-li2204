import java.io.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileUtils;
import org.topbraid.jenax.util.JenaUtil;
import org.topbraid.shacl.validation.ValidationUtil;

public class executeShapes 
{
    private static File TBoxFile = new File("./TBox.rdf");
    private static File ABoxFile = new File("./ABox.rdf");
    private static File shapesFile = new File("./shapes.rdf");
	
    public static void main(String[] args) throws Exception 
    {
        try
        {
			if(args.length==3)
			{
				TBoxFile = new File(args[0]);
				ABoxFile = new File(args[1]);
				shapesFile = new File(args[2]);
			}
			
                //Load the TBox
            Model model = JenaUtil.createMemoryModel();
            FileInputStream fisOntology = new FileInputStream(TBoxFile);
            model.read(fisOntology, "urn:dummy", FileUtils.langTurtle);
            fisOntology.close();
            
                //Load the ABox
            Model ABox = JenaUtil.createMemoryModel();
            FileInputStream fisABox = new FileInputStream(ABoxFile);
            ABox.read(fisABox, "urn:dummy", FileUtils.langTurtle);
            fisABox.close();
            
                //We add the ABox to the TBox, thus model is the union of both.
            model.add(ABox);

                //Load the shapes (yes, they are also in the TBox)
            Model shapes = JenaUtil.createMemoryModel();
            FileInputStream fisShapes = new FileInputStream(shapesFile);
            shapes.read(fisShapes, "urn:dummy", FileUtils.langTurtle);
            fisShapes.close();
            
                //Validate & Print
            Model report = ValidationUtil.validateModel(model, shapes, true).getModel();
            System.out.println(org.topbraid.shacl.util.ModelPrinter.get().print(report));
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
    }
}