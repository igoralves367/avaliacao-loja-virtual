package br.com.siteware.lojavirtual.produto.infra;

import org.springframework.stereotype.Repository;

import br.com.siteware.lojavirtual.produto.application.repository.ProdutoRepository;
import br.com.siteware.lojavirtual.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@Log4j2
@RequiredArgsConstructor
public class ProdutoInfraRepository implements ProdutoRepository {
	private final ProdutoSpringDataJPARepository produtoSpringDataJPARepository; 

	@Override
	public Produto salva(Produto produto) {
		log.info("[start] ProdutoInfraRepository - salva");
		produtoSpringDataJPARepository.save(produto);
		log.info("[finish] ProdutoInfraRepository - salva");
		return produto;
	}
}
