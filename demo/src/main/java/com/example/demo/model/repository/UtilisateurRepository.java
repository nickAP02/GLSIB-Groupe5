package com.example.demo.model.repository;

import com.example.demo.model.Utilisateur;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    @Transactional
    @Query("SELECT id from Utilisateur u WHERE u.username =:username")
     Utilisateur getUserByUsername(String username);
    @Transactional
    @Query("SELECT id from Utilisateur")
    int getUserById(int id);
}
