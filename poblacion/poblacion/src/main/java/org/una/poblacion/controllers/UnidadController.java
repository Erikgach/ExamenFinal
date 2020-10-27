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
import org.una.poblacion.dto.UnidadDTO;
import org.una.poblacion.entities.Unidad;
import org.una.poblacion.services.IUnidadService;
import org.una.poblacion.utils.MapperUtils;

/**
 *
 * @author erikg
 */

@RestController
@RequestMapping("/unidades") 
@Api(tags = {"Unidades"})
public class UnidadController {
    @Autowired
    private IUnidadService unidadService;
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una unidad a partir del id ingresado", response = UnidadDTO.class, responseContainer = "List", tags = "Unidades")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Unidad> unidadFound = unidadService.findById(id);
            if (unidadFound.isPresent()) {
                UnidadDTO unidadDto = MapperUtils.DtoFromEntity(unidadFound.get(), UnidadDTO.class);
                return new ResponseEntity<>(unidadDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Crea una unidad con la información suministrada", response = UnidadDTO.class, tags = "Unidades") 
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Unidad unidad) {
        try {
            Unidad unidadCreated = unidadService.create(unidad);
            UnidadDTO unidadDto = MapperUtils.DtoFromEntity(unidadCreated, UnidadDTO.class);
            return new ResponseEntity<>(unidadDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
                 
    @ApiOperation(value = "Actualiza una unidad", response = UnidadDTO.class,  tags = "Unidades") 
    @PutMapping("/{id}") 
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Unidad unidadModified) {
        try {
            Optional<Unidad> unidadUpdated = unidadService.update(unidadModified, id);
            if (unidadUpdated.isPresent()) {
                UnidadDTO unidadDto = MapperUtils.DtoFromEntity(unidadUpdated.get(), UnidadDTO.class);
                return new ResponseEntity<>(unidadDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
}