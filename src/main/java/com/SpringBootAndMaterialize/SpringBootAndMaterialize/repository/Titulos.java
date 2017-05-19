package com.SpringBootAndMaterialize.SpringBootAndMaterialize.repository;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lucasbarros on 17/05/17.
 */

@Repository
public interface Titulos extends JpaRepository<Titulo, Long> {

    List<Titulo> findByDescricaoContainingIgnoreCase(String descricao);

}
