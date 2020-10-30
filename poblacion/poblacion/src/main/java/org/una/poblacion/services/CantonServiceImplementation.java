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
import org.una.poblacion.dto.CantonDTO;
import org.una.poblacion.entities.Canton;
import org.una.poblacion.repositories.ICantonRepository;
import org.una.poblacion.utils.MapperUtils;
import org.una.poblacion.utils.ServiceConvertionHelper;


/**
 *
 * @author erikg
 */

@Service
public class CantonServiceImplementation implements ICantonService{
    @Autowired
    private ICantonRepository cantonRepository;
 
    @Override
    @Transactional
    public CantonDTO create(CantonDTO cantonDTO) {
        Canton canton = MapperUtils.EntityFromDto(cantonDTO, Canton.class);
        canton = cantonRepository.save(canton);
        return MapperUtils.DtoFromEntity(canton, CantonDTO.class);
    }

    @Override
    @Transactional
    public Optional<CantonDTO> update(CantonDTO cantonDTO, Long id) {
        if (cantonRepository.findById(id).isPresent()) {
            Canton canton = MapperUtils.EntityFromDto(cantonDTO, Canton.class);
            canton = cantonRepository.save(canton);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(canton, CantonDTO.class));
        } else {
            return null;
        } 
    }
   
    @Override
    @Transactional(readOnly = true)
    public Optional<List<CantonDTO>> findAll() {
        return ServiceConvertionHelper.findList(cantonRepository.findAll(), CantonDTO.class);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        cantonRepository.deleteById(id);
    } 
    
    @Override
    @Transactional(readOnly = true)
    public Optional<CantonDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(cantonRepository.findById(id), CantonDTO.class);
    }
     @Override
    @Transactional(readOnly = true)
    public Optional<CantonDTO> findByCodigo(int codigo) {
        return ServiceConvertionHelper.oneToOptionalDto(cantonRepository.findByCodigo(codigo), CantonDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<CantonDTO>> findByProvincia(Long provincia) {
        return ServiceConvertionHelper.findList(cantonRepository.findByProvincia(provincia), CantonDTO.class);
    }
}
