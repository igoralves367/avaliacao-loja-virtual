package br.com.siteware.lojavirtual.produto.application.api.reponses;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProdutoResponse {
	private UUID idProduto;
}
