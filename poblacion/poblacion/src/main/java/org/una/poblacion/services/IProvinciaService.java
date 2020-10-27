/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.services;

import java.util.List;
import java.util.Optional;
import org.una.poblacion.entities.Provincia;

/**
 *
 * @author erikg
 */
public interface IProvinciaService {
    public Optional<List<Provincia>> findAll();
    public Optional<Provincia> findById(Long id);
    public Provincia create(Provincia provincia);
    public Optional<Provincia> update(Provincia provincia, Long id);
}
