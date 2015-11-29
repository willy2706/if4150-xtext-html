import com.google.inject.Injector;
import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.IResourceValidator;
import org.xtext.rplsd.cvdsl.CvDslStandaloneSetup;
import org.xtext.rplsd.cvdsl.cvDsl.*;
import org.xtext.rplsd.cvdsl.cvDsl.Biodata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nim_13512065 on 11/29/15.
 */
public class Main {

    private static BiodataTemplate biodata;
    private static List<AcademicTemplate> academics = new ArrayList<>();
    private static List<LanguageTemplate> languages = new ArrayList<>();
    private static List<ExpertiseTemplate> expertises = new ArrayList<>();
    private static List<OrganizationExperienceTemplate> organizationExperiences = new ArrayList<>();
    private static List<CommitteeTemplate> committees = new ArrayList<>();
    private static List<WorkExperienceTemplate> workExperiences = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Injector injector = new CvDslStandaloneSetup().createInjectorAndDoEMFRegistration();
        IResourceValidator iResourceValidator = injector.getInstance(IResourceValidator.class);
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

        Resource resource = resourceSet.getResource(URI.createURI("grammar/input.cvdsl"), true);

        CvRoot model = (CvRoot) resource.getContents().get(0);

        for(CvSection e : model.getSections()){
            if(e instanceof Biodata) {
                biodata = new BiodataTemplate();
                biodata.setName(e.getName());
                biodata.setPlaceOfBirth(((Biodata) e).getBirth_place());
                biodata.setDateOfBirth(((Biodata) e).getBirth_date());
                biodata.setEmail(((Biodata) e).getEmail());
                biodata.setGender(((Biodata) e).getGender().getName());
                biodata.setPhone(((Biodata) e).getPhone());
                biodata.setNationality(((Biodata) e).getNationality());
                biodata.setPhoto(((Biodata) e).getPhoto_path());
                List<SocialMediaTemplate> socialMediaTemplateList = ((Biodata) e).getSocialmedias().stream().map(socialMedia ->
                        new SocialMediaTemplate("dummy", socialMedia.getAccount())).collect(Collectors.toList());
                biodata.setSocialMedias(socialMediaTemplateList);
            } else if (e instanceof Academic) {
                AcademicTemplate academicTemplate = new AcademicTemplate();
                academicTemplate.setName(e.getName());
                academicTemplate.setLevel(((Academic) e).getLevel());
                academicTemplate.setFrom(((Academic) e).getDuration().getFrom());
                academicTemplate.setUntil(((Academic) e).getDuration().getUntil());
                academicTemplate.setMajor(((Academic) e).getMajor());
                academicTemplate.setCity(((Academic) e).getCity());
                academicTemplate.setGpa(((Academic) e).getGpa());
                academics.add(academicTemplate);
            } else if (e instanceof Language) {
                List<LanguageTestTemplate> languageTestTemplates = ((Language) e).getTests().stream().map(languageTest ->
                        new LanguageTestTemplate(languageTest.getTest_name(), languageTest.getScore())).collect(Collectors.toList());
                languages.add(new LanguageTemplate(e.getName(), ((Language) e).getLevel(), languageTestTemplates));
            } else if (e instanceof  Expertise) {
                expertises.add(new ExpertiseTemplate(e.getName()));
            } else if (e instanceof OrganizationExperience) {
                OrganizationExperienceTemplate organizationExperienceTemplate = new OrganizationExperienceTemplate();
                organizationExperienceTemplate.setName(e.getName());
                organizationExperienceTemplate.setFrom(((OrganizationExperience) e).getDuration().getFrom());
                organizationExperienceTemplate.setUntil(((OrganizationExperience) e).getDuration().getUntil());
                organizationExperienceTemplate.setPosition(((OrganizationExperience) e).getPosition());
                organizationExperienceTemplate.setCity(((OrganizationExperience) e).getCity());
                organizationExperiences.add(organizationExperienceTemplate);
            } else if (e instanceof Committee) {
                CommitteeTemplate committeeTemplate = new CommitteeTemplate();
                committeeTemplate.setName(e.getName());
                committeeTemplate.setOrganization(((Committee) e).getOrganization());
                committeeTemplate.setPosition(((Committee) e).getPosition());
                committeeTemplate.setFrom(((Committee) e).getDuration().getFrom());
                committeeTemplate.setUntil(((Committee) e).getDuration().getUntil());
                committees.add(committeeTemplate);
            } else if (e instanceof WorkExperience) {
                WorkExperienceTemplate workExperienceTemplate = new WorkExperienceTemplate();
                workExperienceTemplate.setName(e.getName());
                workExperienceTemplate.setFrom(((WorkExperience) e).getDuration().getFrom());
                workExperienceTemplate.setUntil(((WorkExperience) e).getDuration().getUntil());
                workExperienceTemplate.setPosition(((WorkExperience) e).getPosition());
                workExperienceTemplate.setCity(((WorkExperience) e).getCity());
                workExperiences.add(workExperienceTemplate);
            }
        }
    }
}
