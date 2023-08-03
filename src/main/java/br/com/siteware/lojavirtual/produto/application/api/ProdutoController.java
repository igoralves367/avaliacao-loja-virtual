package br.com.siteware.lojavirtual.produto.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.lojavirtual.produto.application.api.reponses.ConsultaProdutoResponse;
import br.com.siteware.lojavirtual.produto.application.api.reponses.ListaProdutosResponse;
import br.com.siteware.lojavirtual.produto.application.api.reponses.ProdutoResponse;
import br.com.siteware.lojavirtual.produto.application.api.requests.ProdutoAlteracaoRequest;
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

	@Override
	public List<ListaProdutosResponse> listaProdutos() {
		log.info("[start] ProdutoController - listaProdutos");
		List<ListaProdutosResponse> produtos = produtoService.listaProdutos();
		log.info("[finish] ProdutoController - listaProdutos");
		return produtos;
	}

	@Override
	public ConsultaProdutoResponse consultaProdutoAtravesId(UUID idProduto) {
		log.info("[start] ProdutoController - consultaProdutoAtravesId");
		log.info("[idPessoa] {}", idProduto);
		ConsultaProdutoResponse  consultaProduto = produtoService.consultaProdutoAtravesId(idProduto);
		log.info("[finish] ProdutoController - consultaProdutoAtravesId");
		return consultaProduto;
	}

	@Override
	public void alteraProduto(UUID idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest) {
		log.info("[start] ProdutoController - alteraProduto");
		log.info("[idPessoa] {}", idProduto);
		produtoService.alteraProduto(idProduto, produtoAlteracaoRequest);
		log.info("[finish] ProdutoController - alteraProduto");
	}
}
