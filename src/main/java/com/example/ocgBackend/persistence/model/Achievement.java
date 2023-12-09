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
    @Column(name = "achievement_desc")
    private String description;
    @Column(name = "achievement_threshold")
    private int threshold;
    
    @ManyToMany(mappedBy = "userAchievements") // List in User class
    private List<User> achievementUsers;
    
}
