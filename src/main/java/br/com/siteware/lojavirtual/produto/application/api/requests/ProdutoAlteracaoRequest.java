package br.com.siteware.lojavirtual.produto.application.api.requests;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;
import lombok.Value;
@Value
public class ProdutoAlteracaoRequest {
	@NotBlank(message = "Insira o nome do produto")
	private String nomeProduto;
	@NotNull(message = "Insira o preco do produto")
	private BigDecimal preco;
	private PromocaoEnum promocao;
}
