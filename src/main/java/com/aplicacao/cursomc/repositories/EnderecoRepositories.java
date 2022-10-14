package com.aplicacao.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplicacao.cursomc.domain.Endereco;

@Repository
public interface EnderecoRepositories extends JpaRepository<Endereco, Integer>{

}
