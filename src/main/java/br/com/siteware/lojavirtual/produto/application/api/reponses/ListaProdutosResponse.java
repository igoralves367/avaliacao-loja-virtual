package br.com.siteware.lojavirtual.produto.application.api.reponses;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.siteware.lojavirtual.produto.domain.Produto;
import lombok.Value;
@Value
public class ListaProdutosResponse {
	private UUID IdProduto;
	private String nomeProduto;
	private BigDecimal preco;
	
	public static List<ListaProdutosResponse> converte(List<Produto> produtos) {
		return produtos.stream()
				.map(ListaProdutosResponse::new)
				.collect(Collectors.toList());
	}

	public ListaProdutosResponse(Produto produto) {
		IdProduto = produto.getIdProduto();
		this.nomeProduto = produto.getNomeProduto();
		this.preco = produto.getPreco();
	}
}
