package br.com.siteware.lojavirtual.carrinho.application.api.requests;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Value;

@Value
public class CarrinhoRequest {
	@CPF(message = "Insira um cpf valido")
	private String cpf;
}
