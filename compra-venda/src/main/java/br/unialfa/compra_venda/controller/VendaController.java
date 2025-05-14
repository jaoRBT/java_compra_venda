package br.unialfa.compra_venda.controller;

import br.unialfa.compra_venda.model.Venda;
import br.unialfa.compra_venda.model.ItemVenda;
import br.unialfa.compra_venda.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("venda")
public class VendaController {

    @Autowired
    private VendaService service;

    @GetMapping()
    public String iniciar(Venda venda, Model model) {
        return "venda/formulario";
    }

    @PostMapping()
    public String inserir(Venda venda, Model model, ItemVenda itemVenda) {
        if (venda.getItens() == null) venda.setItens(Arrays.asList(itemVenda));
        else venda.getItens().add(itemVenda);
        return iniciar(venda, model);
    }

    @PostMapping("salvar")
    public String salvar(Venda venda, Model model) {
        service.salvar(venda);
        return "redirect:/venda/listar";
    }

    @GetMapping("listar")
    public String listar(Model model) {
        model.addAttribute("vendas", service.listarTodos());
        return "venda/lista";
    }

    @GetMapping("editar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("venda", service.buscarPorId(id));
        return "venda/formulario";
    }

    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id, Model model) {
        service.deletarPorId(id);
        return "redirect:/venda/listar";
    }
}