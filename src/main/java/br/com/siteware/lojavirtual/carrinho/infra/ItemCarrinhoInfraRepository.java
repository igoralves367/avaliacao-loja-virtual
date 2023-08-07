package br.com.siteware.lojavirtual.carrinho.infra;

import org.springframework.stereotype.Repository;

import br.com.siteware.lojavirtual.carrinho.application.repository.ItemCarrinhoRepository;
import br.com.siteware.lojavirtual.carrinho.domain.ItemCarrinho;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@Log4j2
@RequiredArgsConstructor
public class ItemCarrinhoInfraRepository implements ItemCarrinhoRepository {
	private final ItemCarrinhoSpringDataJPARepository itemCarrinhoSpringDataJPARepository;

	@Override
	public void saveItem(ItemCarrinho item) {
		log.info("[start] ItemCarrinhoInfraRepository - saveItem");
		itemCarrinhoSpringDataJPARepository.save(item);
		log.info("[finish] ItemCarrinhoInfraRepository - saveItem");
	}
}