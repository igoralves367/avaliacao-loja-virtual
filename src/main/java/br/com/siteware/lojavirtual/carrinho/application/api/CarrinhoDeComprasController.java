package br.com.siteware.lojavirtual.carrinho.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoItemResponse;
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
	public CarrinhoResponse criarCarrinho() {
		log.info("[start] CarrinhoDeComprasController - criaCarrinhoDeCompras");
		CarrinhoResponse carrinhoResponse = carrinhoDeComprasService.criaCarrinhoDeCompras();
		log.info("[finish] CarrinhoDeComprasController - criaCarrinhoDeCompras");
		return carrinhoResponse;
	}

	@Override
	public void adicionaItensAoCarrinho(UUID idCarrinhoDeCompras, List<ItemCarrinhoRequest> itemCarrinhoRequests) {
		log.info("[start] CarrinhoDeComprasController - adicionaItensAoCarrinho");
		carrinhoDeComprasService.adicionaItensAoCarrinho(idCarrinhoDeCompras, itemCarrinhoRequests);
        log.info("[finish] CarrinhoDeComprasController - adicionaItensAoCarrinho");
	}

	@Override
	public List<CarrinhoItemResponse> consultarItensDoCarrinho(UUID idCarrinhoDeCompras) {
		log.info("[start] CarrinhoDeComprasController - consultarItensDoCarrinho");
		log.info("[idCarrinhoDeCompras] {}", idCarrinhoDeCompras);
		List<CarrinhoItemResponse> consultarItens = carrinhoDeComprasService.consultarItensDoCarrinho(idCarrinhoDeCompras);
		log.info("[finish] CarrinhoDeComprasController - consultarItensDoCarrinho");
		return consultarItens;
	}
}
