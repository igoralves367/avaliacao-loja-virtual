package br.com.siteware.lojavirtual.carrinho.application.service;

import org.springframework.stereotype.Service;

import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoResponse;
import br.com.siteware.lojavirtual.carrinho.application.repository.CarrinhoDeComprasRepository;
import br.com.siteware.lojavirtual.carrinho.domain.CarrinhoDeCompras;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoDeComprasApplicationService implements CarrinhoDeComprasService {
	private final CarrinhoDeComprasRepository carrinhoDeComprasRepository;

	@Override
	public CarrinhoResponse criaCarrinhoDeCompras() {
		log.info("[start] CarrinhoDeComprasApplicationService - criaCarrinhoDeCompras");
		CarrinhoDeCompras carrinhoDeCompras = CarrinhoDeCompras.criarNovoCarrinhoDeCompras();
	    CarrinhoDeCompras carrinhoSalvo = carrinhoDeComprasRepository.salva(carrinhoDeCompras);
	    log.info("[finish] CarrinhoDeComprasApplicationService - criaCarrinhoDeCompras");
	    return new CarrinhoResponse(carrinhoSalvo.getIdCarrinhoDeCompras());
	}
}
