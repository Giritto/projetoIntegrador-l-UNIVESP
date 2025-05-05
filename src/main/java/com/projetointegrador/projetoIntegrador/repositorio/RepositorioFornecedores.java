package com.projetointegrador.projetoIntegrador.repositorio;

import com.projetointegrador.projetoIntegrador.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioFornecedores extends JpaRepository<Fornecedor, Long> {
    // These methods should be INSIDE the interface
    List<Fornecedor> findByNomeContainingIgnoreCase(String nome);
    List<Fornecedor> findByMaterialContainingIgnoreCase(String material);
}