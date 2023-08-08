package br.com.siteware.lojavirtual.carrinho.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siteware.lojavirtual.carrinho.domain.ItemCarrinho;

public interface ItemCarrinhoSpringDataJPARepository extends JpaRepository <ItemCarrinho, UUID>{
	
}
