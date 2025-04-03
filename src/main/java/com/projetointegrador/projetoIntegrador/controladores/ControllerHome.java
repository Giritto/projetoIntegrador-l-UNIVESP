package com.projetointegrador.projetoIntegrador.controladores;
import com.projetointegrador.projetoIntegrador.model.Fornecedor;
import com.projetointegrador.projetoIntegrador.servico.ServicoFornecedores;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControllerHome {

    private final ServicoFornecedores fornecService;

    public ControllerHome(ServicoFornecedores fornecService) {
        this.fornecService = fornecService;
    }

    @GetMapping("/")
    public String home(@RequestParam(value = "nome", defaultValue = "") String nome, Model model) {
        List<Fornecedor> listaFornec = fornecService.getAllFornec();
        model.addAttribute("listaFornec", listaFornec);

    return "home";
    }
}
