/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.services;

import java.util.List;
import java.util.Optional;
import org.una.poblacion.dto.DistritoDTO;
import org.una.poblacion.entities.Distrito;

/**
 *
 * @author erikg
 */
public interface IDistritoService {
    public Optional<List<DistritoDTO>> findAll();
    public Optional<DistritoDTO> findById(Long id);
    public DistritoDTO create(DistritoDTO distrito);
    public Optional<DistritoDTO> update(DistritoDTO distritoDTO, Long id);
    public Optional<DistritoDTO> findByCodigo(int codigo);
    public Optional<List<DistritoDTO>> findByCanton(Long canton);
    public void delete(Long id);
}
