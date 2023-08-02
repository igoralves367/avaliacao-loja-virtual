package br.com.siteware.lojavirtual.produto.application.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.lojavirtual.produto.application.api.reponses.ListaProdutosResponse;
import br.com.siteware.lojavirtual.produto.application.api.reponses.ProdutoResponse;
import br.com.siteware.lojavirtual.produto.application.api.requests.ProdutoRequest;

@RestController
@RequestMapping("/v1/produto")
public interface ProdutoAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ProdutoResponse postProduto(@Valid @RequestBody ProdutoRequest produtoRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<ListaProdutosResponse> listaProdutos();
}
