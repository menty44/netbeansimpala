package accountbalance;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
 
public class HelloDrools {
 
    private static KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
    private static Collection<KnowledgePackage> pkgs;
    private static KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
    private static StatefulKnowledgeSession ksession;
 
    public static void main(final String[] args) {
 
        initDrools();
        initMessageObject();
        fireRules();
 
    }
 
    private static void initDrools(){
 
        // this will parse and compile in one step
        // read from file
        kbuilder.add( ResourceFactory.newClassPathResource( "/hellodrools/testrules.drl",HelloDrools.class),ResourceType.DRL );
 
        // read second rule from String
        String myRule = "import hellodrools.Message rule \"Hello World 2\" when message:Message (type==\"Test\") then System.out.println(\"Test, Drools!\"); end";
        Resource myResource = ResourceFactory.newReaderResource((Reader) new StringReader(myRule));
        kbuilder.add(myResource, ResourceType.DRL);
 
        // Check the builder for errors
        if ( kbuilder.hasErrors() ) {
            System.out.println( kbuilder.getErrors().toString() );
            throw new RuntimeException( "Unable to compile drl\"." );
        }
 
        // get the compiled packages (which are serializable)
        pkgs = kbuilder.getKnowledgePackages();
 
        // add the packages to a knowledgebase (deploy the knowledge packages).
        kbase.addKnowledgePackages( pkgs );
 
        ksession = kbase.newStatefulKnowledgeSession();
    }
 
    private static void fireRules(){
        ksession.fireAllRules();
    }
 
    private static void initMessageObject() {
//        Message msg = new Message();
//        msg.setType("Hello");
//        ksession.insert(msg);
    
        String input = null;
        int number = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a number");
            input = bufferedReader.readLine();
            number = Integer.parseInt(input);      

            
            System.out.println("number entered is : " + number);
        } catch (NumberFormatException ex) {
           System.out.println("Not a number !");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Message number = new Message();
        number.setType(number);
        ksession.insert(number);
        
    }
}