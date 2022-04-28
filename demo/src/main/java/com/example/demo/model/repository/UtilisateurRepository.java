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
    @Query(value = "SELECT * from users u WHERE u.username =:username",nativeQuery = true)
     Utilisateur getUserByUsername(String username);
    @Transactional
    @Query(value = "SELECT id from users id =:id",nativeQuery = true)
    Utilisateur getUserById(int id);
    @Query(value = "SELECT email from users where email =:email",nativeQuery = true)
    Utilisateur getUserByEmail(String email);
    @Query(value = "SELECT * from users where username = :username and password = :password",nativeQuery = true)
    List<Utilisateur> getUser(String username,String password);
}
