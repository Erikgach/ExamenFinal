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
import org.una.poblacion.entities.Canton;
import org.una.poblacion.repositories.ICantonRepository;


/**
 *
 * @author erikg
 */

@Service
public class CantonServiceImplementation implements ICantonService{
    @Autowired
    private ICantonRepository cantonRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Canton> findById(Long id) {
        return cantonRepository.findById(id);
    }

    @Override
    @Transactional
    public Canton create(Canton canton) {
        return cantonRepository.save(canton);
    }

    @Override
    @Transactional
    public Optional<Canton> update(Canton canton, Long id) {
    if (cantonRepository.findById(id).isPresent()) {
            return Optional.ofNullable(cantonRepository.save(canton));
        } else {
            return null;
        }
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Canton>> findAll() {
        return Optional.ofNullable(cantonRepository.findAll());
    }

   
}
