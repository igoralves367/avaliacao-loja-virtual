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

import org.hibernate.validator.constraints.br.CPF;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.CarrinhoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
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

    public CarrinhoDeCompras() {
        this.dataHoraAbertura = LocalDateTime.now();
    }

	public CarrinhoDeCompras(CarrinhoRequest carrinhoRequest) {
		this.cpf = carrinhoRequest.getCpf();
		this.dataHoraAbertura = LocalDateTime.now();
	}
}
