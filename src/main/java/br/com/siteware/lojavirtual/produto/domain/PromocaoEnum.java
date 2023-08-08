package br.com.siteware.lojavirtual.produto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PromocaoEnum {
	LEVE_DOIS_PAGUE_UM("Leve 2 e Pague 1"), TRES_POR_DEZ("3 por 10 reais");
	
	private String descricao;
}
