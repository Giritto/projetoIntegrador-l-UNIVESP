package com.projetointegrador.projetoIntegrador.servico;

import com.projetointegrador.projetoIntegrador.model.Fornecedor;
import com.projetointegrador.projetoIntegrador.repositorio.RepositorioFornecedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoFornecedores {

    private final RepositorioFornecedores repoFornec;

    // Construtor para injeção de dependência do repositório
    @Autowired
    public ServicoFornecedores(RepositorioFornecedores repoFornec) {
        this.repoFornec = repoFornec;
    }

    // Método para recuperar todos os fornecedores do banco de dados
    public List<Fornecedor> getAllFornec() {
        return (List<Fornecedor>) repoFornec.findAll();
    }

    // Método para buscar um fornecedor pelo ID
    public Optional<Fornecedor> findById(Long id) {
        return repoFornec.findById(id);
    }

    // Método para salvar um fornecedor no banco de dados
    public Fornecedor save(Fornecedor fornecedor) {
        return repoFornec.save(fornecedor);
    }

    // Método para deletar um fornecedor do banco de dados
    public void deleteById(Long id) {
        repoFornec.deleteById(id);
    }
}
