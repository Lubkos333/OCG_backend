/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ocgBackend.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "friends")
@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Friend extends IdEntity {
    
    @Column(name = "user_1_ref")
    @ManyToOne
    @JoinColumn(name="user_1_ref", nullable = false)
    private User user; // user TO WHOM was send the request
    @Column(name = "user_2_ref")
    private User friend; // user WHO sent the request
    @Column (name = "pending")
    private int pending; //0 - are friends,  >0 - waiting for approve
   
    public void setUser(User user){
        this.user = user;
    }
    /**
     * Get receiver of the friend request
     * @return one who received the request
    */
    public User getUser(){
        return user;
    }
    
    public void setFriend(User friend){
        this.friend = friend;
    }
    
    /**
     * Get sender of the friend request
     * @return one who sent the request
    */
    public User getFriend(){
        return friend;
    }
      
    public void setPending(int pending){
        this.pending = pending;
    }
    
    /**
     * Gets a value, which determines, if request is pending or approved
     * @return value which is 0 then request is approved, else it is not and it is pending
     */
    public int getPending(){
        return pending;
    }
    
    
}
