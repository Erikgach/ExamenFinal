/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.poblacion.dto.TipoUnidadDTO;
import org.una.poblacion.entities.TipoUnidad;
import org.una.poblacion.services.ITipoUnidadService;
import org.una.poblacion.utils.MapperUtils;

/**
 *
 * @author erikg
 */

@RestController
@RequestMapping("/tipoUnidades") 
@Api(tags = {"TipoUnidades"})
public class TipoUnidadController {
    @Autowired
    private ITipoUnidadService tipoUnidadService;
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un tipoUnidad a partir del id ingresado", response = TipoUnidadDTO.class, responseContainer = "List", tags = "TipoUnidades")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<TipoUnidad> tipoUnidadFound = tipoUnidadService.findById(id);
            if (tipoUnidadFound.isPresent()) {
                TipoUnidadDTO tipoUnidadDto = MapperUtils.DtoFromEntity(tipoUnidadFound.get(), TipoUnidadDTO.class);
                return new ResponseEntity<>(tipoUnidadDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Crea un nuevo cantón con la información suministrada", response = TipoUnidadDTO.class, tags = "TipoUnidades") 
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TipoUnidad tipoUnidad) {
        try {
            TipoUnidad tipoUnidadCreated = tipoUnidadService.create(tipoUnidad);
            TipoUnidadDTO tipoUnidadDto = MapperUtils.DtoFromEntity(tipoUnidadCreated, TipoUnidadDTO.class);
            return new ResponseEntity<>(tipoUnidadDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
                 
    @ApiOperation(value = "Actualiza una cantón", response = TipoUnidadDTO.class,  tags = "TipoUnidades") 
    @PutMapping("/{id}") 
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody TipoUnidad tipoUnidadModified) {
        try {
            Optional<TipoUnidad> tipoUnidadUpdated = tipoUnidadService.update(tipoUnidadModified, id);
            if (tipoUnidadUpdated.isPresent()) {
                TipoUnidadDTO tipoUnidadDto = MapperUtils.DtoFromEntity(tipoUnidadUpdated.get(), TipoUnidadDTO.class);
                return new ResponseEntity<>(tipoUnidadDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
}