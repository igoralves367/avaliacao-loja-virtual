package br.com.siteware.lojavirtual.produto.application.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.siteware.lojavirtual.produto.domain.Produto;

public interface ProdutoRepository {
	Produto salva(Produto produto);
	List<Produto> listProdutos();
	Produto consultaProdutoAtravesId(UUID idProduto);
	Optional<Produto> consultaProdutoOptionalAtravesId(UUID idProduto);
	void deleteProduto(Produto produto);
}
