package br.com.siteware.lojavirtual.produto.service;

import javax.validation.Valid;

import br.com.siteware.lojavirtual.produto.api.reponses.ProdutoResponse;
import br.com.siteware.lojavirtual.produto.api.requests.ProdutoRequest;

public interface ProdutoService {
	ProdutoResponse criaProduto(@Valid ProdutoRequest produtoRequest);
}
