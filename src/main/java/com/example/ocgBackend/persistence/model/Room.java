package com.example.ocgBackend.persistence.model;

import com.example.ocgBackend.rest.api.dto.RoomState;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "room")
@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Room extends IdEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private RoomState state;

    @OneToOne
    @JoinColumn(name = "user_1_id")
    private User userOne;

    @OneToOne
    @JoinColumn(name = "user_2_id")
    private User userTwo;

}
