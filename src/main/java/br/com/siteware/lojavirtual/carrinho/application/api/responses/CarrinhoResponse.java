package br.com.siteware.lojavirtual.carrinho.application.api.responses;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import br.com.siteware.lojavirtual.carrinho.domain.CarrinhoDeCompras;
import lombok.Value;

@Value
public class CarrinhoResponse {
	private UUID idCarrinhoDeCompras;
    private List<ItemCarrinhoResponse> itens;
    private BigDecimal valorTotal;

	public CarrinhoResponse(CarrinhoDeCompras carrinhoDeCompras) {
		this.idCarrinhoDeCompras = carrinhoDeCompras.getIdCarrinhoDeCompras();
        this.itens = Collections.emptyList();
        this.valorTotal = BigDecimal.ZERO;
	}
}
