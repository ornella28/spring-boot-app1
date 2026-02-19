package se.lexicon.spring_boot_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode


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

    @OneToOne(mappedBy = "userProfile")
    private Customer customer;





}
