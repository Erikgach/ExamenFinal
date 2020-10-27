/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.services;

import java.util.List;
import java.util.Optional;
import org.una.poblacion.entities.Distrito;

/**
 *
 * @author erikg
 */
public interface IDistritoService {
    public Optional<List<Distrito>> findAll();
    public Optional<Distrito> findById(Long id);
    public Distrito create(Distrito distrito);
    public Optional<Distrito> update(Distrito distrito, Long id);
}
