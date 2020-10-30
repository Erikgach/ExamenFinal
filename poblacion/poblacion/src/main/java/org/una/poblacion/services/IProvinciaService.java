/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.services;

import java.util.List;
import java.util.Optional;
import org.una.poblacion.dto.ProvinciaDTO;
import org.una.poblacion.entities.Provincia;

/**
 *
 * @author erikg
 */
public interface IProvinciaService {
    public Optional<List<ProvinciaDTO>> findAll();
    public Optional<ProvinciaDTO> findById(Long id);
    public ProvinciaDTO create(ProvinciaDTO provincia);
    public Optional<ProvinciaDTO> update(ProvinciaDTO provinciaDTO, Long id);
    public Optional<ProvinciaDTO> findByCodigo(int codigo);
    public void delete(Long id);
}
