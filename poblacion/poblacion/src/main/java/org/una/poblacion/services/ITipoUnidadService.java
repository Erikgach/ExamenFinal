/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.services;

import java.util.List;
import java.util.Optional;
import org.una.poblacion.entities.TipoUnidad;

/**
 *
 * @author erikg
 */
public interface ITipoUnidadService {
     public Optional<List<TipoUnidad>> findAll();
    public Optional<TipoUnidad> findById(Long id);
    public TipoUnidad create(TipoUnidad tipoUnidad);
    public Optional<TipoUnidad> update(TipoUnidad tipoUnidad, Long id);
}
