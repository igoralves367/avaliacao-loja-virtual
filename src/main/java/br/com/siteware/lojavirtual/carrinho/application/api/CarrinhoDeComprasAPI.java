package br.com.siteware.lojavirtual.carrinho.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.siteware.lojavirtual.carrinho.application.api.requests.ItemCarrinhoRequest;
import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoResponse;

@RestController
@RequestMapping("/v1/carrinho")
public interface CarrinhoDeComprasAPI {
	
	@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarrinhoResponse criarCarrinho();
	
	@PostMapping("/{idCarrinhoDeCompras}/itens")
    @ResponseStatus(code = HttpStatus.OK)
    void adicionaItensAoCarrinho(@PathVariable UUID idCarrinhoDeCompras,
    		@RequestBody List<ItemCarrinhoRequest> itemCarrinhoRequest);
	
}
