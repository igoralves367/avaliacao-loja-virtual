package br.com.siteware.lojavirtual.carrinho.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;

class CalculadorTresPorDezPromocaoTest {
	
    @Test
    void calculaTotalLiquido_WithValidItem_ShouldCalculateCorrectly() {
        CalculadorTresPorDezPromocao calculator = new CalculadorTresPorDezPromocao();
        ItemCarrinho itemCarrinho = ItemCarrinho.builder()
                .precoUnitario(new BigDecimal("13"))
                .quantidade(8.0)
                .build();

        BigDecimal totalLiquido = calculator.calculaTotalLiquido(itemCarrinho);

        assertEquals(new BigDecimal("46"), totalLiquido);
    }

    @Test
    void calculaTotalLiquido_WithNullItem_ShouldThrowException() {
        CalculadorTresPorDezPromocao calculator = new CalculadorTresPorDezPromocao();

        assertThrows(NullPointerException.class, () -> calculator.calculaTotalLiquido(null));
    }

    @Test
    void possuiTipo_WithMatchingPromocao_ShouldReturnTrue() {
        CalculadorTresPorDezPromocao calculator = new CalculadorTresPorDezPromocao();

        assertTrue(calculator.possuiTipo(PromocaoEnum.TRES_POR_DEZ));
    }

    @Test
    void possuiTipo_WithNonMatchingPromocao_ShouldReturnFalse() {
        CalculadorTresPorDezPromocao calculator = new CalculadorTresPorDezPromocao();

        assertFalse(calculator.possuiTipo(PromocaoEnum.LEVE_DOIS_PAGUE_UM));
    }
}
