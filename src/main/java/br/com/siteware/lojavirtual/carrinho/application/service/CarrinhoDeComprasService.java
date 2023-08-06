package br.com.siteware.lojavirtual.carrinho.application.service;

import java.util.List;
import java.util.UUID;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoResponse;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.ItemCarrinhoResponse;

public interface CarrinhoDeComprasService {
	CarrinhoResponse criaCarrinhoDeCompras();
	ItemCarrinhoResponse adicionaItensAoCarrinho(UUID idCarrinhoDeCompras, List<ItemCarrinhoRequest> itens);
}
