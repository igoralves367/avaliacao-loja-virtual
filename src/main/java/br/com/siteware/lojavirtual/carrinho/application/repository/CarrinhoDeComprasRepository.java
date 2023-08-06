package br.com.siteware.lojavirtual.carrinho.application.repository;

import java.util.UUID;

import br.com.siteware.lojavirtual.carrinho.domain.CarrinhoDeCompras;

public interface CarrinhoDeComprasRepository {
	CarrinhoDeCompras buscaCarrinhoPorId(UUID idCarrinhoDeCompras);
	CarrinhoDeCompras salvaCarrinho(CarrinhoDeCompras carrinhoDeCompras);
	void atualizaItensDoCarrinho(CarrinhoDeCompras carrinhoDeCompras);
}