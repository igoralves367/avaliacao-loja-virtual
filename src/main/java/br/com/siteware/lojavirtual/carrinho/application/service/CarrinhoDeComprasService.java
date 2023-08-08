package br.com.siteware.lojavirtual.carrinho.application.service;

import java.util.UUID;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.CarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoResponse;

public interface CarrinhoDeComprasService {
	CarrinhoResponse criaCarrinhoDeCompras(CarrinhoRequest carrinhoRequest);
	void adicionaItemAoCarrinho(UUID idCarrinhoDeCompras, ItemCarrinhoRequest itemCarrinhoRequests);
	CarrinhoResponse consultarItensDoCarrinho(UUID idCarrinhoDeCompras);
	void alteraItemAoCarrinho(UUID idCarrinhoDeCompras, ItemCarrinhoRequest itemCarrinhoRequest);
}
 