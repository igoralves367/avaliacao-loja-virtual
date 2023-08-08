package br.com.siteware.lojavirtual.carrinho.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoItemResponse;
import br.com.siteware.lojavirtual.carrinho.domain.CarrinhoDeCompras;

public interface CarrinhoDeComprasSpringDataJPARepository extends JpaRepository <CarrinhoDeCompras, UUID>{
	@Query("SELECT new br.com.siteware.lojavirtual.carrinho.application.api.responses.CarrinhoItemResponse(i.idItemCarrinho, i.idProduto, i.nomeProduto, i.quantidade, i.precoUnitario, i.promocao, i.precoTotalBruto, i.precoTotalLiquido, i.desconto) FROM CarrinhoDeCompras c JOIN c.itens i WHERE c.idCarrinhoDeCompras = :idCarrinhoDeCompras")
	List<CarrinhoItemResponse> consultarItensDoCarrinho(UUID idCarrinhoDeCompras);

}
