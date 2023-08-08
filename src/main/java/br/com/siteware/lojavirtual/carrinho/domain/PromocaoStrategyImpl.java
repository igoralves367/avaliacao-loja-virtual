package br.com.siteware.lojavirtual.carrinho.domain;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import br.com.siteware.lojavirtual.carrinho.application.service.PromocaoStrategy;
import br.com.siteware.lojavirtual.handler.APIException;
import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Component
@RequiredArgsConstructor
@Log4j2
public class PromocaoStrategyImpl implements PromocaoStrategy {
	private final List<CalculadorPrecoPromocional> calculadores;;

	@Override 
	public CalculadorPrecoPromocional geCalculadorPrecoPromocional(PromocaoEnum PromocaoEnum) {
		 log.info("[start] PromocaoStrategyImpl - geCalculadorPrecoPromocional");
		try {
            return calculadores.parallelStream()
                    .filter(c -> c.possuiTipo(PromocaoEnum))
                    .findFirst()
                    .orElseThrow();
        } catch (Exception e) {
        	log.error("[error] PromocaoStrategyImpl - geCalculadorPrecoPromocional: {}", e.getMessage());
            throw APIException.build(HttpStatus.INTERNAL_SERVER_ERROR,"ERROR!",e);
        } finally {
         log.info("[finish] PromocaoStrategyImpl - geCalculadorPrecoPromocional");
        }
	}
}
