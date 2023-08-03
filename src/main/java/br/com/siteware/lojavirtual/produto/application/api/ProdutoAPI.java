package br.com.siteware.lojavirtual.produto.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.lojavirtual.produto.application.api.reponses.ConsultaProdutoResponse;
import br.com.siteware.lojavirtual.produto.application.api.reponses.ListaProdutosResponse;
import br.com.siteware.lojavirtual.produto.application.api.reponses.ProdutoResponse;
import br.com.siteware.lojavirtual.produto.application.api.requests.ProdutoAlteracaoRequest;
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
	
	@GetMapping(value = "/{idProduto}")
	@ResponseStatus(code = HttpStatus.OK)
	ConsultaProdutoResponse consultaProdutoAtravesId(@PathVariable UUID idProduto);
	
	@PatchMapping(value = "/{idProduto}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void alteraProduto(@PathVariable UUID idProduto,
					   @Valid @RequestBody ProdutoAlteracaoRequest produtoAlteracaoRequest);
}
