package br.com.siteware.lojavirtual.carrinho.infra;

import org.springframework.stereotype.Repository;

import br.com.siteware.lojavirtual.carrinho.application.repository.CarrinhoDeComprasRepository;
import br.com.siteware.lojavirtual.carrinho.domain.CarrinhoDeCompras;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CarrinhoDeComprasInfraRepository implements CarrinhoDeComprasRepository {
	private final CarrinhoDeComprasSpringDataJPARepository carrinhoDeComprasSpringDataJPARepository;

	@Override
	public CarrinhoDeCompras salva(CarrinhoDeCompras carrinhoDeCompras) {
		log.info("[start] CarrinhoDeComprasInfraRepository - salva");
		CarrinhoDeCompras carrinhoSalvo = carrinhoDeComprasSpringDataJPARepository.save(carrinhoDeCompras);
		log.info("[finish] CarrinhoDeComprasInfraRepository - salva");
		return carrinhoSalvo;
	}
}
