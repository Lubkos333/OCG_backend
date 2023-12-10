package com.example.ocgBackend.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "users")
@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User extends IdEntity {

    @Column(name = "user_name")
    private String name;
    @Column(name = "user_password")
    private String password;
    @Column(name = "victory_count")
    private Integer victoryCount;
    @Column(name = "user_email")
    private String email;
    
    @OneToMany(mappedBy="user") // mapped in Friend class
    private List<FriendRequest> friends; //List of friends or pending friends

    @ManyToMany
    @JoinTable(
        name = "user_cards",
        joinColumns =
            @JoinColumn(name = "user_ref"),
        inverseJoinColumns =
            @JoinColumn(name = "card_ref")
        )
    private List<Card> userCards;
    
    @ManyToMany
    @JoinTable(
        name = "user_achievement",
        joinColumns =
        @JoinColumn(name = "user_ref"), inverseJoinColumns =
            @JoinColumn(name = "achievement_ref")
        )
    private List<Achievement> userAchievements;

}
