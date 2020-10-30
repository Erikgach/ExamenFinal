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
import org.una.poblacion.dto.TipoUnidadDTO;
import org.una.poblacion.entities.TipoUnidad;
import org.una.poblacion.repositories.ITipoUnidadRepository;
import org.una.poblacion.utils.MapperUtils;
import org.una.poblacion.utils.ServiceConvertionHelper;

/**
 *
 * @author erikg
 */ 
@Service
public class TipoUnidadServiceImplementation implements ITipoUnidadService {
   

    @Autowired
    private ITipoUnidadRepository tipoUnidadRepository;
    
    
    
    @Override
    @Transactional
    public TipoUnidadDTO create(TipoUnidadDTO tipoUnidad) {
        TipoUnidad nombre = MapperUtils.EntityFromDto(tipoUnidad, TipoUnidad.class);
        nombre = tipoUnidadRepository.save(nombre);
        return MapperUtils.DtoFromEntity(nombre, TipoUnidadDTO.class);
    }

    @Override
    @Transactional
   public Optional<TipoUnidadDTO> update(TipoUnidadDTO tipoUnidadDTO, Long id) {
        if (tipoUnidadRepository.findById(id).isPresent()) {
            TipoUnidad tipoUnidad = MapperUtils.EntityFromDto(tipoUnidadDTO, TipoUnidad.class);
            tipoUnidad = tipoUnidadRepository.save(tipoUnidad);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tipoUnidad, TipoUnidadDTO.class));
        } else {
            return null;
        } 
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<TipoUnidadDTO>> findAll() {
        return ServiceConvertionHelper.findList(tipoUnidadRepository.findAll(), TipoUnidadDTO.class);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<TipoUnidadDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(tipoUnidadRepository.findById(id), TipoUnidadDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<TipoUnidadDTO>> findByNombre(String nombre) {
        return ServiceConvertionHelper.findList(tipoUnidadRepository.findByNombreContainingIgnoreCase(nombre), TipoUnidadDTO.class);
    }

    
    @Override
    public void delete(Long id) {
      tipoUnidadRepository.deleteById(id);}
   
}



