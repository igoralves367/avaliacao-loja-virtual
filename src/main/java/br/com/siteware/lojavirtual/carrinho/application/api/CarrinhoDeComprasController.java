package br.com.siteware.lojavirtual.carrinho.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.CarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoResponse;
import br.com.siteware.lojavirtual.carrinho.application.service.CarrinhoDeComprasService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequiredArgsConstructor
public class CarrinhoDeComprasController implements CarrinhoDeComprasAPI {
	private final CarrinhoDeComprasService carrinhoDeComprasService; 

	@Override
	public CarrinhoResponse criarCarrinho(CarrinhoRequest carrinhoRequest) {
		log.info("[start] CarrinhoDeComprasController - criaCarrinhoDeCompras");
		CarrinhoResponse carrinhoResponse = carrinhoDeComprasService.criaCarrinhoDeCompras(carrinhoRequest);
		log.info("[finish] CarrinhoDeComprasController - criaCarrinhoDeCompras");
		return carrinhoResponse;
	}

	@Override
	public void adicionaItensAoCarrinho(UUID idCarrinhoDeCompras, ItemCarrinhoRequest itemCarrinhoRequests) {
		log.info("[start] CarrinhoDeComprasController - adicionaItensAoCarrinho");
		carrinhoDeComprasService.adicionaItemAoCarrinho(idCarrinhoDeCompras, itemCarrinhoRequests);
        log.info("[finish] CarrinhoDeComprasController - adicionaItensAoCarrinho");
	}

	@Override
	public CarrinhoResponse consultarCarrinho(UUID idCarrinhoDeCompras) {
		log.info("[start] CarrinhoDeComprasController - consultarCarrinho");
		log.info("[idCarrinhoDeCompras] {}", idCarrinhoDeCompras);
		CarrinhoResponse carrinhoResponse = carrinhoDeComprasService.consultarItensDoCarrinho(idCarrinhoDeCompras);
		log.info("[finish] CarrinhoDeComprasController - consultarCarrinho");
		return carrinhoResponse;
	}

	@Override
	public void alteraItemAoCarrinho(UUID idCarrinhoDeCompras, ItemCarrinhoRequest itemCarrinhoRequest) {
		log.info("[start] CarrinhoDeComprasController - alteraItemAoCarrinho");
		log.info("[idCarrinhoDeCompras] {}", idCarrinhoDeCompras);
		carrinhoDeComprasService.alteraItemAoCarrinho(idCarrinhoDeCompras, itemCarrinhoRequest);
		log.info("[finish] CarrinhoDeComprasController - alteraItemAoCarrinho");
	}
}
