package br.unialfa.compra_venda.service;

import br.unialfa.compra_venda.model.Compra;
import br.unialfa.compra_venda.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    public void salvar(Compra compra) {

        compra.getItens().forEach(itemCompra -> itemCompra.setCompra(compra));

        repository.save(compra);
    }

    public List<Compra> listarTodos() {
        return repository.findAll();
    }

    public Compra buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

}
