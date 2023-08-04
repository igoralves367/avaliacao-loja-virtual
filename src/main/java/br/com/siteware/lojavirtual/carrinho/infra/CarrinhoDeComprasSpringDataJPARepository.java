package br.com.siteware.lojavirtual.carrinho.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siteware.lojavirtual.carrinho.domain.CarrinhoDeCompras;

public interface CarrinhoDeComprasSpringDataJPARepository extends JpaRepository <CarrinhoDeCompras, UUID>{

}
