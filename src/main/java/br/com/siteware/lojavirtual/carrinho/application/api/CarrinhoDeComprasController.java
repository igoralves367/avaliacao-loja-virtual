package br.com.siteware.lojavirtual.carrinho.application.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoResponse;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
public class CarrinhoDeComprasController implements CarrinhoDeComprasAPI {

	@Override
	public CarrinhoResponse criarCarrinho() {
		log.info("[start] CarrinhoDeComprasController - criaCarrinhoDeCompras");
		log.info("[finish] CarrinhoDeComprasController - criaCarrinhoDeCompras");
		return null;
	}
}
