/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.poblacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author erikg
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CantonDTO {
    private Long id; 
    private String nombre;
    private String codigo;
    private String extension;
    
}
