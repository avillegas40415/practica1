/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica1.controller;

import com.practica1.domain.Arbol;
import com.practica1.service.ArbolService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/categoria")
public class ArbolController {
    @Autowired
    private ArbolService arbolService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var categorias = arbolService.getArboles(false);
        model.addAttribute("categoria", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "/categoria/listado"; //Cambiado para hacer pruebas
    }
    
    @GetMapping("/nuevo")
    public String categoriaNuevo(Arbol arbol) {
        return "/categoria/modifica";
    }

    //@Autowired
    //private FirebaseStorageServiceImp firebaseStorageService;
    
    /*@PostMapping("/guardar")
    public String categoriaGuardar(Arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            arbol.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "categoria", 
                            categoria.getIdCategoria()));
        }
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }*/

    @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idArbol}")
    //public String categoriaModificar(Arbol arbol, Model model) {
    public String categoriaModificar(@PathVariable Long idArbol, Model model) {
        Arbol arbol = arbolService.getArbol(idArbol);
        model.addAttribute("categoria", arbol);
        return "/categoria/modifica";
    }
}
