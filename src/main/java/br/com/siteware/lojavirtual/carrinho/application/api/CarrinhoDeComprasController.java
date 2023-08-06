package br.com.siteware.lojavirtual.carrinho.application.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.CarrinhoRequest;
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
}
