package com.example.ocgBackend.persistence.repositories;

import com.example.ocgBackend.persistence.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
}
