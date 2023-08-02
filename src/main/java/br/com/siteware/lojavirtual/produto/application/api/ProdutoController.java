package br.com.siteware.lojavirtual.produto.application.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.lojavirtual.produto.application.api.reponses.ProdutoResponse;
import br.com.siteware.lojavirtual.produto.application.api.requests.ProdutoRequest;
import br.com.siteware.lojavirtual.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequiredArgsConstructor
public class ProdutoController implements ProdutoAPI {
	private final ProdutoService produtoService; 

	@Override
	public ProdutoResponse postProduto(@Valid ProdutoRequest produtoRequest) {
		log.info("[start] ProdutoController - postProduto");
		ProdutoResponse produtoResponse = produtoService.criaProduto(produtoRequest);
		log.info("[finish] ProdutoController - postProduto");
		return produtoResponse;
	}
}
