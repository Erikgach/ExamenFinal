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
import org.una.poblacion.dto.ProvinciaDTO;
import org.una.poblacion.entities.Provincia;
import org.una.poblacion.repositories.IProvinciaRepository;
import org.una.poblacion.utils.MapperUtils;
import org.una.poblacion.utils.ServiceConvertionHelper;

/**
 *
 * @author erikg
 */ 
@Service
public class ProvinciaServiceImplementation implements IProvinciaService {
   

    @Autowired
    private IProvinciaRepository provinciaRepository;
    
  
    @Override
    @Transactional
    public ProvinciaDTO create(ProvinciaDTO provincia) {
        Provincia nombre = MapperUtils.EntityFromDto(provincia, Provincia.class);
        nombre = provinciaRepository.save(nombre);
        return MapperUtils.DtoFromEntity(nombre, ProvinciaDTO.class);
    }

    @Override
    @Transactional
     public Optional<ProvinciaDTO> update(ProvinciaDTO provinciaDTO, Long id) {
        if (provinciaRepository.findById(id).isPresent()) {
            Provincia provincia = MapperUtils.EntityFromDto(provinciaDTO, Provincia.class);
            provincia = provinciaRepository.save(provincia);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(provincia, ProvinciaDTO.class));
        } else {
            return null;
        } 
    }
     
    @Override
    @Transactional(readOnly = true)
    public Optional<ProvinciaDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(provinciaRepository.findById(id), ProvinciaDTO.class);
    }
   
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProvinciaDTO>> findAll() {
        return ServiceConvertionHelper.findList(provinciaRepository.findAll(), ProvinciaDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<ProvinciaDTO> findByCodigo(int codigo) {
        return ServiceConvertionHelper.oneToOptionalDto(provinciaRepository.findByCodigo(codigo), ProvinciaDTO.class);
    }
     
    @Override
    @Transactional
    public void delete(Long id) {
        provinciaRepository.deleteById(id);
    } 
    
    

   
}


