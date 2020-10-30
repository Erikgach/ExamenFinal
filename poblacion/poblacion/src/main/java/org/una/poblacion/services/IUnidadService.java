/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.services;

import java.util.List;
import java.util.Optional;
import org.una.poblacion.dto.UnidadDTO;


/**
 *
 * @author erikg
 */
public interface IUnidadService {
    public Optional<List<UnidadDTO>> findAll();
    public Optional<UnidadDTO> findById(Long id);
    public UnidadDTO create(UnidadDTO unidad);
    public Optional<UnidadDTO> update(UnidadDTO unidadDTO, Long id);
    public Optional<UnidadDTO> findByCodigo(int codigo);
    public Optional<List<UnidadDTO>> findByDistrito(Long provincia);
    public void delete(Long id);
}
