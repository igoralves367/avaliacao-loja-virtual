package br.com.siteware.lojavirtual.produto.infra;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.siteware.lojavirtual.produto.domain.Produto;

public interface ProdutoSpringDataJPARepository extends JpaRepository <Produto, UUID> {

}
