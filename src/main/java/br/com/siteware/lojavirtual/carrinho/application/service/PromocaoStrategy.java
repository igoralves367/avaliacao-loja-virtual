package br.com.siteware.lojavirtual.carrinho.application.service;

import br.com.siteware.lojavirtual.carrinho.domain.CalculadorPrecoPromocional;
import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;

public interface PromocaoStrategy {
	CalculadorPrecoPromocional geCalculadorPrecoPromocional(PromocaoEnum promocao);
}
