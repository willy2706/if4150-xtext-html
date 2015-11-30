import java.util.List;

public class CommitteeTemplate {

    private String name;

    private String organization;

    private String position;

    private String from;

    private String until;

    private List<String> infos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public List<String> getInfos() { return infos; }

    public void setInfos(List<String> infos) { this.infos = infos; }

    public void print() {
        System.out.println(name);
        System.out.println(organization);
        System.out.println(position);
        System.out.println(from);
        System.out.println(until);
        System.out.println("======");
    }
}
