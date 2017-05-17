package com.SpringBootAndMaterialize.SpringBootAndMaterialize.service;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Titulo;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lucasbarros on 17/05/17.
 */

@Service
public class TitulosService {

    private final Titulos titulos;

    @Autowired
    public TitulosService(Titulos titulos) {
        this.titulos = titulos;
    }

    public void salvar(Titulo titulo){
        titulos.save(titulo);
    }
}
