package br.com.siteware.lojavirtual.carrinho.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoItemResponse;
import br.com.siteware.lojavirtual.carrinho.domain.CarrinhoDeCompras;

public interface CarrinhoDeComprasRepository {
	CarrinhoDeCompras buscaCarrinhoPorId(UUID idCarrinhoDeCompras);
	CarrinhoDeCompras salvaCarrinho(CarrinhoDeCompras carrinhoDeCompras);
	List<CarrinhoItemResponse> consultarItensDoCarrinho(UUID idCarrinhoDeCompras);
}