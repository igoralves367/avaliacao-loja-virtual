package br.com.siteware.lojavirtual.carrinho.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.CarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.service.PromocaoStrategy;
import br.com.siteware.lojavirtual.handler.APIException;
import br.com.siteware.lojavirtual.produto.application.repository.ProdutoRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CarrinhoDeCompras {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idCarrinhoDeCompras;
	
	@CPF(message = "Insira um cpf valido")
	private String cpf;

	@OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemCarrinho> itens;

	private LocalDateTime dataHoraAbertura;
	private LocalDateTime dataHoraDaUltimaAlteracao;

	public CarrinhoDeCompras(CarrinhoRequest carrinhoRequest) {
		this.itens = new ArrayList<>();
		this.cpf = carrinhoRequest.getCpf();
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

	public void alteraItem(ItemCarrinhoRequest itemCarrinhoRequest, ProdutoRepository produtoRepository,
			PromocaoStrategy promocaoStrategy) {
		if (itemJaExisteNoCarrinho(itemCarrinhoRequest)) {
			removeItem(itemCarrinhoRequest.getIdProduto());
			adicionaItem(itemCarrinhoRequest, produtoRepository, promocaoStrategy);
		} else {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Não existe esse produto no carrinho");
		}
	}

	public void removeItem(UUID idProduto) {
		this.itens.removeIf(i -> i.getIdProduto().equals(idProduto));
	}

	private Boolean itemJaExisteNoCarrinho(ItemCarrinhoRequest itemCarrinhoRequest) {
		return this.itens.stream().filter(i -> i.getIdProduto().equals(itemCarrinhoRequest.getIdProduto())).findFirst()
				.isPresent();
	}
}
