import com.google.inject.Injector;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.xtext.rplsd.cvdsl.CvDslStandaloneSetup;
import org.xtext.rplsd.cvdsl.cvDsl.*;
import org.xtext.rplsd.cvdsl.cvDsl.Biodata;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        // Argumen harus 2, yang pertama berisi input dsl, yang kedua berisi output html
        // contoh : main grammar/input.cvdsl html/index.html
        // index.ftl harus selalu sefolder dengan .jar
        if(args.length != 2) {
            System.err.println("Not enough argument, argument should be : ");
            System.err.println("<input dsl> <output html>");
            System.exit(2);
        }

        Injector injector = new CvDslStandaloneSetup().createInjectorAndDoEMFRegistration();
        IResourceValidator iResourceValidator = injector.getInstance(IResourceValidator.class);
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        Resource resource = resourceSet.getResource(URI.createURI(args[0]), true);
        List<Issue> issues = iResourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
        if (issues.size() != 0) {
            for (Issue issue : issues) {
                System.err.println(issue);
            }
            System.exit(1);
        }

        // Create your Configuration instance, and specify if up to what FreeMarker
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

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
                List<SocialMediaTemplate> socialMediaTemplateList = new ArrayList<>();
                for(SocialMedia socialMedia : ((Biodata) e).getSocialmedias()) {
                    socialMediaTemplateList.add(new SocialMediaTemplate(socialMedia.getType().getName(), socialMedia.getAccount()));
                }
                biodata.setSummary(((Biodata) e).getSummary());
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
                List<LanguageTestTemplate> languageTestTemplates = new ArrayList<>();
                for(LanguageTest languageTest : ((Language) e).getTests()) {
                    languageTestTemplates.add(new LanguageTestTemplate(languageTest.getTest_name(), languageTest.getScore()));
                }
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
                List<String> stringList = new ArrayList<>();
                for (String s : ((OrganizationExperience) e).getInfo()) {
                    stringList.add(s);
                }
                organizationExperienceTemplate.setInfos(stringList);
                organizationExperiences.add(organizationExperienceTemplate);
            } else if (e instanceof Committee) {
                CommitteeTemplate committeeTemplate = new CommitteeTemplate();
                committeeTemplate.setName(e.getName());
                committeeTemplate.setOrganization(((Committee) e).getOrganization());
                committeeTemplate.setPosition(((Committee) e).getPosition());
                committeeTemplate.setFrom(((Committee) e).getDuration().getFrom());
                committeeTemplate.setUntil(((Committee) e).getDuration().getUntil());
                List<String> stringList = new ArrayList<>();
                for (String s : ((Committee) e).getInfo()) {
                    stringList.add(s);
                }
                committeeTemplate.setInfos(stringList);
                committees.add(committeeTemplate);
            } else if (e instanceof WorkExperience) {
                WorkExperienceTemplate workExperienceTemplate = new WorkExperienceTemplate();
                workExperienceTemplate.setName(e.getName());
                workExperienceTemplate.setFrom(((WorkExperience) e).getDuration().getFrom());
                workExperienceTemplate.setUntil(((WorkExperience) e).getDuration().getUntil());
                workExperienceTemplate.setPosition(((WorkExperience) e).getPosition());
                workExperienceTemplate.setCity(((WorkExperience) e).getCity());
                List<String> stringList = new ArrayList<>();
                for (String s : ((WorkExperience) e).getInfo()) {
                    stringList.add(s);
                }
                workExperienceTemplate.setInfos(stringList);
                workExperiences.add(workExperienceTemplate);
            }
        }

        Map<String, Object> root = new HashMap<>();
        root.put("biodata", biodata);
        if(!academics.isEmpty()) {
            root.put("academics", academics);
        }
        if(!languages.isEmpty()) {
            root.put("languages", languages);
        }
        if(!expertises.isEmpty()) {
            root.put("expertises", expertises);
        }
        if(!organizationExperiences.isEmpty()) {
            root.put("organizationExperiences", organizationExperiences);
        }
        if(!committees.isEmpty()) {
            root.put("committees", committees);
        }
        if(!workExperiences.isEmpty()) {
            root.put("workExperiences", workExperiences);
        }

        Template temp = cfg.getTemplate("index.ftl");
        Writer out = new OutputStreamWriter(new FileOutputStream(args[1]));
        try {
            temp.process(root, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
