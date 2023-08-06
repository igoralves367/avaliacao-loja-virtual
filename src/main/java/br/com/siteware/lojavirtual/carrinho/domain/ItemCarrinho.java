package br.com.siteware.lojavirtual.carrinho.domain;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.service.PromocaoStrategy;
import br.com.siteware.lojavirtual.produto.domain.Produto;
import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class ItemCarrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idItemCarrinho;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrinho_id", nullable = false)
	private CarrinhoDeCompras carrinho;
	
	@NotNull
	@JoinColumn(name = "produto_id", nullable = false)
	private UUID idProduto;
	
	@NotBlank(message = "Insira o nome do produto")
	private String nomeProduto;
	
	@NotNull(message = "Insira o preco unitário do produto")
	private BigDecimal precoUnitario;
	
	@NotNull(message = "Insira a quantidade do produto")
	private Double quantidade;
	
	@Enumerated(EnumType.STRING)
	private PromocaoEnum promocao;

	@NotNull(message = "Preco total bruto")
	private BigDecimal precoTotalBruto;
	
	@NotNull(message = "Preco total Liquido")
	private BigDecimal precoTotalLiquido;
	
	@NotNull(message = "Preco desconto")
	private BigDecimal desconto;
	
	public ItemCarrinho(Produto produto, ItemCarrinhoRequest itemCarrinhoRequest, PromocaoStrategy promocaoStrategy,
			CarrinhoDeCompras carrinhoDeCompras) {
		this.carrinho = carrinhoDeCompras;
		this.idProduto = produto.getIdProduto();
		this.nomeProduto = produto.getNomeProduto();
		this.precoUnitario = produto.getPreco();
		this.quantidade = itemCarrinhoRequest.getQuantidade();
		this.promocao = produto.getPromocao();
		this.calculaPrecoTotalBruto();
		this.calculaPrecoTotalLiquido(promocaoStrategy,produto);
	}
	
	private void calculaPrecoTotalLiquido(PromocaoStrategy promocaoStrategy, Produto produto) {
		if(Optional.ofNullable(this.promocao).isPresent()){
			CalculadorPrecoPromocional calculadorPrecoPromocional = promocaoStrategy.geCalculadorPrecoPromocional(this.promocao);
			this.precoTotalLiquido = calculadorPrecoPromocional.calculaTotalLiquido(this);
			this.desconto = this.precoTotalBruto.subtract(this.precoTotalLiquido);
		} else {
			this.precoTotalLiquido = this.precoTotalBruto;
			this.desconto = BigDecimal.ZERO;
		}
	}
	
	private void calculaPrecoTotalBruto() {
		this.precoTotalBruto = this.precoUnitario.multiply(BigDecimal.valueOf(this.quantidade));
	}
}
