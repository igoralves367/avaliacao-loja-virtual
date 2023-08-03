package br.com.siteware.lojavirtual.produto.application.api.requests;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Value;
@Value
public class ProdutoAlteracaoRequest {
	@NotBlank(message = "Insira o nome do produto")
	private String nomeProduto;
	@NotNull(message = "Insira o preco do produto")
	private BigDecimal preco;
	@NotNull(message = "Insira a quantidade do produto")
	private Integer quantidadeProduto;
}
