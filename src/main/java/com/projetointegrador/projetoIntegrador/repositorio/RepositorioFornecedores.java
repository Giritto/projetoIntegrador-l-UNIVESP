package com.projetointegrador.projetoIntegrador.repositorio;

import com.projetointegrador.projetoIntegrador.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioFornecedores extends JpaRepository<Fornecedor, Long> {
}
