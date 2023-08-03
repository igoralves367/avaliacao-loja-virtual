package br.com.siteware.lojavirtual.produto.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.siteware.lojavirtual.handler.APIException;
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
	    log.info("[inicia] ProdutoInfraRepository - salva ");
	    try {
	        produtoSpringDataJPARepository.save(produto);
	        log.info("[sucesso] ProdutoInfraRepository - salva: Produto cadastrado com sucesso: {}", produto.getIdProduto());
	        return produto;
	    } catch (DataIntegrityViolationException e) {
	        log.error("[erro] ProdutoInfraRepository - salva: Erro ao salvar produto: {}", e.getMessage());
	        throw APIException.build(HttpStatus.BAD_REQUEST, "Erro ao salvar produto. Verifique os dados informados.");
	    } finally {
	        log.info("[finaliza] ProdutoInfraRepository - salva ");
	    }
	}

	@Override
	public List<Produto> listProdutos() {
		log.info("[start] ProdutoInfraRepository - listProdutos");
		List<Produto> todosProdutos = produtoSpringDataJPARepository.findAll();
		log.info("[finish] ProdutoInfraRepository - listProdutos");
		return todosProdutos;
	}

	@Override
	public Produto consultaProdutoAtravesId(UUID idProduto) {
		log.info("[start] ProdutoInfraRepository - consultaProdutoAtravesId");
		Produto produto = produtoSpringDataJPARepository.findById(idProduto)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado"));
		log.info("[finish] ProdutoInfraRepository - consultaProdutoAtravesId");
		return produto;
	}

	@Override
	public void deleteProduto(Produto produto) {
		log.info("[start] ProdutoInfraRepository - deleteProduto");
		log.info("[finish] ProdutoInfraRepository - deleteProduto");
	}
}
