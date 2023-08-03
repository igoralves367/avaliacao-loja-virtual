package br.com.siteware.lojavirtual.carrinho.application.api.responses;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import lombok.Value;

@Value
public class CarrinhoResponse {
	private UUID id;
    private List<ItemCarrinhoResponse> itens;
    private BigDecimal valorTotal;
}
