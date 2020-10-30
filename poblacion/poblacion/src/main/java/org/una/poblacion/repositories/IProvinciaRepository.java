/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.repositories;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.poblacion.entities.Provincia;

/**
 *
 * @author erikg
 */
public interface IProvinciaRepository extends JpaRepository<Provincia, Long> {
    
    public Optional<Provincia> findByCodigo(int codigo);
    
}
