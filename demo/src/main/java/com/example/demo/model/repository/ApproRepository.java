package com.example.demo.model.repository;

import com.example.demo.model.Approvisionnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproRepository extends JpaRepository<Approvisionnement, Integer> {

}
