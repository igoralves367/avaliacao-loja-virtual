package br.com.siteware.lojavirtual.carrinho.application.api.responses;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import lombok.Value;

@Value
public class CarrinhoResponse {
	private UUID idCarrinhoDeCompras;
    private List<ItemCarrinhoResponse> itens;
    private BigDecimal valorTotal;

    public CarrinhoResponse(UUID idCarrinhoDeCompras) {
        this.idCarrinhoDeCompras = idCarrinhoDeCompras;
        this.itens = Collections.emptyList();
        this.valorTotal = BigDecimal.ZERO;
    }
}
