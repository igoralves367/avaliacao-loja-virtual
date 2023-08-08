package br.com.siteware.lojavirtual.carrinho.application.api.responses;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;
import lombok.Value;

@Value
public class ItemCarrinhoResponse {
	private UUID idItemCarrinho;
	private UUID idProduto;
	private String nomeProduto;
	private Double quantidade;
	private BigDecimal precoUnitario;
	private PromocaoEnum promocao;
	private BigDecimal precoTotalBruto;
	private BigDecimal precoTotalLiquido;
	private BigDecimal desconto;
	
	public static List<ItemCarrinhoResponse> converte(List<ItemCarrinhoResponse> itemCarrinho) {
		return itemCarrinho.stream()
				.map(ItemCarrinhoResponse::new)
				.collect(Collectors.toList());
	}

	public ItemCarrinhoResponse(ItemCarrinhoResponse itemCarrinho) {
		this.idItemCarrinho = itemCarrinho.getIdItemCarrinho();
		this.idProduto = itemCarrinho.getIdProduto();
		this.nomeProduto = itemCarrinho.getNomeProduto();
		this.quantidade = itemCarrinho.getQuantidade();
		this.precoUnitario = itemCarrinho.getPrecoUnitario();
		this.promocao = itemCarrinho.getPromocao();
		this.precoTotalBruto = itemCarrinho.getPrecoTotalBruto();
		this.precoTotalLiquido = itemCarrinho.getPrecoTotalLiquido();
		this.desconto = itemCarrinho.getDesconto();
	}
}
