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

@Table(name = "friend_request")
@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FriendRequest extends IdEntity {

    @ManyToOne
    @JoinColumn(name="user_1_ref", nullable = false)
    private User user; // user TO WHOM was send the request
    @ManyToOne
    @JoinColumn(name="user_2_ref", nullable = false)
    private User friend; // user WHO sent the request
    @Column (name = "pending")
    private int pending; //0 - are friends,  >0 - waiting for approve
    
}
