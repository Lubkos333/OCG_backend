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
    public List<Friend> friends; //List of friends or pending friends

    @ManyToMany
    @JoinTable(
        name = "user_card",
        joinColumns =
        @JoinColumn(name = "user_ref"), inverseJoinColumns =
            @JoinColumn(name = "card_ref")
        )
    List<Card> userCards;
    
    @ManyToMany
    @JoinTable(
        name = "user_achievement",
        joinColumns =
        @JoinColumn(name = "user_ref"), inverseJoinColumns =
            @JoinColumn(name = "achievement_ref")
        )
    List<Achievement> userAchievements;
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setVictoryCount(int victoryCount){
        this.victoryCount = victoryCount;
    }
    
    public int getVictoryCount(){
        return victoryCount;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
   public void setUserCards(List<Card> cards){
       this.userCards = cards;
   }
   
   public List<Card> getUserCards(){
       return userCards;
   }
   
   public void setUserAchievements(List<Achievement> achievements){
       this.userAchievements = achievements;
   }
   
   public List<Achievement> getUserAchievements(){
       return userAchievements;
   }
   
   public void setUserFriends(List<Friend> friends){
       this.friends = friends;
   }
   
   public List<Friend> getUserFriends(){
       return friends;
   }
}
