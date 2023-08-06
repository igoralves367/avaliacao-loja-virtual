package br.com.siteware.lojavirtual.carrinho.application.api.requests;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ItemCarrinhoRequest {
	@NotNull
    private UUID idProduto;
	
    @NotNull(message = "Insira a quantidade do produto")
    private Double quantidade;
}
