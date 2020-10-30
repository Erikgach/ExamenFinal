/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author erikg
 */
@Entity
@Table(name = "exa_eri_TipoUnidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TipoUnidad implements Serializable {
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUnidad") 
    private List<Unidad> unidades= new ArrayList<>();
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name = "codigo", length = 10)
    private String codigo;

    @Column(length = 45, name = "nombre")
    private String nombre;
    
    @Column(length = 100, name = "extension")
    private String extension;

}
