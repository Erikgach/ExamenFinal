/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author erikg
 */

public class Unidad {
     @ManyToOne
    @JoinColumn(name = "distrito_id")
    private Distrito distrito; 
     
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
      @ManyToOne
    @JoinColumn(name = "tipoUnidad_id")
    private TipoUnidad tipoUnidad; 
     
    
    @Column(length = 45, name = "nombre")
    private String nombre;
   
      
}
