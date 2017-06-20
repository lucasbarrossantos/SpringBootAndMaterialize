package com.SpringBootAndMaterialize.SpringBootAndMaterialize.repository;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.dto.EntidadeDTO;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Entidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Entidades extends JpaRepository<Entidade, Long>{

    Page<Entidade> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    @Query("select new com.SpringBootAndMaterialize.SpringBootAndMaterialize.dto.EntidadeDTO(codigo, nome) " +
            "from Entidade where lower(nome) like %?1% or ?1 is null")
    List<EntidadeDTO> clientesFiltrados(String nome);
}
