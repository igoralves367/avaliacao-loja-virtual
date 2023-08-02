package br.com.siteware.lojavirtual.produto.application.service;

import br.com.siteware.lojavirtual.produto.application.api.reponses.ProdutoResponse;
import br.com.siteware.lojavirtual.produto.application.api.requests.ProdutoRequest;

public interface ProdutoService {
	ProdutoResponse criaProduto(ProdutoRequest produtoRequest);
}
