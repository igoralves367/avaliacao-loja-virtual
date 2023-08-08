package br.com.siteware.lojavirtual.carrinho.domain;

import java.math.BigDecimal;

import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;

public interface CalculadorPrecoPromocional {
    BigDecimal calculaTotalLiquido(ItemCarrinho itemCarrinho);

    Boolean possuiTipo(PromocaoEnum promocaoEnum);
}
