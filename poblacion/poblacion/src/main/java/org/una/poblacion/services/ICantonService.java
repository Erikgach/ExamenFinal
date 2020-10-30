/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.services;

import java.util.List;
import java.util.Optional;
import org.una.poblacion.dto.CantonDTO;

/**
 *
 * @author erikg
 */
public interface ICantonService {
    public Optional<List<CantonDTO>> findAll();
    public Optional<CantonDTO> findById(Long id);
    public CantonDTO create(CantonDTO canton);
    public Optional<CantonDTO> update(CantonDTO cantonDTO, Long id);
    public Optional<CantonDTO> findByCodigo(int codigo);
    public Optional<List<CantonDTO>> findByProvincia(Long provincia);
    public void delete(Long id);
}
