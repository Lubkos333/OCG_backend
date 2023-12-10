package com.example.ocgBackend.persistence.repositories;

import com.example.ocgBackend.persistence.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}
