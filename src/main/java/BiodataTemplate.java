import java.util.ArrayList;
import java.util.List;

public class BiodataTemplate {

    private String name;

    private String placeOfBirth;

    private String dateOfBirth;

    private String email;

    private String gender;

    private String phone;

    private String nationality;

    private String photo;

    private List<SocialMediaTemplate> socialMedias = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<SocialMediaTemplate> getSocialMedias() {
        return socialMedias;
    }

    public void setSocialMedias(List<SocialMediaTemplate> socialMedias) {
        this.socialMedias = socialMedias;
    }

    public void print() {
        System.out.println(name);
        System.out.println(placeOfBirth);
        System.out.println(dateOfBirth);
        System.out.println(email);
        System.out.println(gender);
        System.out.println(phone);
        System.out.println(nationality);
        System.out.println(photo);
        System.out.println(socialMedias);
        System.out.println("=======");
    }
}
