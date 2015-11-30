import java.util.List;

public class WorkExperienceTemplate {

    private String name;

    private String from;

    private String until;

    private String position;

    private String city;

    private List<String> infos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getInfos() { return infos; }

    public void setInfos(List<String> infos) { this.infos = infos; }

    public void print() {
        System.out.println(name);
        System.out.println(from);
        System.out.println(until);
        System.out.println(position);
        System.out.println(city);
        System.out.println("=======");
    }

}
