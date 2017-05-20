package com.SpringBootAndMaterialize.SpringBootAndMaterialize.repository;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Entidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lucasbarros on 16/05/17.
 */

@Repository
public interface Entidades extends JpaRepository<Entidade, Long>{

    Page<Entidade> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

}
