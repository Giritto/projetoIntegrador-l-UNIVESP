package com.projetointegrador.projetoIntegrador.controladores;

import com.projetointegrador.projetoIntegrador.model.Fornecedor;
import com.projetointegrador.projetoIntegrador.servico.ServicoFornecedores;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("fornecedor", new Fornecedor());
        return "create";
    }

    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute("fornecedor") Fornecedor fornecedor,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "create";
        }

        // Limpa e normaliza o valor monetário (de BRL com vírgula pra ponto)
        String raw = fornecedor.getValor();
        if (raw != null) {
            String clean = raw.replace(".", "").replace(",", ".");
            fornecedor.setValor(clean);
        }

        // Limpa o telefone (mantém só os números)
        String tel = fornecedor.getTelefone();
        if (tel != null) {
            fornecedor.setTelefone(tel.replaceAll("\\D", ""));
        }

        fornecService.save(fornecedor);
        redirectAttributes.addFlashAttribute("message", "Adicionado com sucesso");

        return "redirect:/";
    }

    @GetMapping("fornecedor/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Fornecedor fornecedor = fornecService.findById(id).orElse(null);
        model.addAttribute("fornecedor", fornecedor);
        return "create";
    }


    @GetMapping("fornecedor/{id}/remove")
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes) {
        fornecService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Deletado com sucesso");
        return "redirect:/";
    }

    @GetMapping("fornecedor/{id}")
    public String show(@PathVariable long id, Model model) {
        fornecService.findById(id)
                .ifPresent(fornecedor -> model.addAttribute("fornecedor", fornecedor));
        return "show";
    }

}

