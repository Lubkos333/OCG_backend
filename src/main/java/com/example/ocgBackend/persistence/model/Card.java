/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ocgBackend.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    
    public void setValue(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setAttack(int attack){
        this.attack = attack;
    }
    
    public int getAttack(){
        return attack;
    }
    
    public void setImagePath(String path){
        this.imagePath = path;
    }
    
    public String getImagePath(){
        return imagePath;
    }
    
}
