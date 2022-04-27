package com.example.demo.model.repository;

import com.example.demo.model.Produit;
import com.example.demo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {

    @Transactional
    @Modifying
    @Query("update Produit p set p.qteStock = p.qteStock + :qte where p.id = :id")
    void UpdateQteProduit(@Param("id") int id, @Param("qte") int qte);
    @Query(value = "select * from produits p where p.qte_stock > p.qte_seuil",nativeQuery = true)
    List<Produit> showUnderSeuil();
    @Query(value = "SELECT * from Produits where libelle like %:keyword%",nativeQuery = true)
    List<Produit> findByKeyword(@Param("keyword") String keyword);

}
