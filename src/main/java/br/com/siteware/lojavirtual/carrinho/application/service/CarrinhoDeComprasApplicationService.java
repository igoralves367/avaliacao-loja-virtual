package br.com.siteware.lojavirtual.carrinho.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.CarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoResponse;
import br.com.siteware.lojavirtual.carrinho.application.repository.CarrinhoDeComprasRepository;
import br.com.siteware.lojavirtual.carrinho.domain.CarrinhoDeCompras;
import br.com.siteware.lojavirtual.produto.application.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoDeComprasApplicationService implements CarrinhoDeComprasService {
	private final CarrinhoDeComprasRepository carrinhoDeComprasRepository;
	private final ProdutoRepository produtoRepository;
	private final PromocaoStrategy promocaoStrategy;

	@Override
	public CarrinhoResponse criaCarrinhoDeCompras(CarrinhoRequest carrinhoRequest) {
		log.info("[start] CarrinhoDeComprasApplicationService - criaCarrinhoDeCompras");
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(carrinhoRequest);
		carrinhoDeComprasRepository.salvaCarrinho(carrinho);
		log.info("[finish] CarrinhoDeComprasApplicationService - criaCarrinhoDeCompras");
		return new CarrinhoResponse(carrinho);
	}

	@Override
	public void adicionaItemAoCarrinho(UUID idCarrinhoDeCompras, ItemCarrinhoRequest itemCarrinhoRequest) {
		log.info("[start] CarrinhoDeComprasApplicationService - adicionaItemAoCarrinho");
		var carrinhoDeCompras = carrinhoDeComprasRepository.buscaCarrinhoPorId(idCarrinhoDeCompras);
		carrinhoDeCompras.adicionaItem(itemCarrinhoRequest, produtoRepository, promocaoStrategy);
		carrinhoDeComprasRepository.salvaCarrinho(carrinhoDeCompras);
		log.info("[finish] CarrinhoDeComprasApplicationService - adicionaItemAoCarrinho");
	}

	@Override
	public CarrinhoResponse consultarItensDoCarrinho(UUID idCarrinhoDeCompras) {
		log.info("[start] CarrinhoDeComprasApplicationService - consultarItensDoCarrinho");
		carrinhoDeComprasRepository.buscaCarrinhoPorId(idCarrinhoDeCompras);
		CarrinhoDeCompras carrinhoDeCompras = carrinhoDeComprasRepository.buscaCarrinhoPorId(idCarrinhoDeCompras);
		log.info("[finish] CarrinhoDeComprasApplicationService - consultarItensDoCarrinho");
		return new CarrinhoResponse(carrinhoDeCompras);
	}

	@Override
	public void alteraItemAoCarrinho(UUID idCarrinhoDeCompras, ItemCarrinhoRequest itemCarrinhoRequest) {
		log.info("[start] CarrinhoDeComprasApplicationService - alteraItemAoCarrinho");
		var carrinhoDeCompras = carrinhoDeComprasRepository.buscaCarrinhoPorId(idCarrinhoDeCompras);
		carrinhoDeCompras.alteraItem(itemCarrinhoRequest, produtoRepository, promocaoStrategy);
		carrinhoDeComprasRepository.salvaCarrinho(carrinhoDeCompras);
		log.info("[finish] CarrinhoDeComprasApplicationService - alteraItemAoCarrinho");
	}
}
