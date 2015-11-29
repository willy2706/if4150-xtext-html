public class AcademicTemplate {

    private String name;

    private String level;

    private String from;

    private String until;

    private String major;

    private String city;

    private String gpa;

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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public void print() {
        System.out.println(name);
        System.out.println(level);
        System.out.println(from);
        System.out.println(until);
        System.out.println(major);
        System.out.println(city);
        System.out.println(gpa);
        System.out.println("=======");
    }
}
