/**
 * Created by Stephen on 29/11/2015.
 */
public class SocialMediaTemplate {

    private String socialMediaType;

    private String accountName;

    public SocialMediaTemplate(String socialMediaType, String accountName) {
        this.socialMediaType = socialMediaType;
        this.accountName = accountName;
    }

    public void setSocialMediaType(String socialMediaType) {
        this.socialMediaType = socialMediaType;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getSocialMediaType() {
        return socialMediaType;
    }

    public String getAccountName() {
        return accountName;
    }

    @Override
    public String toString() {
        return socialMediaType + " " + accountName;
    }
}
