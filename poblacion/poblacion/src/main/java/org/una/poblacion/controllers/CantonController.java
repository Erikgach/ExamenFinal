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
import org.una.poblacion.dto.CantonDTO;
import org.una.poblacion.entities.Canton;
import org.una.poblacion.services.ICantonService;
import org.una.poblacion.utils.MapperUtils;

/**
 *
 * @author erikg
 */

@RestController
@RequestMapping("/cantones") 
@Api(tags = {"Cantones"})
public class CantonController {
    @Autowired
    private ICantonService cantonService;
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un canton a partir del id ingresado", response = CantonDTO.class, responseContainer = "List", tags = "Cantones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Canton> cantonFound = cantonService.findById(id);
            if (cantonFound.isPresent()) {
                CantonDTO cantonDto = MapperUtils.DtoFromEntity(cantonFound.get(), CantonDTO.class);
                return new ResponseEntity<>(cantonDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Crea un nuevo cantón con la información suministrada", response = CantonDTO.class, tags = "Cantones") 
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Canton canton) {
        try {
            Canton cantonCreated = cantonService.create(canton);
            CantonDTO cantonDto = MapperUtils.DtoFromEntity(cantonCreated, CantonDTO.class);
            return new ResponseEntity<>(cantonDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
                 
    @ApiOperation(value = "Actualiza un cantón", response = CantonDTO.class,  tags = "Cantones") 
    @PutMapping("/{id}") 
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Canton cantonModified) {
        try {
            Optional<Canton> cantonUpdated = cantonService.update(cantonModified, id);
            if (cantonUpdated.isPresent()) {
                CantonDTO cantonDto = MapperUtils.DtoFromEntity(cantonUpdated.get(), CantonDTO.class);
                return new ResponseEntity<>(cantonDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
}