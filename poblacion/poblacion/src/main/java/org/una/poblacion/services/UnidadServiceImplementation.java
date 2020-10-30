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
import org.una.poblacion.dto.UnidadDTO;
import org.una.poblacion.entities.Unidad;
import org.una.poblacion.repositories.IUnidadRepository;
import org.una.poblacion.utils.MapperUtils;
import org.una.poblacion.utils.ServiceConvertionHelper;

/**
 *
 * @author erikg
 */ 
@Service
public class UnidadServiceImplementation implements IUnidadService {
   

    @Autowired
    private IUnidadRepository unidadRepository;
    
  

    @Override
    @Transactional
    public UnidadDTO create(UnidadDTO unidad) {
       Unidad nombre = MapperUtils.EntityFromDto(unidad, Unidad.class);
        nombre = unidadRepository.save(nombre);
        return MapperUtils.DtoFromEntity(nombre, UnidadDTO.class);
    }

    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<UnidadDTO>> findAll() {
       return ServiceConvertionHelper.findList(unidadRepository.findAll(), UnidadDTO.class);
    }

    @Override
    @Transactional
    public Optional<UnidadDTO> update(UnidadDTO unidadDTO, Long id) {
        if (unidadRepository.findById(id).isPresent()) {
            Unidad unidad = MapperUtils.EntityFromDto(unidadDTO, Unidad.class);
            unidad = unidadRepository.save(unidad);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(unidad, UnidadDTO.class));
        } else {
            return null;
        } 
    }
     @Override
    @Transactional(readOnly = true)
    public Optional<UnidadDTO> findById(Long id) {
         return ServiceConvertionHelper.oneToOptionalDto(unidadRepository.findById(id), UnidadDTO.class);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<UnidadDTO> findByCodigo(int codigo) {
        return ServiceConvertionHelper.oneToOptionalDto(unidadRepository.findByCodigo(codigo), UnidadDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<UnidadDTO>> findByDistrito(Long canton) {
        return ServiceConvertionHelper.findList(unidadRepository.findByDistrito(canton), UnidadDTO.class);
    }

    @Override
    public void delete(Long id) {
         unidadRepository.deleteById(id);  }
}

   




