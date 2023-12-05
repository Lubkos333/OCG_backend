/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ocgBackend.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Friend {
    
    @Column(name = "user_1_ref")
    @ManyToOne
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user; 
    @Column(name = "user_2_ref")
    private User friend;
    @Column (name = "pending")
    private int pending; //0 - are friends,  >0 - waiting for approve
    

   
    public void setUser(User user){
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
    public void setFriend(User friend){
        this.friend = friend;
    }
    
    public User getFriend(){
        return friend;
    }
      
    public void setPending(int pending){
        this.pending = pending;
    }
    
    public int getPending(int pending){
        return this.pending;
    }
    
    
}
