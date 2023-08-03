package br.com.siteware.lojavirtual.carrinho.application.api.responses;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Value;
@Value
public class ItemCarrinhoResponse {
	private UUID idProduto;
	private String nomeProduto;
    private Integer quantidade;
    private BigDecimal valorTotalItem;
}
