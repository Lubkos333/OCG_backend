package com.example.ocgBackend.persistence.repositories;

import com.example.ocgBackend.persistence.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
