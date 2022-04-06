package com.example.demo.model.repository;

import com.example.demo.model.Approvisionnement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApproRepository extends JpaRepository<Approvisionnement, Integer> {
}
