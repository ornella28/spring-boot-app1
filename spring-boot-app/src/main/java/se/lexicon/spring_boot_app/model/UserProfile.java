package se.lexicon.spring_boot_app.model;

import java.util.Objects;

public class UserProfile {
    private long id;
    private String nickname;
    private String phoneNumber;
    private String bio;


    //Getter and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    //Constructor without parameter

    public UserProfile() {
    }

    //Constructor with parameter
    public UserProfile(long id, String nickname, String phoneNumber, String bio) {
        this.id = id;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return id == that.id && Objects.equals(nickname, that.nickname) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(bio, that.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, phoneNumber, bio);
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
