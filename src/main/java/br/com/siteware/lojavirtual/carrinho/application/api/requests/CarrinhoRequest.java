package br.com.siteware.lojavirtual.carrinho.application.api.requests;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import br.com.siteware.lojavirtual.carrinho.domain.ItemCarrinho;
import lombok.Value;

@Value
public class CarrinhoRequest {
	@CPF(message = "Insira um cpf valido")
	private String cpf;
	private List<ItemCarrinho> itens;
}
