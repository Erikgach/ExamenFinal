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
import org.una.poblacion.entities.Unidad;
import org.una.poblacion.repositories.IUnidadRepository;

/**
 *
 * @author erikg
 */ 
@Service
public class UnidadServiceImplementation implements IUnidadService {
   

    @Autowired
    private IUnidadRepository unidadRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Unidad> findById(Long id) {
        return unidadRepository.findById(id);
    }

    @Override
    @Transactional
    public Unidad create(Unidad unidad) {
        return unidadRepository.save(unidad);
    }

    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Unidad>> findAll() {
        return Optional.ofNullable(unidadRepository.findAll());
    }

    @Override
    @Transactional
      public Optional<Unidad> update(Unidad unidad, Long id) {
    if (unidadRepository.findById(id).isPresent()) {
            return Optional.ofNullable(unidadRepository.save(unidad));
        } else {
            return null;
        }
    }
}

   




