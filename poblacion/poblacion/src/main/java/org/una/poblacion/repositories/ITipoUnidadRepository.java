/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.poblacion.entities.TipoUnidad;

/**
 *
 * @author erikg
 */
public interface ITipoUnidadRepository extends JpaRepository<TipoUnidad, Long> {
    
}
