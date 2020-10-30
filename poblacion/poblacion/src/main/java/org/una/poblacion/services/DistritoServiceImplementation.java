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
import org.una.poblacion.dto.DistritoDTO;
import org.una.poblacion.entities.Distrito;
import org.una.poblacion.repositories.IDistritoRepository;
import org.una.poblacion.utils.MapperUtils;
import org.una.poblacion.utils.ServiceConvertionHelper;


/**
 *
 * @author erikg
 */

@Service
public class DistritoServiceImplementation implements IDistritoService{
    @Autowired
    private IDistritoRepository distritoRepository;
    
   @Override
    @Transactional
    public DistritoDTO create(DistritoDTO distrito) {
       Distrito nombre = MapperUtils.EntityFromDto(distrito, Distrito.class);
        nombre = distritoRepository.save(nombre);
        return MapperUtils.DtoFromEntity(nombre, DistritoDTO.class);
    }

     @Override
    @Transactional
    public Optional<DistritoDTO> update(DistritoDTO distritoDTO, Long id) {
        if (distritoRepository.findById(id).isPresent()) {
            Distrito distrito = MapperUtils.EntityFromDto(distritoDTO, Distrito.class);
            distrito = distritoRepository.save(distrito);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(distrito, DistritoDTO.class));
        } else {
            return null;
        } 
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<List<DistritoDTO>> findAll() {
    return ServiceConvertionHelper.findList(distritoRepository.findAll(), DistritoDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<DistritoDTO> findById(Long id) {
         return ServiceConvertionHelper.oneToOptionalDto(distritoRepository.findById(id), DistritoDTO.class);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<DistritoDTO> findByCodigo(int codigo) {
        return ServiceConvertionHelper.oneToOptionalDto(distritoRepository.findByCodigo(codigo), DistritoDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<DistritoDTO>> findByCanton(Long canton) {
        return ServiceConvertionHelper.findList(distritoRepository.findByCanton(canton), DistritoDTO.class);
    }

    @Override
    public void delete(Long id) {
         distritoRepository.deleteById(id);  }
    

   
}
