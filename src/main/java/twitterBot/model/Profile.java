package twitterBot.model;

import java.io.File;
import java.util.BitSet;
//What methods do I need here? One for each screenshot

public class Profile {

    //This should be a container to hold information about a profile

    private String username;
    private String url;
    //The Screenshot method should pass this in!
    private String profilePictureBase64;
    private boolean isSecretary;
    private String ownersUrl;
    private int test = 1000;

    public Profile () {}

    public Profile(String username, String url, String profilePictureBase64, boolean isSecretary, String ownersUrl) {
        this.username = username;
        this.url = url;
        this.profilePictureBase64 = profilePictureBase64;
        this.isSecretary = isSecretary;
        this.ownersUrl = ownersUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfilePictureBase64() {
        return profilePictureBase64;
    }

    public void setProfilePictureBase64(String profilePictureBase64) {
        this.profilePictureBase64 = profilePictureBase64;
    }

    public boolean isSecretary() {
        return isSecretary;
    }

    public void setSecretary(boolean secretary) {
        isSecretary = secretary;
    }

    public String getOwnersUrl() {
        return ownersUrl;
    }

    public void setOwnersUrl(String ownersUrl) {
        this.ownersUrl = ownersUrl;
    }

    public int getTest() {
        return test;
    }
}
