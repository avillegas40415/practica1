package com.practica1.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="arbol")
public class Arbol implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_arbol")
    private Long id_arbol;
    private String nombre;
    private String tipo_flor;
    private String dureza_madera;
    private String altura_maxima;
    private String ruta_imagen;
    private boolean activo;

    public Arbol(){
        
    }
    
    public Arbol(String nombre, String tipo, String dureza, String altura, boolean activo){
        this.nombre = nombre;
        this.tipo_flor = tipo;
        this.dureza_madera = dureza;
        this.altura_maxima = altura;
        this.activo = activo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Long getIdArbol(){
        return id_arbol;
    }
    
    public boolean isActivo() {
        return activo;
    }

    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
