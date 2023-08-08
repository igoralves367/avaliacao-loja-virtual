package br.com.siteware.lojavirtual.carrinho.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.service.PromocaoStrategy;
import br.com.siteware.lojavirtual.produto.application.repository.ProdutoRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CarrinhoDeCompras {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idCarrinhoDeCompras;

	@OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemCarrinho> itens;

	private LocalDateTime dataHoraAbertura;
	private LocalDateTime dataHoraDaUltimaAlteracao;

	public CarrinhoDeCompras() {
		this.dataHoraAbertura = LocalDateTime.now();
	}

	public void adicionaItens(List<ItemCarrinhoRequest> itens, ProdutoRepository produtoRepository,
			PromocaoStrategy promocaoStrategy) {
		itens.parallelStream().forEach(i -> adicionaItem(i, produtoRepository, promocaoStrategy));
	}

	public void adicionaItem(ItemCarrinhoRequest i, ProdutoRepository produtoRepository,
			PromocaoStrategy promocaoStrategy) {
		var optionalProduto = produtoRepository.consultaProdutoOptionalAtravesId(i.getIdProduto());
		optionalProduto.ifPresent(p -> {
			ItemCarrinho newItem = new ItemCarrinho(p, i, promocaoStrategy, this);
			this.itens.add(newItem);
		});
	}
}
