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
import org.una.poblacion.entities.Provincia;
import org.una.poblacion.repositories.IProvinciaRepository;

/**
 *
 * @author erikg
 */ 
@Service
public class ProvinciaServiceImplementation implements IProvinciaService {
   

    @Autowired
    private IProvinciaRepository provinciaRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Provincia> findById(Long id) {
        return provinciaRepository.findById(id);
    }

    @Override
    @Transactional
    public Provincia create(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    @Override
    @Transactional
    public Optional<Provincia> update(Provincia provincia, Long id) {
    if (provinciaRepository.findById(id).isPresent()) {
            return Optional.ofNullable(provinciaRepository.save(provincia));
        } else {
            return null;
        }
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Provincia>> findAll() {
        return Optional.ofNullable(provinciaRepository.findAll());
    }

   
}


