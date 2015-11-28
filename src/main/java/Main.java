import com.google.inject.Injector;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.IResourceValidator;
import org.xtext.rplsd.cvdsl.CvDslStandaloneSetup;
import org.xtext.rplsd.cvdsl.cvDsl.CvRoot;
import org.xtext.rplsd.cvdsl.cvDsl.CvSection;

import java.io.IOException;

/**
 * Created by nim_13512065 on 11/29/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Injector injector = new CvDslStandaloneSetup().createInjectorAndDoEMFRegistration();
        IResourceValidator iResourceValidator = injector.getInstance(IResourceValidator.class);
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

        Resource resource = resourceSet.getResource(URI.createURI("grammar/input.cvdsl"), true);
//        List<Issue> issues = iResourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
//        if (issues.size() != 0) {
//            for (Issue issue : issues) {
//                System.err.println(issue);
//            }
//            System.exit(1);
//        }

        CvRoot model = (CvRoot) resource.getContents().get(0);

        for(CvSection e:model.getSections()){
            System.out.println(e);
        }
    }
}
