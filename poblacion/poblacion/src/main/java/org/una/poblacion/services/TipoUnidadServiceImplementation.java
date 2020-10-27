/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.poblacion.entities.TipoUnidad;
import org.una.poblacion.repositories.ITipoUnidadRepository;

/**
 *
 * @author erikg
 */ 
@Service
public class TipoUnidadServiceImplementation implements ITipoUnidadService {
   

    @Autowired
    private ITipoUnidadRepository tipoUnidadRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<TipoUnidad> findById(Long id) {
        return tipoUnidadRepository.findById(id);
    }

    @Override
    @Transactional
    public TipoUnidad create(TipoUnidad tipoUnidad) {
        return tipoUnidadRepository.save(tipoUnidad);
    }

    @Override
    @Transactional
    public Optional<TipoUnidad> update(TipoUnidad tipoUnidad, Long id) {
    if (tipoUnidadRepository.findById(id).isPresent()) {
            return Optional.ofNullable(tipoUnidadRepository.save(tipoUnidad));
        } else {
            return null;
        }
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<TipoUnidad>> findAll() {
        return Optional.ofNullable(tipoUnidadRepository.findAll());
    }

   
}



