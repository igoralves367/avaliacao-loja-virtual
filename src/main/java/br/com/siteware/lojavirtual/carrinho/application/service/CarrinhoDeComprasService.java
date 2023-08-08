package br.com.siteware.lojavirtual.carrinho.application.service;

import java.util.List;
import java.util.UUID;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoItemResponse;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoResponse;

public interface CarrinhoDeComprasService {
	CarrinhoResponse criaCarrinhoDeCompras();
	void adicionaItemAoCarrinho(UUID idCarrinhoDeCompras, ItemCarrinhoRequest itemCarrinhoRequests);
	List<CarrinhoItemResponse> consultarItensDoCarrinho(UUID idCarrinhoDeCompras);
	void alteraItemAoCarrinho(UUID idCarrinhoDeCompras, ItemCarrinhoRequest itemCarrinhoRequest);
}
 