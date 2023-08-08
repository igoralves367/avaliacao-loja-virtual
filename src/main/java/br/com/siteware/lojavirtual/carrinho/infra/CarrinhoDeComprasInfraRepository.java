package br.com.siteware.lojavirtual.carrinho.infra;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.siteware.lojavirtual.carrinho.application.repository.CarrinhoDeComprasRepository;
import br.com.siteware.lojavirtual.carrinho.domain.CarrinhoDeCompras;
import br.com.siteware.lojavirtual.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CarrinhoDeComprasInfraRepository implements CarrinhoDeComprasRepository {
	private final CarrinhoDeComprasSpringDataJPARepository carrinhoDeComprasSpringDataJPARepository;

	@Override
	public CarrinhoDeCompras salvaCarrinho(CarrinhoDeCompras carrinhoDeCompras) {
		log.info("[start] CarrinhoDeComprasInfraRepository - salva");
		CarrinhoDeCompras carrinhoSalvo = carrinhoDeComprasSpringDataJPARepository.save(carrinhoDeCompras);
		log.info("[finish] CarrinhoDeComprasInfraRepository - salva");
		return carrinhoSalvo;
	}

	@Override
	public CarrinhoDeCompras buscaCarrinhoPorId(UUID idCarrinhoDeCompras) {
		log.info("[start] CarrinhoDeComprasInfraRepository - buscaCarrinhoPorId");
		CarrinhoDeCompras carrinhoDeCompras = carrinhoDeComprasSpringDataJPARepository.findById(idCarrinhoDeCompras)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Carrinho não encontrado"));
		log.info("[finish] CarrinhoDeComprasInfraRepository - buscaCarrinhoPorId");
		return carrinhoDeCompras;
	}
}
