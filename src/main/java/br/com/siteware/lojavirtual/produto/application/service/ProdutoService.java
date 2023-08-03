package br.com.siteware.lojavirtual.produto.application.service;

import java.util.List;
import java.util.UUID;

import br.com.siteware.lojavirtual.produto.application.api.reponses.ConsultaProdutoResponse;
import br.com.siteware.lojavirtual.produto.application.api.reponses.ListaProdutosResponse;
import br.com.siteware.lojavirtual.produto.application.api.reponses.ProdutoResponse;
import br.com.siteware.lojavirtual.produto.application.api.requests.ProdutoAlteracaoRequest;
import br.com.siteware.lojavirtual.produto.application.api.requests.ProdutoRequest;

public interface ProdutoService {
	ProdutoResponse criaProduto(ProdutoRequest produtoRequest);
	List<ListaProdutosResponse> listaProdutos();
	ConsultaProdutoResponse consultaProdutoAtravesId(UUID idProduto);
	void alteraProduto(UUID idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest);
}
