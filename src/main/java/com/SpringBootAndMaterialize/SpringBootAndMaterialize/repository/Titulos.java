package com.SpringBootAndMaterialize.SpringBootAndMaterialize.repository;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Titulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lucasbarros on 17/05/17.
 */

@Repository
public interface Titulos extends JpaRepository<Titulo, Long> {

    Page<Titulo> findByDescricaoContainingIgnoreCase(String descricao, Pageable pageable);

}
