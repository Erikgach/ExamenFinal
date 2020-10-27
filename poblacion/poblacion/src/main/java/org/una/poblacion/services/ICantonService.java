/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.services;

import java.util.List;
import java.util.Optional;
import org.una.poblacion.entities.Canton;

/**
 *
 * @author erikg
 */
public interface ICantonService {
    public Optional<List<Canton>> findAll();
    public Optional<Canton> findById(Long id);
    public Canton create(Canton canton);
    public Optional<Canton> update(Canton canton, Long id);
}
