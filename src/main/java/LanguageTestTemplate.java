public class LanguageTestTemplate {

    private String testName;

    private String score;

    public LanguageTestTemplate(String testName, String score) {
        this.testName = testName;
        this.score = score;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String toString() {
        return testName + " " + score;
    }

}
