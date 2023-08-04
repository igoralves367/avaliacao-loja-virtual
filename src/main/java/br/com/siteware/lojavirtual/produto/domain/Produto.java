package br.com.siteware.lojavirtual.produto.domain;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.siteware.lojavirtual.produto.application.api.requests.ProdutoAlteracaoRequest;
import br.com.siteware.lojavirtual.produto.application.api.requests.ProdutoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idProduto;
	@NotBlank(message = "Insira o nome do produto")
	private String nomeProduto;
	@NotNull(message = "Insira o preco do produto")
	private BigDecimal preco;
	@NotNull(message = "Insira a quantidade do produto")
	private Integer quantidadeProduto;
	
	private LocalDateTime dataHoraDoCadastro; 
	private LocalDateTime dataHoraDaUltimaAlteracao; 
	
	public Produto(ProdutoRequest produtoRequest) {
		this.nomeProduto = produtoRequest.getNomeProduto();
		this.preco = produtoRequest.getPreco();
		this.quantidadeProduto = produtoRequest.getQuantidadeProduto();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void altera(ProdutoAlteracaoRequest produtoAlteracaoRequest) {
		this.nomeProduto = produtoAlteracaoRequest.getNomeProduto();
		this.preco = produtoAlteracaoRequest.getPreco();
		this.quantidadeProduto = produtoAlteracaoRequest.getQuantidadeProduto();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
	}
}