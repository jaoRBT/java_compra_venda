package br.unialfa.compra_venda.repository;

import br.unialfa.compra_venda.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
