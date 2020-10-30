/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.poblacion.entities.Canton;

/**
 *
 * @author erikg
 */
public interface ICantonRepository extends JpaRepository<Canton, Long>{

    public Optional<Canton> findByCodigo(int codigo);
    @Query("SELECT a FROM Canton a LEFT JOIN a.provincia e WHERE e.id = :provinciaID")
    public List<Canton> findByProvincia(@Param("provinciaID") Long provincia);
}
