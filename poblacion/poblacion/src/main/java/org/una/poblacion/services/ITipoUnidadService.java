/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.services;

import java.util.List;
import java.util.Optional;
import org.una.poblacion.dto.TipoUnidadDTO;
import org.una.poblacion.entities.TipoUnidad;

/**
 *
 * @author erikg
 */
public interface ITipoUnidadService {
    public Optional<List<TipoUnidadDTO>> findAll();
    public Optional<TipoUnidadDTO> findById(Long id);
    public TipoUnidadDTO create(TipoUnidadDTO tipoUnidad);
    public Optional<TipoUnidadDTO> update(TipoUnidadDTO tipounidadDTO, Long id);
    public Optional<List<TipoUnidadDTO>> findByNombre(String nombre);
    public void delete(Long id);
}
