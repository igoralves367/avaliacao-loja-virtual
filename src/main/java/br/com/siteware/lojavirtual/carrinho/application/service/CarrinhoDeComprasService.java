package br.com.siteware.lojavirtual.carrinho.application.service;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.CarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoResponse;

public interface CarrinhoDeComprasService {
	CarrinhoResponse criaCarrinhoDeCompras(CarrinhoRequest carrinhoRequest);
}
