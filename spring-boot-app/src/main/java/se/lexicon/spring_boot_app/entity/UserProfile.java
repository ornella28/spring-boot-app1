package se.lexicon.spring_boot_app.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_profiles")
/*
* created table user_profiles
* */
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
     /*
     * it will define Id as primary key
     * added column in the database  with required length and character
     * */
    private Long id;
    @Column(nullable = false, length = 100)
    private String nickname;
    @Column(nullable = false, length = 100)
    private String phoneNumber;
    @Column(length = 500)
    private String bio;


    //Getter and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public UserProfile(Long id, String nickname, String phoneNumber, String bio) {
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
