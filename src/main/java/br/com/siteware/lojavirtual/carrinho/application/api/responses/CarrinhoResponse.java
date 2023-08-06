package br.com.siteware.lojavirtual.carrinho.application.api.responses;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CarrinhoResponse {
	private UUID idCarrinhoDeCompras;
}
