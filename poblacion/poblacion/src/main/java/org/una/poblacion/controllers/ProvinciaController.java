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
import org.una.poblacion.dto.ProvinciaDTO;
import org.una.poblacion.entities.Provincia;
import org.una.poblacion.services.IProvinciaService;
import org.una.poblacion.utils.MapperUtils;

/**
 *
 * @author erikg
 */

@RestController
@RequestMapping("/provincias") 
@Api(tags = {"Provincias"})
public class ProvinciaController {
    @Autowired
    private IProvinciaService provinciaService;
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una provincia a partir del id ingresado", response = ProvinciaDTO.class, responseContainer = "List", tags = "Provincias")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Provincia> provinciaFound = provinciaService.findById(id);
            if (provinciaFound.isPresent()) {
                ProvinciaDTO provinciaDto = MapperUtils.DtoFromEntity(provinciaFound.get(), ProvinciaDTO.class);
                return new ResponseEntity<>(provinciaDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Crea una nueva provincia con la información suministrada", response = ProvinciaDTO.class, tags = "Provincias") 
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Provincia provincia) {
        try {
            Provincia provinciaCreated = provinciaService.create(provincia);
            ProvinciaDTO provinciaDto = MapperUtils.DtoFromEntity(provinciaCreated, ProvinciaDTO.class);
            return new ResponseEntity<>(provinciaDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
                 
    @ApiOperation(value = "Actualiza una provincia", response = ProvinciaDTO.class,  tags = "Provincias") 
    @PutMapping("/{id}") 
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Provincia provinciaModified) {
        try {
            Optional<Provincia> provinciaUpdated = provinciaService.update(provinciaModified, id);
            if (provinciaUpdated.isPresent()) {
                ProvinciaDTO provinciaDto = MapperUtils.DtoFromEntity(provinciaUpdated.get(), ProvinciaDTO.class);
                return new ResponseEntity<>(provinciaDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
}