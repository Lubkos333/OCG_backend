package com.example.ocgBackend.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import lombok.*;

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
    private int victoryCount;
    @Column(name = "user_email")
    private String email;
    
    @OneToMany(mappedBy="user") // mapped in Friend class
    private List<FriendRequest> friends; //List of friends or pending friends

    @ManyToMany
    @JoinTable(
        name = "user_card",
        joinColumns =
        @JoinColumn(name = "user_ref"), inverseJoinColumns =
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
