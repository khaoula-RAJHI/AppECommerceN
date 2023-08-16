package com.stage.eCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.stage.eCommerce.entities.CategorieProduit;

import java.util.List;

@Repository
public interface CategorieProduitRepository extends JpaRepository<CategorieProduit, Long>{


}
