package br.unialfa.compra_venda.service;

import br.unialfa.compra_venda.model.Venda;
import br.unialfa.compra_venda.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public void salvar(Venda venda) {

        venda.getItens().forEach(itemVenda -> itemVenda.setVenda(venda));

        repository.save(venda);
    }

    public List<Venda> listarTodos() {
        return repository.findAll();
    }

    public Venda buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

}
