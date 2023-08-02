package br.com.siteware.lojavirtual.produto.application.api.reponses;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Value;

@Value
public class ConsultaProdutoResponse {
	private UUID IdProduto;
	private String nomeProduto;
	private BigDecimal preco;
	private Integer quantidadeProduto;
}
