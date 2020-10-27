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
import org.una.poblacion.entities.Distrito;
import org.una.poblacion.repositories.IDistritoRepository;


/**
 *
 * @author erikg
 */

@Service
public class DistritoServiceImplementation implements IDistritoService{
    @Autowired
    private IDistritoRepository distritoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Distrito> findById(Long id) {
        return distritoRepository.findById(id);
    }

    @Override
    @Transactional
    public Distrito create(Distrito distrito) {
        return distritoRepository.save(distrito);
    }

    @Override
    @Transactional
    public Optional<Distrito> update(Distrito distrito, Long id) {
    if (distritoRepository.findById(id).isPresent()) {
            return Optional.ofNullable(distritoRepository.save(distrito));
        } else {
            return null;
        }
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Distrito>> findAll() {
        return Optional.ofNullable(distritoRepository.findAll());
    }

   
}
