package com.practica1.service.impl;

import com.practica1.dao.ArbolDao;
import com.practica1.domain.Arbol;
import com.practica1.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImp implements ArbolService{
    
    @Autowired
    private ArbolDao arbolDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Arbol> getArboles(boolean activos){
        var lista=arbolDao.findAll();
        if(!activos){
            lista.removeIf((Arbol e) -> !e.isActivo());
        }
        return lista;
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public Arbol getArbol(Arbol arbol){
        return arbolDao.findById(arbol.getIdArbol()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Arbol arbol) {
        arbolDao.save(arbol);
    }
    
    @Override
    @Transactional
    public void delete(Arbol arbol) {
        arbolDao.delete(arbol);
    }
}
