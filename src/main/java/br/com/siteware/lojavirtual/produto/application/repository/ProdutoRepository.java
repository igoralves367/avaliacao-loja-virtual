package br.com.siteware.lojavirtual.produto.application.repository;

import br.com.siteware.lojavirtual.produto.domain.Produto;

public interface ProdutoRepository {
	Produto salva(Produto produto);
}
