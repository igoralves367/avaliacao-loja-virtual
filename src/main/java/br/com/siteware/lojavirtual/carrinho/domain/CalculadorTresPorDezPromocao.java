package br.com.siteware.lojavirtual.carrinho.domain;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;
import lombok.extern.log4j.Log4j2;
@Component
@Validated
@Log4j2
public class CalculadorTresPorDezPromocao implements CalculadorPrecoPromocional {

	@Override
	public BigDecimal calculaTotalLiquido(@NotNull ItemCarrinho itemCarrinho) {
		 log.info("[start] CalculadorTresPorDezPromocao - calculaTotalLiquido");
		 int divisaoPorTres = itemCarrinho.getQuantidade().intValue() / 3;
	        int resto = itemCarrinho.getQuantidade().intValue() % 3;

	        BigDecimal precoPromocional = new BigDecimal(10);

	        BigDecimal precoTotalLiquido = precoPromocional.multiply(new BigDecimal(divisaoPorTres))
	                .add(itemCarrinho.getPrecoUnitario().multiply(new BigDecimal(resto)));
		 log.info("[finish] CalculadorTresPorDezPromocao - calculaTotalLiquido");
		return precoTotalLiquido;
	}

	@Override
	public Boolean possuiTipo(@NotNull PromocaoEnum promocaoEnum) {
		return PromocaoEnum.TRES_POR_DEZ.equals(promocaoEnum);
	}
}
