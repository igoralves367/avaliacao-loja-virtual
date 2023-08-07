package br.com.siteware.lojavirtual.carrinho.domain;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Component
@RequiredArgsConstructor
@Log4j2
public class CalculadorLeveDoisPagueUmPromocao implements CalculadorPrecoPromocional {

	@Override
	public BigDecimal calculaTotalLiquido(@NotNull ItemCarrinho itemCarrinho) {
		log.info("[start] CalculadorLeveDoisPagueUmPromocao - calculaTotalLiquido");
        int divisaoPorDois = itemCarrinho.getQuantidade().intValue() / 2;
        int resto = itemCarrinho.getQuantidade().intValue() % 2;

        BigDecimal precoTotalLiquido = itemCarrinho.getPrecoUnitario().multiply(new BigDecimal(divisaoPorDois))
                .add(itemCarrinho.getPrecoUnitario().multiply(new BigDecimal(resto)));
        log.info("[finish] CalculadorLeveDoisPagueUmPromocao - calculaTotalLiquido");
		return precoTotalLiquido;
	}

	@Override
	public Boolean possuiTipo(PromocaoEnum promocaoEnum) {
		return PromocaoEnum.LEVE_DOIS_PAGUE_UM.equals(promocaoEnum);
	}
}
