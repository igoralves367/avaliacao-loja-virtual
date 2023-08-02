package br.com.siteware.lojavirtual.produto.application.service;

import org.springframework.stereotype.Service;

import br.com.siteware.lojavirtual.produto.application.api.reponses.ProdutoResponse;
import br.com.siteware.lojavirtual.produto.application.api.requests.ProdutoRequest;
import br.com.siteware.lojavirtual.produto.application.repository.ProdutoRepository;
import br.com.siteware.lojavirtual.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {
	private final ProdutoRepository produtoRepository; 

	@Override
	public ProdutoResponse criaProduto(ProdutoRequest produtoRequest) {
		log.info("[start] ProdutoApplicationService - criaProduto");
		Produto produto = produtoRepository.salva(new Produto(produtoRequest));
		log.info("[finish] ProdutoApplicationService - criaProduto");
		return ProdutoResponse.builder()
				.idProduto(produto.getIdProduto())
				.build();
	}
}
