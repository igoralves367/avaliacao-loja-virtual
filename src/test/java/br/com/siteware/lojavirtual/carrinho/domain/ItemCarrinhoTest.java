package br.com.siteware.lojavirtual.carrinho.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.service.PromocaoStrategy;
import br.com.siteware.lojavirtual.produto.domain.Produto;
import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;

class ItemCarrinhoTest {
	  @Test
	    void testCalculoPrecoTotalLiquido_ComPromocao() {
	        Produto produto = Produto.builder()
	                .preco(new BigDecimal("13"))
	                .promocao(PromocaoEnum.TRES_POR_DEZ)
	                .build();
	        ItemCarrinhoRequest request = ItemCarrinhoRequest.builder()
	                .quantidade(8.0).build();
	        PromocaoStrategy promocaoStrategy = new PromocaoStrategyImpl(List.of(new CalculadorTresPorDezPromocao()));
	        ItemCarrinho itemCarrinho = new ItemCarrinho(produto, request, promocaoStrategy, null);
	        assertEquals(new BigDecimal("46"), itemCarrinho.getPrecoTotalLiquido());
	    }

	    @Test
	    void testCalculoPrecoTotalLiquido_SemPromocao() {
	        Produto produto = Produto.builder().preco(new BigDecimal("10")).build();
	        ItemCarrinhoRequest request = ItemCarrinhoRequest.builder().quantidade(5.0).build();
	        ItemCarrinho itemCarrinho = new ItemCarrinho(produto, request, null, null);

	        assertEquals(new BigDecimal("50.0"), itemCarrinho.getPrecoTotalLiquido());
	    }

	    @Test
	    void testItemCarrinhoComValoresNulos() {
	        assertThrows(NullPointerException.class, () -> new ItemCarrinho(null, null, null, null));
	    }
}
