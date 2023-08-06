package br.com.siteware.lojavirtual.carrinho.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoResponse;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.ItemCarrinhoResponse;
import br.com.siteware.lojavirtual.carrinho.application.service.CarrinhoDeComprasService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequiredArgsConstructor
public class CarrinhoDeComprasController implements CarrinhoDeComprasAPI {
	private final CarrinhoDeComprasService carrinhoDeComprasService; 

	@Override
	public CarrinhoResponse criarCarrinho() {
		log.info("[start] CarrinhoDeComprasController - criaCarrinhoDeCompras");
		CarrinhoResponse carrinhoResponse = carrinhoDeComprasService.criaCarrinhoDeCompras();
		log.info("[finish] CarrinhoDeComprasController - criaCarrinhoDeCompras");
		return carrinhoResponse;
	}

	@Override
	public ItemCarrinhoResponse adicionaItensAoCarrinho(UUID idCarrinhoDeCompras, List<ItemCarrinhoRequest> itens) {
		log.info("[start] CarrinhoDeComprasController - adicionaItensAoCarrinho");
		ItemCarrinhoResponse itemCarrinho = carrinhoDeComprasService.adicionaItensAoCarrinho(idCarrinhoDeCompras, itens);
        log.info("[finish] CarrinhoDeComprasController - adicionaItensAoCarrinho");
		return itemCarrinho;
	}
}
