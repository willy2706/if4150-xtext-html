import java.util.ArrayList;
import java.util.List;

public class LanguageTemplate {

    private String name;

    private String level;

    private List<LanguageTestTemplate> tests = new ArrayList<>();

    public LanguageTemplate(String name, String level, List<LanguageTestTemplate> tests) {
        this.name = name;
        this.level = level;
        this.tests = tests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<LanguageTestTemplate> getTests() {
        return tests;
    }

    public void setTest(List<LanguageTestTemplate> tests) {
        this.tests = tests;
    }

    public void print() {
        System.out.println(name);
        System.out.println(level);
        System.out.println(tests);
        System.out.println("=======");
    }

}
