package com.SpringBootAndMaterialize.SpringBootAndMaterialize.service;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.exception.NegocioException;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Entidade;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.repository.Entidades;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.List;

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

    public List<Entidade> filtrar(Entidade entidade) {
        String nome = entidade.getNome() == null ? "%" : entidade.getNome();
        return entidades.findByNomeContainingIgnoreCase(nome);
    }

    public void excluir(Long codigo) {
        try {
            entidades.delete(codigo);
        }catch (DataIntegrityViolationException e){
            throw new NegocioException("Entidade não pode ser removida, pois contém títulos vinculados!");
        }
    }
}
