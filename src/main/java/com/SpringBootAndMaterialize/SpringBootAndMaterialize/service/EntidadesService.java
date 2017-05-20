package com.SpringBootAndMaterialize.SpringBootAndMaterialize.service;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.exception.NegocioException;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Entidade;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.repository.Entidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by lucasbarros on 16/05/17.
 */

@Service
public class EntidadesService {

    @Autowired
    private Entidades entidades;

    public void salvar(Entidade entidade){
        entidades.save(entidade);
    }

    public Page<Entidade> filtrar(Entidade entidade, Pageable pageable) {
        String nome = entidade.getNome() == null ? "%" : entidade.getNome();
        return entidades.findByNomeContainingIgnoreCase(nome, pageable);
    }

    public void excluir(Long codigo) {
        try {
            entidades.delete(codigo);
        }catch (DataIntegrityViolationException e){
            throw new NegocioException("Entidade não pode ser removida, pois contém títulos vinculados!");
        }
    }
}
