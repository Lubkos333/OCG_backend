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

@Table(name = "cards")
@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Card extends IdEntity{
    
    @Column(name = "card_name")
    private String name;
    @Column(name = "card_desc")
    private String description;
    @Column(name = "card_value")
    private int value;
    @Column(name = "card_attack")
    private int attack;
    @Column(name = "card_image")
    private String imagePath;
    
    @ManyToMany(mappedBy = "userCards") // List in User class
    private List<User> cardUsers;

    
}
