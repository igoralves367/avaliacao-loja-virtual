package br.com.siteware.lojavirtual.carrinho.application.api.responses;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
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
}
