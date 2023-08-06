package br.com.siteware.lojavirtual.carrinho.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

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
	public CarrinhoResponse criaCarrinhoDeCompras() {
		log.info("[start] CarrinhoDeComprasApplicationService - criaCarrinhoDeCompras");
		CarrinhoDeCompras carrinhoDeCompras = carrinhoDeComprasRepository.salvaCarrinho(new CarrinhoDeCompras());
	    log.info("[finish] CarrinhoDeComprasApplicationService - criaCarrinhoDeCompras");
	    return  CarrinhoResponse.builder()
	    		.idCarrinhoDeCompras(carrinhoDeCompras.getIdCarrinhoDeCompras())
	    		.build();
	    }

	@Override
	public void adicionaItensAoCarrinho(UUID idCarrinho, List<ItemCarrinhoRequest> itens) {
		log.info("[start] CarrinhoDeComprasApplicationService - adicionaItensAoCarrinho");
		var carrinhoDeCompras = carrinhoDeComprasRepository.buscaCarrinhoPorId(idCarrinho);
		carrinhoDeCompras.adicionaItens(itens, produtoRepository, promocaoStrategy);
		log.info("[finish] CarrinhoDeComprasApplicationService - adicionaItensAoCarrinho");
	}
}
