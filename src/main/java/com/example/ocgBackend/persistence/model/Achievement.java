/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ocgBackend.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.*;

@Table(name = "achievements")
@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Achievement extends IdEntity {
    
    @Column(name = "achievement_name")
    private String name;
    @Column(name = "achievemen_desc")
    private String description;
    @Column(name = "achievemen_thresold")
    private int thresold;
    
    @ManyToMany(mappedBy = "userAchievements") // List in User class
    List<User> achievementUsers;
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setThresold(int thresold){
        this.thresold = thresold;
    }
    
    public int getThresold(){
        return thresold;
    }
    
    public void setAchievementUsers(List<User> users){
        this.achievementUsers = users;
    }
    
    public List<User> getAchievementUsers(){
        return achievementUsers;
    }

    
}
