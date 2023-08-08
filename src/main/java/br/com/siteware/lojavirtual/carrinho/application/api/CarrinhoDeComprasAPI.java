package br.com.siteware.lojavirtual.carrinho.application.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.CarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoResponse;

@RestController
@RequestMapping("/v1/carrinho")
public interface CarrinhoDeComprasAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	CarrinhoResponse criarCarrinho(@RequestBody CarrinhoRequest carrinhoRequest);

	@PostMapping("/{idCarrinhoDeCompras}/item")
	@ResponseStatus(code = HttpStatus.OK)
	void adicionaItensAoCarrinho(@PathVariable UUID idCarrinhoDeCompras,
			@RequestBody ItemCarrinhoRequest itemCarrinhoRequest);

	@GetMapping(value = "/{idCarrinhoDeCompras}")
	@ResponseStatus(code = HttpStatus.OK)
	CarrinhoResponse consultarCarrinho(@PathVariable UUID idCarrinhoDeCompras);
	
	@PatchMapping("/{idCarrinhoDeCompras}/item")
	@ResponseStatus(code = HttpStatus.OK)
	void alteraItemAoCarrinho(@PathVariable UUID idCarrinhoDeCompras,
			@RequestBody ItemCarrinhoRequest itemCarrinhoRequest);
}