/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.services;

import java.util.List;
import java.util.Optional;
import org.una.poblacion.entities.Unidad;

/**
 *
 * @author erikg
 */
public interface IUnidadService {
    public Optional<List<Unidad>> findAll();
    public Optional<Unidad> findById(Long id);
    public Unidad create(Unidad tipoUnidad);
    public Optional<Unidad> update(Unidad unidad, Long id);
}
