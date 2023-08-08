package br.com.siteware.lojavirtual.produto.application.api.reponses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.siteware.lojavirtual.produto.domain.Produto;
import lombok.Value;

@Value
public class ConsultaProdutoResponse {
	private UUID IdProduto;
	private String nomeProduto;
	private BigDecimal preco;
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	public ConsultaProdutoResponse(Produto produto) {
		this.IdProduto = produto.getIdProduto();
		this.nomeProduto = produto.getNomeProduto();
		this.preco = produto.getPreco();
		this.dataHoraDoCadastro = produto.getDataHoraDoCadastro();
		this.dataHoraDaUltimaAlteracao = produto.getDataHoraDaUltimaAlteracao();
	}
}
