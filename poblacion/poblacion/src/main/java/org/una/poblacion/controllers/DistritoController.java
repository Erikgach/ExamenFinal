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
import org.una.poblacion.dto.DistritoDTO;
import org.una.poblacion.entities.Distrito;
import org.una.poblacion.services.IDistritoService;
import org.una.poblacion.utils.MapperUtils;

/**
 *
 * @author erikg
 */

@RestController
@RequestMapping("/distritos") 
@Api(tags = {"Distritos"})
public class DistritoController {
    @Autowired
    private IDistritoService distritoService;
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un distrito a partir del id ingresado", response = DistritoDTO.class, responseContainer = "List", tags = "Distritos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Distrito> distritoFound = distritoService.findById(id);
            if (distritoFound.isPresent()) {
                DistritoDTO distritoDto = MapperUtils.DtoFromEntity(distritoFound.get(), DistritoDTO.class);
                return new ResponseEntity<>(distritoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Crea un nuevo cantón con la información suministrada", response = DistritoDTO.class, tags = "Distritos") 
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Distrito distrito) {
        try {
            Distrito distritoCreated = distritoService.create(distrito);
            DistritoDTO distritoDto = MapperUtils.DtoFromEntity(distritoCreated, DistritoDTO.class);
            return new ResponseEntity<>(distritoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
                 
    @ApiOperation(value = "Actualiza una cantón", response = DistritoDTO.class,  tags = "Distritos") 
    @PutMapping("/{id}") 
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Distrito distritoModified) {
        try {
            Optional<Distrito> distritoUpdated = distritoService.update(distritoModified, id);
            if (distritoUpdated.isPresent()) {
                DistritoDTO distritoDto = MapperUtils.DtoFromEntity(distritoUpdated.get(), DistritoDTO.class);
                return new ResponseEntity<>(distritoDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
}